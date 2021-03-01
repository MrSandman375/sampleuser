package com.renjie.sampleuser.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.renjie.sampleuser.model.entity.User;
import com.renjie.sampleuser.model.mapper.UserMapper;
import com.renjie.sampleuser.response.Success;
import com.renjie.sampleuser.service.UserService;
import com.renjie.sampleuser.util.PageObj;
import com.renjie.sampleuser.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: fan
 * @Date: 2021/3/1
 * @Description:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    Success success = new Success(false);

    /**
     * 获取全部用户列表
     *
     * @return
     */
    @Override
    public Success getUser(Map map) {
        int page = Integer.parseInt(map.get("page").toString());
        int rows = Integer.parseInt(map.get("rows").toString());
        //分页查询
        PageHelper.startPage(page, rows);
        PageInfo<User> pageInfo = new PageInfo<>(userMapper.getUser(map));
        PageObj pageObj = Utils.PageInfo2PageObj(pageInfo);
        success.setSuccess(true);
        success.setMsgCodeObj("查询成功", 200, pageObj);
        return success;
    }

    /**
     * 新增用户
     *
     * @param map
     * @return
     */
    @Override
    public Success createUser(Map<String, Object> map) {
        Date date = new Date();
        //电话号码查重
        Map<String, Object> map1 = new HashMap<>();
        map1.put("mobile", map.get("mobile").toString());
        List<User> user = userMapper.getUser(map1);
        Assert.isTrue(user.size() == 0, "该电话号码已存在");

        //校验电话号码
        Assert.isTrue(Utils.mobileNum(map.get("mobile").toString()),"手机号格式不正确");
        //校验邮箱
        Assert.isTrue(Utils.isEmail(map.get("email").toString()),"邮箱格式不正确");
        //性别校验（现有数据库性别字段是varchar型，后期可换成1或者0区分）
        Assert.isTrue(map.get("sex").equals("男") || map.get("sex").equals("女"),"性别只能为”男“或”女“");

        //这里的密码暂未做加密处理和长度、复杂度校验
        map.put("state", "1");
        map.put("createTime", date);
        map.put("updateTime", date);
        if (userMapper.createUser(map) != 0) {
            success.setSuccess(true);
            success.setMsgCode("新增成功", 200);
        }
        return success;
    }

    /**
     * 修改用户 (手机号是登陆标志，不允许修改)
     * @param map
     * @return
     */
    @Override
    public Success updateUser(Map<String, Object> map) {

        //检查用户是否存在
        User user = userMapper.queryUserById(Long.valueOf(map.get("id").toString()));
        Assert.isTrue(!ObjectUtils.isEmpty(user),"该用户不存在或已被删除");

        //修改密码
        if (map.get("password") != null){
            Assert.isTrue(!map.get("password").toString().equals(" "),"密码不能为空");
            user.setPassword(map.get("password").toString());
        }
        //修改性别
        if (map.get("sex") != null){
            //性别校验（现有数据库性别字段是varchar型，后期可换成1或者0区分）
            Assert.isTrue(map.get("sex").equals("男") || map.get("sex").equals("女"),"性别只能为”男“或”女“");
            user.setSex(map.get("sex").toString());

        }
        //修改生日
        if (map.get("birthdate") != null){
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = dateFormat.parse(map.get("birthdate").toString());
                user.setBirthdate(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //修改地址
        if (map.get("address") != null){
            user.setAddress(map.get("address").toString());
        }
        //修改邮箱
        if (map.get("email") != null){
            //校验邮箱
            Assert.isTrue(Utils.isEmail(map.get("email").toString()),"邮箱格式不正确");
            user.setEmail(map.get("email").toString());
        }
        //更新时间
        user.setUpdateTime(new Date());

        if (userMapper.updateUser(user) != 0){
            success.setSuccess(true);
            success.setMsgCode("更新成功",200);
        }
        return success;
    }

    /**
     * 删除一位用户
     * @param map
     * @return
     */
    @Override
    public Success deleteUser(Map<String, Object> map) {
        //检查用户是否存在
        User user = userMapper.queryUserById(Long.valueOf(map.get("id").toString()));
        Assert.isTrue(!ObjectUtils.isEmpty(user),"该用户不存在或已被删除");
        //更新时间
        user.setUpdateTime(new Date());
        user.setState("-1");
        if (userMapper.updateUser(user) != 0){
            success.setSuccess(true);
            success.setMsgCode("删除成功",200);
        }
        return success;
    }


}

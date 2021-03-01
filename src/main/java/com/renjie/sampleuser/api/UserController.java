package com.renjie.sampleuser.api;

import com.renjie.sampleuser.response.Success;
import com.renjie.sampleuser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Auther: fan
 * @Date: 2021/3/1
 * @Description:
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户控制器")
public class UserController extends BaseApi{

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表/按条件搜索用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    @ApiOperation("获取用户列表")
    public Success getAllUser(HttpServletRequest request){
        //必传参数
        String[] must = {"page","rows"};
        Map<String, Object> map = getParameterMap(request,must);
        //电话号码查询
        if (request.getParameter("mobile") != null && !request.getParameter("mobile").equals("")) {
            map.put("mobile", request.getParameter("mobile"));
        }
        //邮箱查找
        if (request.getParameter("email")!=null && !request.getParameter("email").equals("")) {
            map.put("email", request.getParameter("email"));
        }
        //有其他需求可添加条件
        return userService.getUser(map);
    }

    /**
     * 新增用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/createUser",method = RequestMethod.PUT)
    @ApiOperation("新增用户")
    public Success createUser(HttpServletRequest request) {
        String[] must = {"mobile","password","sex","birthdate","address","email"};
        Map<String, Object> map = getParameterMap(request,must);
        return userService.createUser(map);
    }

    /**
     * 修改一个用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户")
    public Success updateUser(HttpServletRequest request){
        String[] must = {"id"};
        Map<String,Object> map = getParameterMap(request,must);
        return userService.updateUser(map);
    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除用户")
    public Success deleteUser(HttpServletRequest request){
        String[] must = {"id"};
        Map<String,Object> map = getParameterMap(request,must);
        return userService.deleteUser(map);
    }






}

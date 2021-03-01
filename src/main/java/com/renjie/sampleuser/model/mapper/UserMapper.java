package com.renjie.sampleuser.model.mapper;

import com.renjie.sampleuser.model.IBaseMapper;
import com.renjie.sampleuser.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends IBaseMapper<User> {

    /**
     * 获取用户列表
     * @return
     */
    List<User> getUser(Map map);

    /**
     * 新增用户
     * @param map
     * @return
     */
    Integer createUser(Map map);

    /**
     * 根据id查询用户详情
     * @param id
     * @return
     */
    User queryUserById(Long id);

    /**
     * 根据用户id更新用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user);
}
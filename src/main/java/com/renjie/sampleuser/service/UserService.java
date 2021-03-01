package com.renjie.sampleuser.service;

import com.renjie.sampleuser.response.Success;

import java.util.Map;

/**
 * @Auther: fan
 * @Date: 2021/3/1
 * @Description:
 */
public interface UserService {

    /**
     * 获取用户列表
     * @return
     */
    Success getUser(Map<String, Object> map);

    /**
     * 新增用户
     * @param map
     * @return
     */
    Success createUser(Map<String, Object> map);

    /**
     * 修改用户
     * @param map
     * @return
     */
    Success updateUser(Map<String, Object> map);

    /**
     * 删除一位用户
     * @param map
     * @return
     */
    Success deleteUser(Map<String, Object> map);
}

package com.renjie.sampleuser.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "user")
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 登录名，使用电话号码作为登录名
     */
    private String mobile;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    private Date birthdate;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * -1:表示删除 ，1：正常状态
     */
    private String state;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", birthdate=" + birthdate +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", state='" + state + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
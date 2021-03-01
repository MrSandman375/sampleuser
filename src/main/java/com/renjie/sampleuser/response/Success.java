package com.renjie.sampleuser.response;

import java.io.Serializable;

/**
 * @Auther: fan
 * @Date: 2021/3/1
 * @Description:
 */
public class Success implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // 返回信息
    private String msg;

    // 信息代码
    private int code;

    // 处理成功与否
    private boolean success;

    // 返回内容
    private Object obj;

    public Success(boolean success) {
        this.success = success;
    }

    public Success(String msg) {
        this.msg = msg;
    }

    public Success(Object obj) {
        this.obj = obj;
    }

    public Success(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public Success(boolean success, String msg, int code, Object obj) {
        this.success = success;
        this.msg = msg;
        this.code = code;
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setMsgCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    public void setMsgCodeObj(String msg, int code, Object obj) {
        this.msg = msg;
        this.code = code;
        this.obj = obj;
    }

    public void clear() {
        this.success = false;
        this.msg = null;
        this.code = -1;
        this.obj = null;
    }
}

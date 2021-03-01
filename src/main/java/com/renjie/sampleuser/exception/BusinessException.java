package com.renjie.sampleuser.exception;

/**
 * @Auther: fan
 * @Date: 2021/3/1
 * @Description: 异常处理
 */
public class BusinessException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BusinessException(String message, int code) {
        super(message);
        this.code = code;
        this.message = message;
    }

}

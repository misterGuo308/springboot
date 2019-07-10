package com.example.springbootrao.common.ret;

/**
 * @author guoyou
 * @Description: 装返回对象
 * @date 2019/7/8 09:42
 */
public class RetResult<T> {

    private int code;

    private String msg;

    private T data;

    public RetResult<T> setCode(RetCode retCode) {
        this.code = retCode.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

  /*  public RetResult<T> setCode(int code) {
        this.code = code;
        return this;
    }*/

    public String getMsg() {
        return msg;
    }

    public RetResult<T> setMsg(RetMessage msg) {
        this.msg = msg.getMsg();
        return this;
    }

    public RetResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RetResult<T> setData(T data) {
        this.data = data;
        return this;
    }
}

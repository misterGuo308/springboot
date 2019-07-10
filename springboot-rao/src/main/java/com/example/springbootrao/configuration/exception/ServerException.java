package com.example.springbootrao.configuration.exception;

import com.example.springbootrao.common.ret.RetCode;
import com.example.springbootrao.common.ret.RetMessage;

/**
 * @author guoyou
 * @date 2019/7/1020:53
 */
public class ServerException extends RuntimeException {


    private RetCode code;
    private RetMessage msg;

    public ServerException() {
    }

    public ServerException(RetCode code, RetMessage msg) {
        this.code = code;
        this.msg = msg;
    }

    public RetCode getCode() {
        return code;
    }

    public void setCode(RetCode code) {
        this.code = code;
    }

    public RetMessage getMsg() {
        return msg;
    }

    public void setMsg(RetMessage msg) {
        this.msg = msg;
    }
}

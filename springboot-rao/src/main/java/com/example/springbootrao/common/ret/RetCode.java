package com.example.springbootrao.common.ret;

/**
 * @author guoyou
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @date 2019/7/8 09:42
 */
public enum RetCode {
    //成功
    SUCCESS(200),
    //失败
    FAIL(400),
    //未认证
    UNAUTHORIZED(401),
    //接口不存在
    NOT_FOUND(404);

    public int code;

    RetCode(int code) {
        this.code = code;
    }}

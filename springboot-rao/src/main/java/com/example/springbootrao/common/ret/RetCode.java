package com.example.springbootrao.common.ret;

/**
 * @author guoyou
 * @Description: 响应码枚举，参考HTTP状态码的语义
 * @date 2019/7/8 09:42
 */
public enum RetCode {

    /**
     * 重定向
     */
    NOT_EXIST(203),

    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 失败
     */
    PARAM_ERROR(400),
    /**
     * 资源找不到
     */

    NOT_FOUND(404),
    /**
     * 程序错误
     */
    DATA_ERROR(500),
    /**
     * 未登录
     */

    UNAUTHORIZED(401);
    /**
     * 状态码
     */
    private int code;

    RetCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }


}

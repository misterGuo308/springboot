package com.example.springbootrao.common.ret;

/**
 * @author guoyou
 * @date 2019/7/1021:30
 */
public enum RetMessage {
    /**
     * 增删改查等操作成功
     */
    OPT_SUCCESS("操作成功"),
    /**
     * 增删改查等操作失败
     */
    OPT_FAILURE("操作失败"),
    /**
     * 程序有异常抛出
     */
    PROGRAM_EXCEPTION("程序异常，请联系管理员"),
    /**
     * 参数校验失败 后面跟具体原因如（,A参数长度过长）
     */
    PARAM_ERORR("参数输入信息有误"),
    /**
     * 唯一性检查通过
     */
    UNIQUE("校验通过"),

    NOT_ACCONUT_PASSWORD("账号或密码错误"),
    /**
     * 唯一性检查不通过
     */
    NOT_UNIQUE("数据重复"),

    /**
     * 账户未登录
     */
    UNAUTHORIZED("账户未登录"),

    /**
     * 请重新登陆
     */
    MSG_UNKNOWN_USER("请重新登陆");


    public String msg;

    RetMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

}

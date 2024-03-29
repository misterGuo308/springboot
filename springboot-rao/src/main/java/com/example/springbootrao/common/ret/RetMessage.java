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
     * 用户姓名必须为中文且长度在2与15之间
     */
     NOT_ACCOUNT("帐号不合法(账户必须是字母开头，允许5-16字节，允许字母数字下划线)"),
    /**
     * username 请输入正确的用户名称
     */
     NOT_USER_NAME("用户姓名必须为中文且长度在2与15之间"),
    /**
     *
     */
    NOT_PASSWOED("密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)"),
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

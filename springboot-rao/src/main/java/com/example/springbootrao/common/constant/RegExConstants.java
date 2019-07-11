package com.example.springbootrao.common.constant;

/**
 * @author guoyou
 * @date 2019/7/1 19:00
 */
public class RegExConstants {

    /**
     * 手机号正则表达式
     */
    public static final String PHONE_NUMBER_REGEX = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    /**
     * 邮箱正则表达式
     */
    public static final String EMAIL_REGEX = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 身份证号验证
     */
    public static final String ID_CARD_REGEX = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
    /**
     * 帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)
     */
    public static final String ACCOUNT_REGEX = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
    /**
     * 普通密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)
     */
    public static final String PLAIN_PASSWORD_REGEX = "^[a-zA-Z]\\w{5,17}$";
    /**
     * 强密码(必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间)：^
     */
    public static final String STRONG_PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$ ";

    /**
     * 用户姓名必须为中文且长度在2与15之间
     */
    public static final String USER_NAME_REGEX = "^[\\u4e00-\\u9fa5]{2,15}$";
}

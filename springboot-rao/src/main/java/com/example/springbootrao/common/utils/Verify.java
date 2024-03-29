package com.example.springbootrao.common.utils;


import com.example.springbootrao.common.constant.RegExConstants;
import com.example.springbootrao.common.model.UserInfo;
import com.example.springbootrao.common.ret.RetCode;
import com.example.springbootrao.common.ret.RetMessage;
import com.example.springbootrao.configuration.exception.ServerException;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 参数验证
 */
public class Verify {

    /**
     * 验证参数不能为空
     *
     * @param param 待验参数
     */
    public static void paramIsNull(Object param) {
        if (param == null || param.toString().trim().length() == 0) {
            throw new ServerException(RetCode.PARAM_ERROR, RetMessage.PARAM_ERORR);
        }

    }

    /**
     * 验证任意参数为空
     *
     * @param params 待验参数
     */
    public static void paramIsAnyNull(Object... params) {
        if (Arrays.stream(params).anyMatch(p -> p == null || p.toString().trim().length() == 0)) {
            throw new ServerException(RetCode.PARAM_ERROR, RetMessage.PARAM_ERORR);
        }

    }

    /**
     * 验证参数全部为空
     *
     * @param params 待验参数
     */
    public static void paramIsAllNull(Object... params) {
        if (Arrays.stream(params).allMatch(p -> p == null || p.toString().trim().length() == 0)) {
            throw new ServerException(RetCode.PARAM_ERROR, RetMessage.PARAM_ERORR);
        }

    }

    /**
     * 账户或密码错误
     */
    public static void notAcconutPassword() {
        throw new ServerException(RetCode.PARAM_ERROR, RetMessage.NOT_ACCONUT_PASSWORD);

    }

    /**
     * 账户或密码错误
     */
    public static void notUnique() {
        throw new ServerException(RetCode.PARAM_ERROR, RetMessage.NOT_UNIQUE);

    }


    public static void registerVerify(String userName, String account, String passawred) {
        String[] params = new String[]{userName, account, passawred};
        if (Arrays.stream(params).anyMatch(p -> p == null || p.toString().trim().length() == 0)) {
            throw new ServerException(RetCode.PARAM_ERROR, RetMessage.PARAM_ERORR);
        }
        if (!userName.matches(RegExConstants.USER_NAME_REGEX)) {
            throw new ServerException(RetCode.PARAM_ERROR, RetMessage.NOT_USER_NAME);
        }
        if (!account.matches(RegExConstants.ACCOUNT_REGEX)) {
            throw new ServerException(RetCode.PARAM_ERROR, RetMessage.NOT_ACCOUNT);
        }
        if (!passawred.matches(RegExConstants.PLAIN_PASSWORD_REGEX)) {
            throw new ServerException(RetCode.PARAM_ERROR, RetMessage.NOT_PASSWOED);

        }
    }


}

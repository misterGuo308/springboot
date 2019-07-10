package com.example.springbootrao.common.utils;

import com.example.springbootrao.common.constant.SysConstants;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /**
     * 密码加密
     *
     * @param plainText
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String encrypt(String plainText) throws NoSuchAlgorithmException {

        return DESUtil.encrypt(md5(plainText), SysConstants.MD5_KEY);
    }

    /**
     * 密码解密
     *
     * @param plainText
     * @return
     */
    public static String decrypt(String plainText) {
        return DESUtil.encrypt(plainText, SysConstants.MD5_KEY);
    }

    private static String md5(String plainText) throws NoSuchAlgorithmException {
        byte[] secretBytes = null;
        secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        // 16进制数字
        String md5code = new BigInteger(1, secretBytes).toString(16);
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    public static Boolean passwordVerity(String userPassword, String dataPassword) throws NoSuchAlgorithmException {

        return encrypt(userPassword).equals(dataPassword);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(md5("1234567890"));
    }

}
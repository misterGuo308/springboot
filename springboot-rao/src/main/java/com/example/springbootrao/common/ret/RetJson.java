package com.example.springbootrao.common.ret;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: 将结果转换为封装后的对象
 * @author guoyou
 * @date 2019/7/8 09:42
 */
public class RetJson {

    private  final static String SUCCESS="成功";
    private final static  String FAIL="系统出错";
    private final static ObjectMapper objectMapper  = new ObjectMapper();


    public static<T>  String  makeOKRsp() throws JsonProcessingException {
        return objectMapper.writeValueAsString(new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS)) ;
    }

    public static <T> String makeOKRsp(T data) throws JsonProcessingException {
        return  objectMapper.writeValueAsString(new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(SUCCESS).setData(data));
    }

    public static <T> String makeErrRsp() throws JsonProcessingException {

        return objectMapper.writeValueAsString(new RetResult<T>().setCode(RetCode.FAIL).setMsg(FAIL));
    }

    public static <T> String makeRsp(RetCode code, String msg) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new RetResult<T>().setCode(code).setMsg(msg));
    }

    public static <T> String makeRsp(RetCode code, String msg, T data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new RetResult<T>().setCode(code).setMsg(msg).setData(data)) ;
    }

}

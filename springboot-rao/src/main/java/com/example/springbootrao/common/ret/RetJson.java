package com.example.springbootrao.common.ret;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: 将结果转换为封装后的对象
 * @author guoyou
 * @date 2019/7/8 09:42
 */
public class RetJson {

    private final static ObjectMapper objectMapper  = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);


    public static<T>  String  makeOKRsp() throws JsonProcessingException {
        return objectMapper.writeValueAsString(new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(RetMessage.OPT_SUCCESS)) ;
    }

    public static <T> String makeOKRsp(T data) throws JsonProcessingException {
        return  objectMapper.writeValueAsString(new RetResult<T>().setCode(RetCode.SUCCESS).setMsg(RetMessage.OPT_SUCCESS).setData(data));
    }


    public static <T> String makeErrRsp(String msg) throws JsonProcessingException {

        return objectMapper.writeValueAsString(new RetResult<T>().setCode(RetCode.PARAM_ERROR).setMsg(msg));
    }
    public static <T> String makeErrRsp() throws JsonProcessingException {

        return objectMapper.writeValueAsString(new RetResult<T>().setCode(RetCode.PARAM_ERROR).setMsg(RetMessage.OPT_FAILURE));
    }

    public static <T> String makeRsp(RetCode code, RetMessage msg) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new RetResult<T>().setCode(code).setMsg(msg));
    }

    public static <T> String makeRsp(RetCode code, String msg, T data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new RetResult<T>().setCode(code).setMsg(msg).setData(data)) ;
    }

}

package com.example.springbootrao.configuration.exception;

import com.example.springbootrao.common.ret.RetJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author guoyou
 * @date 2019/7/911:21
 */
@ControllerAdvice
public class ExceptionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultErrorHandler(Exception e) throws JsonProcessingException {
        if (e instanceof ServerException) {
            String jsonMsg = RetJson.makeRsp(((ServerException) e).getCode(), ((ServerException) e).getMsg());
            logger.info("系统自定义的信息为:"+jsonMsg);
            return jsonMsg;
        }
        e.printStackTrace();
        logger.error(e.getMessage());
        return RetJson.makeErrRsp();
    }


}

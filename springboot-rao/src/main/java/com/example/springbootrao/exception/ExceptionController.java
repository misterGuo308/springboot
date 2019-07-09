package com.example.springbootrao.exception;

import com.example.springbootrao.common.ret.RetJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
        e.printStackTrace();
        logger.error(e.getMessage());
        return RetJson.makeErrRsp();
    }


}

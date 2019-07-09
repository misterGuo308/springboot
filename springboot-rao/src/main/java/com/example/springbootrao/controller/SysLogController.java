package com.example.springbootrao.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootrao.common.model.SysLog;
import com.example.springbootrao.common.ret.RetJson;
import com.example.springbootrao.service.SysLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guoyou
 * @since 2019-07-08
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Resource
    private SysLogService sysLogService;

    @GetMapping("/selectPage")
    public String selectPage(@RequestParam("size")Integer size,@RequestParam("current")Integer current) throws JsonProcessingException {
        Page<SysLog> sysLogPage = new Page<>();
         sysLogPage.setSize(size);
         sysLogPage.setCurrent(current);
        return RetJson.makeOKRsp(sysLogService.page(sysLogPage,null));
    }




}


package com.itheima.controller;

import com.itheima.domian.SysLog;
import com.itheima.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        List<SysLog> lsit = sysLogService.findAll();
        ModelAndView mv =new ModelAndView();
        mv.addObject("sysLogs",lsit);
        mv.setViewName("syslog-list");
        return mv;
    }
}

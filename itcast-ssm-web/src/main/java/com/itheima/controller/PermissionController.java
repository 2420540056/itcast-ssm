package com.itheima.controller;

import com.itheima.domian.Permission;
import com.itheima.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/permission")
@Controller
public class PermissionController {
    /**
     * 资源权限管理
     * */
    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
    ModelAndView mv=new ModelAndView();
        List<Permission> list = permissionService.findAll();
        mv.addObject("permissionList",list);
        mv.setViewName("permission-list");
        return mv;
    }
    /**
     * 保存操作
     * */
    @RequestMapping("/save.do")
    public String save(Permission permission)throws Exception{

        permissionService.save(permission);

        return "redirect:findAll.do";
    }
}

package com.itheima.controller;

import com.itheima.domian.Permission;
import com.itheima.domian.Role;
import com.itheima.service.IPermissionService;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<Role> list = roleService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleList", list);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(value = "id", required = true) String roleId) throws Exception {
        Role role = roleService.findByRoleId(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        List<Permission> permissionList = permissionService.findOtherPermission(roleId);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId", required = true) String roleId,
                                      @RequestParam(value = "ids", required = true) String[] ids) throws Exception {
        roleService.addPermissionToRole(roleId, ids);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String roleId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.findByRoleId(roleId);
        mv.addObject("role", role);
        mv.setViewName("role-show");
        return mv;
    }
}

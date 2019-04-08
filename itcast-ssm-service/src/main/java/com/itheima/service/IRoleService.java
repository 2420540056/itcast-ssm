package com.itheima.service;

import com.itheima.domian.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll()throws Exception;

    public Role findByRoleId(String id)throws Exception;

    public void save(Role role)throws Exception;

    public void addPermissionToRole(String roleId, String[] ids) throws Exception;
}

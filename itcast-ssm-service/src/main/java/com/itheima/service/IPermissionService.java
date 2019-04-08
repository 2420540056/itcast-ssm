package com.itheima.service;

import com.itheima.domian.Permission;

import java.util.List;

public interface IPermissionService {

    public List<Permission> findAll()throws Exception;

    public void save(Permission permission)throws Exception;

    public List<Permission> findOtherPermission(String roleid)throws Exception;
}

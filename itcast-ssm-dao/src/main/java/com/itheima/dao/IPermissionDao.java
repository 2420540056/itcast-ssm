package com.itheima.dao;

import com.itheima.domian.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findByRoleId(String roleId) throws Exception;


    @Select("select*from permission")
    public List<Permission> findAll()throws Exception;


    @Insert("insert into permission(permissionname,url) values(#{permissionName},#{url})")
    public void save(Permission permission)throws Exception;

    //用于查找可以添加的权限
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findOtherPermission(String roleid)throws Exception;
}

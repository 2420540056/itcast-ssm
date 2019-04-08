package com.itheima.dao;

import com.itheima.domian.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IRoleDao {
    @Select("select *from role where id in(select roleId from users_role where userId=#{userId})")
    @Results({@Result(id = true, column = "id", property = "id"),
                @Result(column = "roleName", property = "roleName"),
                @Result(column = "roleDesc", property = "roleDesc"),
                @Result(column = "id", property = "permissions", javaType = List.class,
                        many = @Many(select = "com.itheima.dao.IPermissionDao.findByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select *from role")
    public List<Role> findAll()throws Exception;


    @Select("select *from role where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "permissions", javaType = List.class,
                    many = @Many(select = "com.itheima.dao.IPermissionDao.findByRoleId")),
            @Result(column = "id" ,property = "users",javaType = List.class,
            many = @Many( select = "com.itheima.dao.IUserDao.findByRoleId"))
    })
    public Role findByRoleId(String id)throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role)throws Exception;

    //用于绑定角色与权限的关系
    @Insert("insert into role_permission (roleId,permissionId) values (#{roleId},#{permissionId})")
    public void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;
}

package com.itheima.dao;

import com.itheima.domian.Role;
import com.itheima.domian.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IUserDao {
    @Select("select *from users where username=#{username}")
    @Results({
            @Result(id = true ,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email",property = "email"),
            @Result(column = "password",property = "password"),
            @Result(column = "phoneNum",property = "phoneNum"),
            @Result(column = "status",property = "status"),
            @Result(column = "id",property = "roles" ,javaType = java.util.List.class,
                    many = @Many(select = "com.itheima.dao.IRoleDao.findRoleByUserId")),
    })
    public UserInfo findByuserName(String userName) throws Exception;

    /**
     * 查询所有用户
     * */
    @Select("select *from users")
    public List<UserInfo> findAll() throws Exception;
    /**
     * 添加用户
     * */
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo) throws Exception;



    @Select("select *from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "email", property = "email"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many =
            @Many(select = "com.itheima.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findById(String id) throws Exception;
    /**
     * 查询除当前用户外的其他角色
     * */
    @Select("select *from role where id not in (select roleId from users_role where userId=#{userId})")
    public List<Role> findOtherRoles(String userId)throws Exception;

    /*
    * 给用户关联角色
    * **/
    @Insert("insert into users_role values(#{userId},#{roleId})")
    public void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;

    @Select("select * from users where id in (select userId from users_role where roleId=#{roleId})")
    public List<UserInfo> findByRoleId(String roleId)throws Exception;
}

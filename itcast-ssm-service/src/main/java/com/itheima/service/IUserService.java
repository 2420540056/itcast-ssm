package com.itheima.service;

import com.itheima.domian.Role;
import com.itheima.domian.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public List<UserInfo> findAll() throws Exception;

    public void save(UserInfo userInfo) throws Exception;

    public UserInfo findById(String id) throws Exception;

    public List<Role> findOtherRoles(String userId)throws Exception;

    public void addRoleToUser(String userId,String[] roleId) throws Exception;
}

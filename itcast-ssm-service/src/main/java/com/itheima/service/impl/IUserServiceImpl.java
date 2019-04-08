package com.itheima.service.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domian.Role;
import com.itheima.domian.UserInfo;
import com.itheima.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=null;
        try {
            userInfo  = iUserDao.findByuserName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<SimpleGrantedAuthority> authority = getAuthority(userInfo.getRoles());
        //处理用户对象封装成UserDetails
        //
        User user =new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,authority);
        return user;
    }
    /**
     * 装入角色描述
     * 返回list集合
     * */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        for(Role role:roles){
            String roleName = role.getRoleName();
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception{
        List<UserInfo> userInfos = iUserDao.findAll();
        return userInfos;
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        //保存时对密码进行加密处理
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        iUserDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        UserInfo userInfo = iUserDao.findById(id);
        return userInfo;
    }

    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {
        return iUserDao.findOtherRoles(userId);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            iUserDao.addRoleToUser(userId,roleId);
        }
    }


}

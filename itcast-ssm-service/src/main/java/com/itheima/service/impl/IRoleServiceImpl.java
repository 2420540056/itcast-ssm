package com.itheima.service.impl;

import com.itheima.dao.IRoleDao;
import com.itheima.domian.Role;
import com.itheima.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao iRoleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return iRoleDao.findAll();
    }

    @Override
    public Role findByRoleId(String id) throws Exception {
        return iRoleDao.findByRoleId(id);
    }

    @Override
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) throws Exception {
        for (String id : ids) {
            iRoleDao.addPermissionToRole(roleId,id);
        }
    }
}

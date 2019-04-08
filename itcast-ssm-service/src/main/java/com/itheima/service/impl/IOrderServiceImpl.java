package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.itheima.dao.IOrderDao;
import com.itheima.domian.Orders;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class IOrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao iOrderDao;
/**
 * 分页查询表信息
 * */
    @Override
    public List<Orders> findAllByPage(int page, int pagesize)throws Exception {
        PageHelper.startPage(page,pagesize);
        return iOrderDao.findAll();
    }

    @Override
    public Orders finById(String id) throws Exception {
        Orders order = iOrderDao.findById(id);
        return order;
    }

}

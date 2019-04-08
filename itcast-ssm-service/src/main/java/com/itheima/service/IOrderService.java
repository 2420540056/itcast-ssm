package com.itheima.service;

import com.itheima.domian.Orders;

import java.util.List;

public interface IOrderService {
    List<Orders> findAllByPage(int page, int pagesize)throws Exception;
    Orders finById(String id) throws Exception;
}

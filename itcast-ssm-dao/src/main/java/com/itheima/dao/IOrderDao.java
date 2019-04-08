package com.itheima.dao;


import com.itheima.domian.Member;
import com.itheima.domian.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {


    @Select("select * from orders")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product",
                    one = @One(select =
                            "com.itheima.dao.IProductDao.findById"))
    })
    List<Orders> findAll() throws Exception;

    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "orderNum", property = "orderNum"),
            @Result(column = "orderTime", property = "orderTime"),
            @Result(column = "orderStatus", property = "orderStatus"),
            @Result(column = "peopleCount", property = "peopleCount"),
            @Result(column = "payType", property = "payType"),
            @Result(column = "orderDesc", property = "orderDesc"),
            @Result(column = "productId", property = "product",
                    one = @One(select =
                            "com.itheima.dao.IProductDao.findById")),
            @Result(column = "memberId", property = "member", javaType = Member.class, one = @One(select = "com.itheima.dao.IMemberDao.findById")),
            @Result(column = "id", property = "travellers", javaType = java.util.List.class, many = @Many(select = "com.itheima.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String id) throws Exception;

}

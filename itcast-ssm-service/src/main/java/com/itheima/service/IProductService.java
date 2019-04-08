package com.itheima.service;

import com.itheima.domian.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll() throws Exception;
    void save(Product product)throws Exception;
}

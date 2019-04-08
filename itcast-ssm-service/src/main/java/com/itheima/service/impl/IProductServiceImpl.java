package com.itheima.service.impl;

import com.itheima.dao.IProductDao;
import com.itheima.domian.Product;
import com.itheima.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    /**
     * 查询所有
     * */
    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
/**
 * 存储订单信息
 * */
    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

}

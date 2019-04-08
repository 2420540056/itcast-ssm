package com.itheima.controller;

import com.itheima.domian.Product;
import com.itheima.service.IProductService;
import com.itheima.service.impl.IProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductServiceImpl iProductService;

    @RequestMapping("/findAll.do")
    public ModelAndView finAll() throws Exception {
        List<Product> list = iProductService.findAll();//调用查找方法
        ModelAndView mv = new ModelAndView();//创建ModelAndView存入查询结果
        mv.addObject("productList", list);
        mv.setViewName("product-list");
        return mv;

    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        iProductService.save(product);
        return "redirect:findAll.do";
    }

}

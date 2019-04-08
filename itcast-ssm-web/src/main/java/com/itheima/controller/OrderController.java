package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domian.Member;
import com.itheima.domian.Orders;
import com.itheima.domian.Traveller;
import com.itheima.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    /**
     * 根据分页查询
     **/
    @RolesAllowed("ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10") Integer pageSize) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<Orders> orders = iOrderService.findAllByPage(page, pageSize);
        PageInfo pageInfo = new PageInfo(orders);
        //pageInfo是一个分页的bean
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    /**
     * 查询详情页面
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
       // System.out.println("------------------------------------"+ordersId);
        Orders orders = iOrderService.finById(ordersId);
     /*   Member member = orders.getMember();
        System.out.println(member);*/
        List<Traveller> list = orders.getTravellers();
        for (Traveller traveller : list) {
            System.out.println(traveller);
        }
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
  /*  @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        List<Orders> orderslist = iOrderService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("pageInfo",orderslist);
        mv.setViewName("orders-list");
        return mv;
    }*/
}

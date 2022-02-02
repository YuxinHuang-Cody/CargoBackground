package com.cody.web;

import com.cody.pojo.Order_;
import com.cody.service.OrderService;
import com.cody.util.Page4Navigator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2022/1/17
 */

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public Page4Navigator<Order_> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "15") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Order_> page =orderService.list(start, size, 15);  //15表示导航分页最多有15个，像 [1,2,3,4,5] 这样
        return page;
    }

    @GetMapping("/order/{id}")
    public Order_ get(@PathVariable("id") int id) throws Exception {
        return orderService.get(id);
    }

    @PostMapping("/order/{id}")
    public Order_ put(Order_ bean) throws Exception {
        return orderService.update(bean);
    }

    @DeleteMapping("/order/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        orderService.delete(id);
        return null;
    }

    @PostMapping("/addOrder")
    public String add(Order_ bean, HttpServletRequest request) throws Exception {
        orderService.add(bean);
        return null;
    }

    @PostMapping("/editOrder")
    public String edit(Order_ bean, HttpServletRequest request) throws Exception {
        orderService.update(bean);
        return null;
    }

    @PostMapping("/search")
    public Page4Navigator<Order_> search(String keyword) throws Exception {
        if(null==keyword){
            keyword = "";
        }
        return orderService.search(keyword,0,20);
    }
}

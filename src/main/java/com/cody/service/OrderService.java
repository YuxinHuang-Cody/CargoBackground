package com.cody.service;

import com.cody.dao.OrderDao;
import com.cody.pojo.Order_;
import com.cody.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2022/1/14
 */
@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    public Page4Navigator<Order_> list(int start, int size, int navigatePages) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size,sort);
        Page pageFromJPA =orderDao.findAll(pageable);

        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }

    public void delete(int id) {
        orderDao.delete(id);
    }

    public void add(Order_ bean) {
        orderDao.save(bean);
    }

    public Order_ update(Order_ bean) {
        return orderDao.save(bean);
    }

    public Order_ get(int id) {
        return orderDao.findOne(id);
    }
}

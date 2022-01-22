package com.cody.dao;

import com.cody.pojo.Order_;
import com.cody.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2022/1/17
 */
public interface OrderDao extends JpaRepository<Order_,Integer> {

    User findById(String id);
}

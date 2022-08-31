package com.example.adminpage.repository;

import com.example.adminpage.AdminPageApplicationTests;
import com.example.adminpage.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends AdminPageApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailREpository;

    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
        orderDetail.setCreatedAt(LocalDateTime.now());
     /*   orderDetail.setOrderGroupId(1L); //Long -> orderGroup*/
        //orderDetail.setItemId(1L);
        orderDetail.setCreatedBy("AdminServer");

        OrderDetail newOrderDetail = orderDetailREpository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}

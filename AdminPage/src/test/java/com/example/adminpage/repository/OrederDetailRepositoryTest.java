package com.example.adminpage.repository;

import com.example.adminpage.AdminPageApplicationTests;
import com.example.adminpage.moel.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrederDetailRepositoryTest extends AdminPageApplicationTests {
    @Autowired
    private OrederDetailREpository orederDetailREpository;

    @Test
    public void create(){
        OrderDetail orderDetail=new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());

        orderDetail.setUserId(9L);
        orderDetail.setItemId(1L);
        OrderDetail newOrderDetail=orederDetailREpository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}

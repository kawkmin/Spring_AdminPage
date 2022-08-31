package com.example.adminpage.repository;

import com.example.adminpage.AdminPageApplicationTests;
import com.example.adminpage.moel.entity.OrderGroup;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderGroupRepositoryTest extends AdminPageApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    @Test
    public void create(){
        OrderGroup orderGroup=new OrderGroup();
        orderGroup.setStatus("COMPLETE");
        orderGroup.setRevAddress("서울시 강남구");
        orderGroup.setPaymentType("Card");
        orderGroup.setTotalPrice(BigDecimal.valueOf(900000));
        orderGroup.setTotalQuantity(1);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("AdminServer");
        //orderGroup.setUserId(1L);

        OrderGroup neworderGroup=orderGroupRepository.save(orderGroup);
        Assert.assertNotNull(neworderGroup);
    }
}

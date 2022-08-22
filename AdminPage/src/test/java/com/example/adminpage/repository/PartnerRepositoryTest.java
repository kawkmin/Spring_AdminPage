package com.example.adminpage.repository;

import com.example.adminpage.AdminPageApplicationTests;
import com.example.adminpage.moel.entity.Partner;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends AdminPageApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create() {
        String name="Partner01";
        String status="REGISTERED";
        String address="서울시 강남구";
        String callCenter="070-1111-2222";
        String partnerNumber="010-1111-2222";
        String businessNumber="1234567890123";
        String ceoName="홍길동";
        LocalDateTime registeredAt=LocalDateTime.now();
        LocalDateTime createdAt=LocalDateTime.now();
        String createdBy="AdminServer";
        Long categoryId=1L;

        Partner partner=new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        partner.setCategoryId(categoryId);

        Partner newpartner=partnerRepository.save(partner);
        Assert.assertNotNull(newpartner);
        Assert.assertEquals(newpartner.getName(),name);
    }

}

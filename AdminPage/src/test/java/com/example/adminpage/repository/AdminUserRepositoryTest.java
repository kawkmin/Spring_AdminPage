package com.example.adminpage.repository;

import com.example.adminpage.AdminPageApplicationTests;
import com.example.adminpage.moel.entity.AdminUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminUserRepositoryTest extends AdminPageApplicationTests {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create(){
        AdminUser adminUser=new AdminUser();
        adminUser.setAccount("AdminUser01");
        adminUser.setPassword("adminUser01");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("PARTNER");
/*        adminUser.setCreatedAt(LocalDateTime.now());
        adminUser.setCreatedBy("AdminServer");*/

        AdminUser newadminuser=adminUserRepository.save(adminUser);
        Assert.assertNotNull(newadminuser);

        newadminuser.setAccount("CHANGE");
        adminUserRepository.save(newadminuser);
    }
}

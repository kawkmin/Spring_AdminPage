package com.example.adminpage.repository;

import com.example.adminpage.AdminPageApplicationTests;
import com.example.adminpage.moel.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends AdminPageApplicationTests {

    @Autowired// DI(Dependency Injection) new 로 객체 안만들어 의존성 줄임
    private UserRepository userRepository;

    @Test
    public void create(){
        String account="Test01";
        String password="Test01";
        String status="REGISTERED";
        String email="Test01@gmail.com";
        String phoneNumber="010-1111-2222";
        LocalDateTime registeredAt=LocalDateTime.now();
        LocalDateTime createdAt=LocalDateTime.now();
        String createdBy="AdminServer";

        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newuser=userRepository.save(user);
        Assert.assertNotNull(newuser);

    }
    @Test
    @Transactional//테스트 때만 통신관련 문제
    public void read(){
        User user=userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        Assert.assertNotNull(user);


    }
    @Test
    @Transactional //롤백 시켜준다
    public void update(){
        Optional<User> user=userRepository.findById(2L);
        user.ifPresent (selectUser ->{
           selectUser.setAccount("pppp");
           selectUser.setUpdatedAt(LocalDateTime.now());
           selectUser.setUpdatedBy("Update method()");

           userRepository.save(selectUser);
        });
    }
    @Test
    @Transactional
    public void delete(){
        Optional<User> user=userRepository.findById(3L);
        Assert.assertTrue(user.isPresent()); //true 없으면 오류남
        user.ifPresent (selectUser ->{
            userRepository.delete(selectUser);
        });
        Optional<User> deleteuser=userRepository.findById(3L);
        Assert.assertFalse(deleteuser.isPresent());//false 있으면 오류남
    }
}

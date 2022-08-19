package com.example.adminpage.repository;

import com.example.adminpage.AdminPageApplicationTests;
import com.example.adminpage.moel.entity.Item;
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
        //string sql = insert into user(%s,%s,%d)value(account,email,age)
        User user=new User();
        /*user.setId(); AI라서 x */
        user.setAccount("TestUser02"); //NN
        user.setEmail("TestUser@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser2");

        User newUser=userRepository.save(user);
        System.out.println(newUser);
    }
    @Test
    @Transactional//테스트 때만 통신관련 문제
    public void read(){

        //select * from user where id = ? 라는 뜻
        Optional<User> user=userRepository.findByAccount("TestUser02");

        user.ifPresent (selectUser ->{
            selectUser.getOrderDetailList().stream().forEach(detail->{ //stream forEach는 List  형태라서
                Item item=detail.getItem();
                System.out.println(item);
            });
        });

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

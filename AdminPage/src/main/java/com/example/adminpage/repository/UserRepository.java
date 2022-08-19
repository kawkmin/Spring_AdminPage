package com.example.adminpage.repository;

import com.example.adminpage.moel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//패키지 잘못 넣어서 오류 계속 났음..
@Repository//쿼리문 자동 사용(DELETE)
public interface UserRepository extends JpaRepository<User,Long> {

    //select * from user where account=? << test03,test04
    Optional<User> findByAccount(String account); //쿼리 메소드

    Optional<User> findByEmail(String email);
    //select * from user where account=? and email = ?
    Optional<User> findByAccountAndEmail(String account,String email);
}

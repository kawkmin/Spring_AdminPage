package com.example.adminpage.repository;

import com.example.adminpage.moel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//패키지 잘못 넣어서 오류 계속 났음..
@Repository//쿼리문 사용 가능하게 만듬(DELETE 등) / DB의 값을 조정하는 계층
public interface UserRepository extends JpaRepository<User,Long> {//<대상 Entity, 그 Entity의 PK타입>

    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);

   /* //select * from user where account=? << test03,test04
    Optional<User> findByAccount(String account); //쿼리 메소드

    Optional<User> findByEmail(String email);
    //select * from user where account=? and email = ?
    Optional<User> findByAccountAndEmail(String account,String email);*/
}

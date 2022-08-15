package com.example.adminpage.repository;

import com.example.adminpage.moel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//패키지 잘못 넣어서 오류 계속 났음..
@Repository//쿼리문 자동 사용(DELETE)
public interface UserRepository extends JpaRepository<User,Long> {

}

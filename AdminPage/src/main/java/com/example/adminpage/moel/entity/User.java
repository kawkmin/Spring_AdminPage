package com.example.adminpage.moel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data //getter setter 등
@AllArgsConstructor // 생성자 자동
@Entity
/*@Table(name="user") //User도 user로 취급 가능*/
public class User {
    /*@Column(name="id")// 이름에 _가 빠져도 배정 가능*/
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    private  String account;
    private  String email;
    private  String phoneNumber; //캐멀 케이스
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}

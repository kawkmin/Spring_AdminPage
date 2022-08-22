package com.example.adminpage.moel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data //getter setter 등
@AllArgsConstructor // 매개변수 받는 생성자 자동
@NoArgsConstructor// 기본 생성자 자동
@Entity//JPA가 관리하도록 class 이름을 기반으로 SQL에 연결
/*@Table(name="user") //User도 user로 취급 가능*/
public class User {
    /*@Column(name="id")// 이름에 _가 빠져도 배정 가능*/
    @Id//기본키(PK) 할당 가능하게 만듬 / Pk 라는 표시
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 기본키 자동 생성 (기본키 생성을 데이터 베이스에게 위임)
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

   /* //1:N
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user")//orderDetail의 mto의 user와 매칭
    private List<OrderDetail> orderDetailList;//N이니까*/
}

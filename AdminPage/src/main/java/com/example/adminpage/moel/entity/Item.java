package com.example.adminpage.moel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String status;
    private String name;
    private String title;
    private String content;
    private Integer price;
    private String brandName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Long partnerId;


    //LAZY = 지연로딩 , EAGER = 즉시로딩

    //Lazy = Select * FROM item where id = ?

    //EAGER = 연관관계 모두 join 일어남 -> 성능 저하, 1:1 땐 ㄱㅊ
    /*@OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
    private List<OrderDetail> orderDetailList;*/
}

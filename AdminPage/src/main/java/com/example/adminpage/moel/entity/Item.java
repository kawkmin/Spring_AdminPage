package com.example.adminpage.moel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;
    private String content;

    //LAZY = 지연로딩 , EAGER = 즉시로딩

    //Lazy = Select * FROM item where id = ?

    //EAGER = 연관관계 모두 join 일어남 -> 성능 저하, 1:1 땐 ㄱㅊ
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}

package com.example.adminpage.moel.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity//snakecase(단어 사이의 공백을 밑줄로)를 써서 order_detail로 연결
/*@ToString(exclude = {"user","item"})//상호 참조 제외 예를 들어 user을 쓸 때, orderDetail의 user인지 user의 user인지 모름 방지*/
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    private Long itemId;
    private Long orderGroupId;

  /*  //N:1
    @ManyToOne
    private User user; //UserId x user_id 자동으로 찾아감
    @ManyToOne
    private Item item;*/
}

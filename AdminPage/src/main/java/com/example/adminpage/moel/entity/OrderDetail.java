package com.example.adminpage.moel.entity;


import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity//snakecase(단어 사이의 공백을 밑줄로)를 써서 order_detail로 연결
/*@ToString(exclude = {"user","item"})//상호 참조 제외 예를 들어 user을 쓸 때, orderDetail의 user인지 user의 user인지 모름 방지*/
@ToString(exclude = {"orderGroup", "item"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;
    @ManyToOne
    private Item item;

    @ManyToOne
    private OrderGroup orderGroup;
  /*  //N:1
    @ManyToOne
    private User user; //UserId x user_id 자동으로 찾아감
    @ManyToOne
    private Item item;*/
}

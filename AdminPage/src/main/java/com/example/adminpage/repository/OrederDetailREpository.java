package com.example.adminpage.repository;

import com.example.adminpage.moel.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrederDetailREpository extends JpaRepository<OrderDetail,Long> {
}

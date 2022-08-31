package com.example.adminpage.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PartnerApiRequest {
    private Long id;
    private String name;
    private String status;
    private String address;
    private String cellCenter;
    private String partnerNumber;
    private String BusinessNumber;
    private String ceoName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private Long categoryId;
}

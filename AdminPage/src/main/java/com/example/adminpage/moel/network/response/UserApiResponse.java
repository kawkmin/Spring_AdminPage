package com.example.adminpage.moel.network.response;

import com.example.adminpage.moel.enumclass.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserApiResponse {

    private Long id;
    private String account;
    private String password;
    private UserStatus status;
    private String email;
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;
    private List<OrderGroupApiResponse> orderGroupApiResponseList;
}

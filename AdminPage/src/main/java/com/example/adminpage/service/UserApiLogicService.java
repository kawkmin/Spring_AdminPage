package com.example.adminpage.service;

import com.example.adminpage.ifs.CrudInterface;
import com.example.adminpage.moel.entity.OrderGroup;
import com.example.adminpage.moel.entity.User;
import com.example.adminpage.moel.enumclass.UserStatus;
import com.example.adminpage.moel.network.Header;
import com.example.adminpage.moel.network.Pagination;
import com.example.adminpage.moel.network.request.UserApiRequest;
import com.example.adminpage.moel.network.response.ItemApiResponse;
import com.example.adminpage.moel.network.response.OrderGroupApiResponse;
import com.example.adminpage.moel.network.response.UserApiResponse;
import com.example.adminpage.moel.network.response.UserOrderInfoApiResponse;
import com.example.adminpage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//API User CRUD 구현
@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    @Autowired
    private ItemApiLogicService itemApiLogicService;
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        UserApiRequest userApiRequest = request.getData();
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status(UserStatus.REGISTERED)
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);

        return Header.OK(response(newUser));
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        Optional<User> optional = userRepository.findById(id);

        return optional
                .map(user -> response(user))
                .map(userApiResponse -> Header.OK(userApiResponse))
                .orElseGet(
                        () -> Header.ERROR("데이터 없음")
                );
    }


    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        //1. data
        UserApiRequest userApiRequest = request.getData();
        //2. id->user 데이터 찾기
        Optional<User> optional = userRepository.findById(userApiRequest.getId());
        return optional.map(user -> {
                    //3. update
                    user.setAccount(userApiRequest.getAccount())
                            .setPassword(userApiRequest.getPassword())
                            .setStatus(userApiRequest.getStatus())
                            .setPhoneNumber(userApiRequest.getPhoneNumber())
                            .setEmail(userApiRequest.getEmail())
                            .setRegisteredAt(userApiRequest.getRegisteredAt())
                            .setUnregisteredAt(userApiRequest.getUnregisteredAt());
                    return user;
                })
                .map(user -> userRepository.save(user)) //update->newUser
                .map(updateUser -> response(updateUser))//
                .map(userApiResponse -> Header.OK(userApiResponse))
                .orElseGet(() -> Header.ERROR("데이터 없음"));

    }

    @Override
    public Header delete(Long id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.map(user -> {
                    userRepository.delete(user);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }


    public UserApiResponse response(User user) {
        //user->userApiResponse
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unRegisteredAt(user.getUnregisteredAt())
                .build();
        return userApiResponse;
    }

    public Header<List<UserApiResponse>> search(Pageable pageable) {
        Page<User> users=userRepository.findAll(pageable);

        List<UserApiResponse> userApiResponseList=users.stream()
                .map(user->response(user))
                .collect(Collectors.toList()); //list로 변환
        //List<UserApiResponse>

        Pagination pagination= Pagination.builder()
                .totalPages(users.getTotalPages())
                .totalElements(users.getTotalElements())
                .currentPage(users.getNumber())
                .currentElements(users.getNumberOfElements())
                .build();

        return Header.OK(userApiResponseList,pagination);
    }
    public Header<UserOrderInfoApiResponse> orderInfo(Long id){
        User user=userRepository.getOne(id);
        UserApiResponse userApiResponse=response(user);

        List<OrderGroup> orderGroupList=user.getOrderGroupList();
        List<OrderGroupApiResponse> orderGroupApiResponseList=orderGroupList.stream()
                .map(orderGroup -> {
                    OrderGroupApiResponse orderGroupApiResponse=orderGroupApiLogicService.response(orderGroup).getData();
                    List<ItemApiResponse> itemApiResponseList=orderGroup.getOrderDetailList().stream()
                            .map(detail->detail.getItem())
                            .map(item->itemApiLogicService.response(item).getData())
                            .collect(Collectors.toList());

                    orderGroupApiResponse.setItemApiResponseList(itemApiResponseList);
                    return orderGroupApiResponse;
                })
                .collect(Collectors.toList());
        userApiResponse.setOrderGroupApiResponseList(orderGroupApiResponseList);
        UserOrderInfoApiResponse userOrderInfoApiResponse= UserOrderInfoApiResponse.builder()
                .userApiResponse(userApiResponse)
                .build();
        return Header.OK(userOrderInfoApiResponse);
    }
}

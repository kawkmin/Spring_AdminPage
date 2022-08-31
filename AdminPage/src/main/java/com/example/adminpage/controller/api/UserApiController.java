package com.example.adminpage.controller.api;

import com.example.adminpage.ifs.CrudInterface;
import com.example.adminpage.moel.network.Header;
import com.example.adminpage.moel.network.request.UserApiRequest;
import com.example.adminpage.moel.network.response.UserApiResponse;
import com.example.adminpage.moel.network.response.UserOrderInfoApiResponse;
import com.example.adminpage.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j //log사용 가능하게 만듬
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;

    @GetMapping("/{id}/orderInfo")
    public Header<UserOrderInfoApiResponse> orderInfo(@PathVariable Long id){
        return userApiLogicService.orderInfo(id);
    }
    @GetMapping("")
    public Header<List<UserApiResponse>> search(@PageableDefault(sort="id",direction = Sort.Direction.ASC,size=15) Pageable pageable){
        log.info("{}",pageable);
        return userApiLogicService.search(pageable);
    }

    @Override
    @PostMapping("") //api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        log.info("{} , {} ",request);
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")//api//user//{id}
    public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {
        log.info("read : {}",id);
        return userApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return userApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable(name="id") Long id) {
        log.info("delete: {} ",id);
        return userApiLogicService.delete(id);
    }
}

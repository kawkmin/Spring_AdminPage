package com.example.adminpage.controller.api;

import com.example.adminpage.controller.CrudController;
import com.example.adminpage.moel.network.request.OrderGroupApiRequest;
import com.example.adminpage.moel.network.response.OrderGroupApiResponse;
import com.example.adminpage.service.OrderGroupApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse> {

    @Autowired
    private OrderGroupApiLogicService orderGroupApiLogicService;

    public void init(){
        this.baseService=orderGroupApiLogicService;
    }
}

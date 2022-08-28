package com.example.adminpage.controller.api;

import com.example.adminpage.controller.CrudController;
import com.example.adminpage.moel.entity.OrderGroup;
import com.example.adminpage.moel.network.request.OrderGroupApiRequest;
import com.example.adminpage.moel.network.response.OrderGroupApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {


}

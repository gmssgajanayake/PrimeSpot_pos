package com.primespot.pos.service;

import com.primespot.pos.dto.requset.OrderRequestDto;
import com.primespot.pos.dto.response.OrderResponseDto;

import java.util.List;

//All orders for dealing with database.
public interface OrderService {

    //To save a new order.
    String placeOrder(OrderRequestDto orderRequestDto);

    //To update an order using ID.
    void updateOrderDetails(OrderRequestDto orderRequestDto, String id);

    //To delete an order using ID.
    void deleteOrder(String id);

    //To get all orders.
    List<OrderResponseDto> AllOrderList();
}

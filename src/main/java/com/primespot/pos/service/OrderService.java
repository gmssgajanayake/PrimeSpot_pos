package com.primespot.pos.service;

import com.primespot.pos.dto.requset.OrderRequestDto;
import com.primespot.pos.dto.response.OrderResponseDto;

import java.util.List;

public interface OrderService {
    String placeOrder(OrderRequestDto orderRequestDto);

    void updateOrderDetails(OrderRequestDto orderRequestDto, String id);

    void deleteOrder(String id);

    List<OrderResponseDto> AllOrderList();
}

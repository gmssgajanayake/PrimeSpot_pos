package com.primespot.pos.service.impl;

import com.primespot.pos.dto.requset.OrderRequestDto;
import com.primespot.pos.dto.response.OrderResponseDto;
import com.primespot.pos.entity.Orders;
import com.primespot.pos.repo.OrderRepo;
import com.primespot.pos.service.OrderService;
import com.primespot.pos.util.GeneratedIdentificationDto;
import com.primespot.pos.util.Generator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Order service interface implementation.
@Service
public class OrderServiceImpl implements OrderService {
    private final Generator generator;
    private final OrderRepo orderRepo;

    //OrderRepo and Generator is injected.
    public OrderServiceImpl(Generator generator, OrderRepo orderRepo) {
        this.generator = generator;
        this.orderRepo = orderRepo;
    }

    //To save a new customer.
    @Override
    public String placeOrder(OrderRequestDto orderRequestDto) {
        GeneratedIdentificationDto generatedIdentificationDto = generator.generatorID();
        return orderRepo.save(new Orders(
                generatedIdentificationDto.getPrefix() + "-O-" + generatedIdentificationDto.getId(),
                orderRequestDto.getCustomerId(),
                orderRequestDto.getItemId(),
                orderRequestDto.getDate(),
                orderRequestDto.getShippingAddress(),
                orderRequestDto.getShippingStatus(),
                orderRequestDto.getUnitPrice(),
                orderRequestDto.getQuantity(),
                orderRequestDto.getTax(),
                orderRequestDto.getShippingCost(),
                orderRequestDto.getTotal()
        )).getId();
    }

    //To update a customer using ID.
    @Override
    public void updateOrderDetails(OrderRequestDto orderRequestDto, String id) {
        Optional<Orders> orderRecode = orderRepo.findById(id);
        if (orderRecode.isPresent()) {
            Orders order = orderRecode.get();
            order.setDate(orderRequestDto.getDate());
            order.setCustomerId(orderRequestDto.getCustomerId());
            order.setItemId(orderRequestDto.getItemId());
            order.setQuantity(orderRequestDto.getQuantity());
            order.setShippingAddress(orderRequestDto.getShippingAddress());
            order.setShippingCost(orderRequestDto.getShippingCost());
            order.setTax(orderRequestDto.getTax());
            order.setUnitPrice(orderRequestDto.getUnitPrice());
            order.setTotal(orderRequestDto.getTotal());
            order.setShippingStatus(orderRequestDto.getShippingStatus());
            orderRepo.save(order);
        } else {
            throw new RuntimeException();
        }
    }

    //To delete an order using ID.
    @Override
    public void deleteOrder(String id) {
        orderRepo.deleteById(id);
    }

    //To get all orders.
    @Override
    public List<OrderResponseDto> AllOrderList() {
        List<OrderResponseDto> list = new ArrayList<>();
        for (Orders order : orderRepo.findAll()) {
            list.add(new OrderResponseDto(
                    order.getId(),
                    order.getCustomerId(),
                    order.getItemId(),
                    order.getDate(),
                    order.getShippingAddress(),
                    order.getShippingStatus(),
                    order.getUnitPrice(),
                    order.getQuantity(),
                    order.getTax(),
                    order.getShippingCost(),
                    order.getTotal()
            ));
        }
        return list;
    }

}

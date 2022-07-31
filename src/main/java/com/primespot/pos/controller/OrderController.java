package com.primespot.pos.controller;

import com.primespot.pos.dto.requset.OrderRequestDto;
import com.primespot.pos.service.OrderService;
import com.primespot.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/primeSpot/order")
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }

    @PostMapping
    public ResponseEntity<StandardResponse> placeOrder(@RequestBody OrderRequestDto orderRequestDto ) {
        String id = orderService.placeOrder(orderRequestDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Order placed !",id),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<StandardResponse> updateOrderDetails
            (@RequestBody OrderRequestDto orderRequestDto, @RequestParam String id) {
        orderService.updateOrderDetails(orderRequestDto, id);
        return new ResponseEntity<>(
                new StandardResponse(201, "Order Details updated !", null),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteOrder(@RequestParam String id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(
                new StandardResponse(204, "Order deleted !", null),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponse> AllItemList() {
        return new ResponseEntity<>(
                new StandardResponse(
                        200, "Order list !",
                        orderService.AllOrderList()
                ), HttpStatus.OK
        );
    }

}

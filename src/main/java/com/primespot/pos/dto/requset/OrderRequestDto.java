package com.primespot.pos.dto.requset;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//The request body of the order controller, to place an order.
@Data
@Getter
@Setter
public class OrderRequestDto {
    private String customerId;
    private String itemId;
    private String date;
    private String shippingAddress;
    private String shippingStatus;
    private int unitPrice;
    private int quantity;
    private int tax;
    private int shippingCost;
    private int total;
}

package com.primespot.pos.dto.response;

import lombok.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private String Id;
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

package com.primespot.pos.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @Column(nullable = false)
    private String Id;

    @Column(nullable = false)
    private String customerId;

    @Column(nullable = false)
    private String itemId;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String shippingAddress;

    @Column(nullable = false)
    private String shippingStatus;

    @Column(nullable = false)
    private int unitPrice;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int tax;

    @Column(nullable = false)
    private int shippingCost;

    @Column(nullable = false)
    private int total;
}

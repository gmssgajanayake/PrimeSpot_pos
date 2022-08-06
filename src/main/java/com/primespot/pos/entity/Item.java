package com.primespot.pos.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//For passing all item data to the database
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String imagePath;

    private String mainCategory;

    private String subCategory;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int QuantityOnHand;
}

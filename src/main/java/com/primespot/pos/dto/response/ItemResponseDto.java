package com.primespot.pos.dto.response;

import lombok.*;

//Item data comes through the item response dto when getting an item details.
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {
    private String id;
    private String name;
    private String description;
    private String imagePath;
    private String mainCategory;
    private String subCategory;
    private int price;
    private int QuantityOnHand;
}

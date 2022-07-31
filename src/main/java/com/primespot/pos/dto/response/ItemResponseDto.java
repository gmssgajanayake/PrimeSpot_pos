package com.primespot.pos.dto.response;

import lombok.*;

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

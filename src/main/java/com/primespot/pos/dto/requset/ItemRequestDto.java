package com.primespot.pos.dto.requset;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemRequestDto {
    private String name;
    private String description;
    private String imagePath;
    private String mainCategory;
    private String subCategory;
    private int quantity;
    private int price;
}

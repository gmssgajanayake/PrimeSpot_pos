package com.primespot.pos.service;

import com.primespot.pos.dto.requset.ItemRequestDto;
import com.primespot.pos.dto.response.ItemResponseDto;

import java.util.List;

public interface ItemService {
    String saveItem(ItemRequestDto itemRequestDto);

    void updateItem(ItemRequestDto itemRequestDto, String id);

    void deleteItem(String id);

    List<ItemResponseDto> AllItemList();
}

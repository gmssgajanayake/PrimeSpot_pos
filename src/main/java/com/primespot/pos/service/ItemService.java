package com.primespot.pos.service;

import com.primespot.pos.dto.requset.ItemRequestDto;
import com.primespot.pos.dto.response.ItemResponseDto;

import java.util.List;

//All items for dealing with database.
public interface ItemService {

    //To save a new items.
    String saveItem(ItemRequestDto itemRequestDto);

    //To update an items using ID.
    void updateItem(ItemRequestDto itemRequestDto, String id);

    //To delete an items using ID.
    void deleteItem(String id);

    //To find an items using email and password.
    List<ItemResponseDto> AllItemList();
}

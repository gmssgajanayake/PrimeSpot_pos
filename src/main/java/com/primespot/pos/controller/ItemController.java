package com.primespot.pos.controller;

import com.primespot.pos.dto.requset.ItemRequestDto;
import com.primespot.pos.service.ItemService;
import com.primespot.pos.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//The Item Controller class is created to control each item already in the store.
@RestController
@RequestMapping("api/v1/items")
@CrossOrigin
public class ItemController {
    private final ItemService itemService;

    //Item service is injected
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    //To save a new item
    @PostMapping
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemRequestDto itemRequestDto ) {
        String id = itemService.saveItem(itemRequestDto);
        return new ResponseEntity<>(
                new StandardResponse(201, "Item saved !",id),
                HttpStatus.CREATED
        );
    }

    //To update an item details using item-ID
    @PutMapping
    public ResponseEntity<StandardResponse> updateItem
            (@RequestBody ItemRequestDto itemRequestDto, @RequestParam String id) {
        itemService.updateItem(itemRequestDto, id);
        return new ResponseEntity<>(
                new StandardResponse(201, "Item updated !", null),
                HttpStatus.CREATED
        );
    }

    //To delete an item using ID
    @DeleteMapping
    public ResponseEntity<StandardResponse> deleteItem(@RequestParam String id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        "Item deleted !",
                        null
                ), HttpStatus.NO_CONTENT
        );
    }

    //To get all items
    @GetMapping
    public ResponseEntity<StandardResponse> AllItemList() {
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Item list !",
                        itemService.AllItemList()
                ), HttpStatus.OK
        );
    }
}

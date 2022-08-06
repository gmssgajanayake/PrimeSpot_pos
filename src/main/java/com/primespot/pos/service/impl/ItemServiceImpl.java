package com.primespot.pos.service.impl;

import com.primespot.pos.dto.requset.ItemRequestDto;
import com.primespot.pos.dto.response.ItemResponseDto;
import com.primespot.pos.entity.Item;
import com.primespot.pos.repo.ItemRepo;
import com.primespot.pos.service.ItemService;
import com.primespot.pos.util.GeneratedIdentificationDto;
import com.primespot.pos.util.Generator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Item service interface implementation.
@Service
public class ItemServiceImpl implements ItemService {
    private final Generator generator;
    private final ItemRepo itemRepo;

    //ItemRepo and Generator is injected
    public ItemServiceImpl(Generator generator, ItemRepo itemRepo) {
        this.generator = generator;
        this.itemRepo = itemRepo;
    }

    //To save a new items
    @Override
    public String saveItem(ItemRequestDto itemRequestDto) {
        GeneratedIdentificationDto generatedIdentificationDto = generator.generatorID();
        return itemRepo.save(new Item(
                generatedIdentificationDto.getPrefix() + "-I-" + generatedIdentificationDto.getId(),
                itemRequestDto.getName(),
                itemRequestDto.getDescription(),
                itemRequestDto.getImagePath(),
                itemRequestDto.getMainCategory(),
                itemRequestDto.getSubCategory(),
                itemRequestDto.getPrice(),
                itemRequestDto.getQuantity()
        )).getId();
    }

    //To update an items using ID
    @Override
    public void updateItem(ItemRequestDto itemRequestDto, String id) {
        Optional<Item> itemRecode = itemRepo.findById(id);
        if (itemRecode.isPresent()) {
            Item item = itemRecode.get();
            item.setName(itemRequestDto.getName());
            item.setDescription(itemRequestDto.getDescription());
            item.setImagePath(itemRequestDto.getImagePath());
            item.setMainCategory(itemRequestDto.getMainCategory());
            item.setSubCategory(itemRequestDto.getSubCategory());
            item.setPrice(itemRequestDto.getPrice());
            item.setQuantityOnHand(itemRequestDto.getQuantity());
            itemRepo.save(item);
        } else {
            throw new RuntimeException();
        }
    }

    //To delete an items using ID
    @Override
    public void deleteItem(String id) {
        itemRepo.deleteById(id);
    }

    //To find all items
    @Override
    public List<ItemResponseDto> AllItemList() {
        List<ItemResponseDto> list=new ArrayList<>();
        for (Item item:itemRepo.findAll()) {
            list.add(new ItemResponseDto(
                    item.getId(),
                    item.getName(),
                    item.getDescription(),
                    item.getImagePath(),
                    item.getMainCategory(),
                    item.getSubCategory(),
                    item.getPrice(),
                    item.getQuantityOnHand()));
        }
        return list;
    }
}

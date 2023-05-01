package com.example.spring.bootdemo.controller;

import com.example.spring.bootdemo.dto.ItemResponse;
import com.example.spring.bootdemo.entity.Item;
import com.example.spring.bootdemo.mapper.ItemMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemMapper itemMapper;

    @GetMapping("/{id}")
    public ItemResponse findById(@PathVariable int id) {
        Item item = itemMapper.findById(id);

        ItemResponse itemResponse = new ItemResponse();
        BeanUtils.copyProperties(item, itemResponse);
        return itemResponse;
    }
}

package com.example.spring.bootdemo.mapper;

import com.example.spring.bootdemo.entity.Item;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemMapper {
    Item findById(int id);
}

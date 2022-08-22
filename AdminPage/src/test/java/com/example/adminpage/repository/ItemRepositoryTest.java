package com.example.adminpage.repository;

import com.example.adminpage.AdminPageApplicationTests;
import com.example.adminpage.moel.entity.Item;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemRepositoryTest extends AdminPageApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item =new Item();
        item.setName("노트북");
        item.setPrice(100000);
        item.setContent("삼성 노트북");

        Item newItem=itemRepository.save(item);
        Assert.assertNotNull(newItem); //newitem이 Null값이면 오류
    }
    @Test
    public void read(){
        Long id=1L;
        Optional<Item> item=itemRepository.findById(id);

        Assert.assertTrue(item.isPresent());


    }
}
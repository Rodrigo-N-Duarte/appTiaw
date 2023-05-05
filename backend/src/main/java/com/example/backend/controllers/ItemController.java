package com.example.backend.controllers;

import com.example.backend.models.Item;
import com.example.backend.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;
    @PostMapping("/adicionar")
    public void adicionarItem(@RequestBody Item item){
        itemService.adicionarItem(item);
    }
}

package com.example.backend.controllers;

import com.example.backend.models.Item;
import com.example.backend.models.dto.ItemDTO;
import com.example.backend.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;
    @PostMapping("/adicionar")
    public void adicionarItem(@RequestBody Item item){
        itemService.adicionarItem(item);
    }
    @GetMapping("/buscar-por-id/{id}")
    public ItemDTO buscaPorId(@PathVariable("id") Long id){
        return itemService.buscaPorId(id);
    }
    @GetMapping("/buscar")
    public List<ItemDTO> buscaPorId(){
        return itemService.buscaTodos();
    }
}

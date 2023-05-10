package com.example.backend.services;

import com.example.backend.models.Item;
import com.example.backend.models.dto.ItemDTO;
import com.example.backend.models.dto.PedidoDTO;
import com.example.backend.repositories.CardapioRepository;
import com.example.backend.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final CardapioRepository cardapioRepository;
    public void adicionarItem(Item item){
        Item novo = new Item();
        novo.setCardapio(cardapioRepository.findById(item.getCardapio().getId()).get());
        novo.setPreco(item.getPreco());
        novo.setNome(item.getNome());

        itemRepository.save(novo);
    }
    public ItemDTO buscaPorId(Long id){
        ItemDTO dto = new ItemDTO();
        Item item = itemRepository.findById(id).get();

        dto.setId(item.getId());
        dto.setNome(item.getNome());
        dto.setPreco(item.getPreco());
        dto.setId_cardapio(item.getCardapio().getId());

        return dto;
    }
    public List<ItemDTO> buscaTodos(){
        List<Item> itens = itemRepository.findAll();
        List<ItemDTO> dtos = new ArrayList<>();

        itens.forEach(item -> {
            ItemDTO dto = new ItemDTO();

            dto.setId(item.getId());
            dto.setNome(item.getNome());
            dto.setPreco(item.getPreco());
            dto.setId_cardapio(item.getCardapio().getId());

            dtos.add(dto);
        });

        return dtos;
    }
}

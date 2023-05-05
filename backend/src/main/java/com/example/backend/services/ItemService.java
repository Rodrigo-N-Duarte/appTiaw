package com.example.backend.services;

import com.example.backend.models.Item;
import com.example.backend.repositories.CardapioRepository;
import com.example.backend.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}

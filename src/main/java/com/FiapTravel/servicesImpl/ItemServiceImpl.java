package com.FiapTravel.servicesImpl;

import com.FiapTravel.model.Item;
import com.FiapTravel.repositories.ItemRepository;
import com.FiapTravel.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("O item não pode ser nulo.");
        }
        return itemRepository.save(item);
    }

    @Override
    public List<Item> buscarTodosItens() {
        return itemRepository.findAll();
    }

    @Override
    public Optional<Item> buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do item não pode ser nulo.");
        }
        return itemRepository.findById(id);
    }

    @Override
    public Item atualizarItem(UUID id, Item item) {
        if (id == null || item == null) {
            throw new IllegalArgumentException("O ID e o item não podem ser nulos.");
        }
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            item.setIdItem(id);
            return itemRepository.save(item);
        } else {
            throw new IllegalArgumentException("Item não encontrado para o ID fornecido: " + id);
        }
    }

    @Override
    public void deletarItem(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do item não pode ser nulo.");
        }
        itemRepository.deleteById(id);
    }

}
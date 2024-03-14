package com.FiapTravel.servicesImpl;

import com.FiapTravel.model.ItemQuarto;
import com.FiapTravel.model.ItemQuartoId;
import com.FiapTravel.repositories.ItemQuartoRepository;
import com.FiapTravel.services.ItemQuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemQuartoServiceImpl implements ItemQuartoService {
    private final ItemQuartoRepository itemQuartoRepository;

    @Autowired
    public ItemQuartoServiceImpl(ItemQuartoRepository itemQuartoRepository) {
        this.itemQuartoRepository = itemQuartoRepository;
    }

    @Override
    public ItemQuarto save(ItemQuarto itemQuarto) {
        if (itemQuarto == null) {
            throw new IllegalArgumentException("O item quarto não pode ser nulo.");
        }
        return itemQuartoRepository.save(itemQuarto);
    }

    @Override
    public List<ItemQuarto> buscarTodosItensQuartos() {
        return itemQuartoRepository.findAll();
    }

    @Override
    public Optional<ItemQuarto> buscarPorId(ItemQuartoId itemQuartoId) {
        if (itemQuartoId == null) {
            throw new IllegalArgumentException("O ID do item quarto não pode ser nulo.");
        }
        return itemQuartoRepository.findById(itemQuartoId);
    }

    @Override
    public ItemQuarto atualizarItemQuarto(ItemQuartoId itemQuartoId, ItemQuarto itemQuarto) {
        if (itemQuartoId == null || itemQuarto == null) {
            throw new IllegalArgumentException("O ID e o item quarto não podem ser nulos.");
        }
        Optional<ItemQuarto> optionalItemQuarto = itemQuartoRepository.findById(itemQuartoId);
        if (optionalItemQuarto.isPresent()) {
            itemQuarto.setId(itemQuartoId);
            return itemQuartoRepository.save(itemQuarto);
        } else {
            throw new IllegalArgumentException("Item quarto não encontrado para o ID fornecido: " + itemQuartoId);
        }
    }

    @Override
    public void deletarItemQuarto(ItemQuartoId itemQuartoId) {
        if (itemQuartoId == null) {
            throw new IllegalArgumentException("O ID do item quarto não pode ser nulo.");
        }
        itemQuartoRepository.deleteById(itemQuartoId);
    }

}
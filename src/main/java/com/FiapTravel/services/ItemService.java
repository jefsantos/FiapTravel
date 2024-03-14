package com.FiapTravel.services;

import com.FiapTravel.model.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a itens.
 */
public interface ItemService {

    /**
     * Salva um novo item.
     *
     * @param item O item a ser salvo.
     * @return O item salvo.
     * @throws IllegalArgumentException Se o item fornecido for nulo.
     */
    Item save(Item item);

    /**
     * Retorna uma lista de todos os itens cadastrados.
     *
     * @return Uma lista de itens.
     */
    List<Item> buscarTodosItens();

    /**
     * Busca um item pelo ID.
     *
     * @param id O ID do item a ser buscado.
     * @return Um {@code Optional} contendo o item, se encontrado, ou vazio se não encontrado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<Item> buscarPorId(UUID id);

    /**
     * Atualiza as informações de um item existente.
     *
     * @param id     O ID do item a ser atualizado.
     * @param item O item com as informações atualizadas.
     * @return O item atualizado.
     * @throws IllegalArgumentException Se o ID ou o item fornecido forem nulos.
     */
    Item atualizarItem(UUID id, Item item);

    /**
     * Deleta um item pelo ID.
     *
     * @param id O ID do item a ser deletado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarItem(UUID id);
}

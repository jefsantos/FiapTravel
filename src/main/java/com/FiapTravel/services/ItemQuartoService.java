package com.FiapTravel.services;

import com.FiapTravel.model.ItemQuarto;
import com.FiapTravel.model.ItemQuartoId;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para operações relacionadas a itens quartos.
 */
public interface ItemQuartoService {

    /**
     * Salva um novo item quarto.
     *
     * @param itemQuarto O item quarto a ser salvo.
     * @return O item quarto salvo.
     * @throws IllegalArgumentException Se o item quarto fornecido for nulo.
     */
    ItemQuarto save(ItemQuarto itemQuarto);

    /**
     * Retorna uma lista de todos os itens quartos cadastrados.
     *
     * @return Uma lista de itens quartos.
     */
    List<ItemQuarto> buscarTodosItensQuartos();

    /**
     * Busca um item quarto pelo ID.
     *
     * @param itemQuartoId O ID do item quarto a ser buscado.
     * @return Um {@code Optional} contendo o item quarto, se encontrado, ou vazio se não encontrado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<ItemQuarto> buscarPorId(ItemQuartoId itemQuartoId);

    /**
     * Atualiza as informações de um item quarto existente.
     *
     * @param itemQuartoId     O ID do item quarto a ser atualizado.
     * @param itemQuarto O item quarto com as informações atualizadas.
     * @return O item quarto atualizado.
     * @throws IllegalArgumentException Se o ID ou o item quarto fornecido forem nulos.
     */
    ItemQuarto atualizarItemQuarto(ItemQuartoId itemQuartoId, ItemQuarto itemQuarto);

    /**
     * Deleta um item quarto pelo ID.
     *
     * @param itemQuartoId O ID do item quarto a ser deletado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarItemQuarto(ItemQuartoId itemQuartoId);
}

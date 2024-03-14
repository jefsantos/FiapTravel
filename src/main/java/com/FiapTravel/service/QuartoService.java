package com.FiapTravel.service;

import com.FiapTravel.model.Quarto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a quartos.
 */
public interface QuartoService {

    /**
     * Salva um novo quarto.
     *
     * @param quarto O quarto a ser salvo.
     * @return O quarto salvo.
     * @throws IllegalArgumentException Se o quarto fornecido for nulo.
     */
    Quarto save(Quarto quarto);

    /**
     * Retorna uma lista de todos os quartos cadastrados.
     *
     * @return Uma lista de quartos.
     */
    List<Quarto> buscarTodosQuartos();

    /**
     * Busca um quarto pelo ID.
     *
     * @param id O ID do quarto a ser buscado.
     * @return Um {@code Optional} contendo o quarto, se encontrado, ou vazio se não encontrado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<Quarto> buscarPorId(UUID id);

    /**
     * Atualiza as informações de um quarto existente.
     *
     * @param id     O ID do quarto a ser atualizado.
     * @param quarto O quarto com as informações atualizadas.
     * @return O quarto atualizado.
     * @throws IllegalArgumentException Se o ID ou o quarto fornecido forem nulos.
     */
    Quarto atualizarQuarto(UUID id, Quarto quarto);

    /**
     * Deleta um quarto pelo ID.
     *
     * @param id O ID do quarto a ser deletado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarQuarto(UUID id);
}

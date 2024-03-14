package com.FiapTravel.services;

import com.FiapTravel.model.TipoQuarto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a tipo quartos.
 */
public interface TipoQuartoService {

    /**
     * Salva um novo tipo quarto.
     *
     * @param tipoQuarto O tipo quarto a ser salvo.
     * @return O tipo quarto salvo.
     * @throws IllegalArgumentException Se o tipo quarto fornecido for nulo.
     */
    TipoQuarto save(TipoQuarto tipoQuarto);

    /**
     * Retorna uma lista de todos os tipo quartos cadastrados.
     *
     * @return Uma lista de tipo quartos.
     */
    List<TipoQuarto> buscarTodosTiposQuartos();

    /**
     * Busca um tipo quarto pelo ID.
     *
     * @param id O ID do tipo quarto a ser buscado.
     * @return Um {@code Optional} contendo o tipo quarto, se encontrado, ou vazio se não encontrado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<TipoQuarto> buscarPorId(UUID id);

    /**
     * Atualiza as informações de um tipo quarto existente.
     *
     * @param id     O ID do tipo quarto a ser atualizado.
     * @param tipoQuarto O tipo quarto com as informações atualizadas.
     * @return O tipo quarto atualizado.
     * @throws IllegalArgumentException Se o ID ou o tipo quarto fornecido forem nulos.
     */
    TipoQuarto atualizarTipoQuarto(UUID id, TipoQuarto tipoQuarto);

    /**
     * Deleta um tipo quarto pelo ID.
     *
     * @param id O ID do tipo quarto a ser deletado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarTipoQuarto(UUID id);
}

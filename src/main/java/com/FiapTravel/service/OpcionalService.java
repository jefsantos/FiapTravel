package com.FiapTravel.service;

import com.FiapTravel.model.Opcional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a opcionais.
 */
public interface OpcionalService {

    /**
     * Salva um novo opcional.
     *
     * @param opcional O opcional a ser salvo.
     * @return O opcional salvo.
     * @throws IllegalArgumentException Se o opcional fornecido for nulo.
     */
    Opcional save(Opcional opcional);

    /**
     * Retorna uma lista de todos os opcionais cadastrados.
     *
     * @return Uma lista de opcionais.
     */
    List<Opcional> buscarTodosOpcionais();

    /**
     * Busca um opcional pelo ID.
     *
     * @param id O ID do opcional a ser buscado.
     * @return Um {@code Optional} contendo o opcional, se encontrado, ou vazio se não encontrado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<Opcional> buscarPorId(UUID id);

    /**
     * Atualiza as informações de um opcional existente.
     *
     * @param id     O ID do opcional a ser atualizado.
     * @param opcional O opcional com as informações atualizadas.
     * @return O opcional atualizado.
     * @throws IllegalArgumentException Se o ID ou o opcional fornecido forem nulos.
     */
    Opcional atualizarOpcional(UUID id, Opcional opcional);

    /**
     * Deleta um opcional pelo ID.
     *
     * @param id O ID do opcional a ser deletado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarOpcional(UUID id);
}

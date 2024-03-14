package com.FiapTravel.services;

import com.FiapTravel.model.Predio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a prédios.
 */
public interface PredioService {

    /**
     * Salva um novo prédio.
     *
     * @param predio O prédio a ser salvo.
     * @return O prédio salvo.
     * @throws IllegalArgumentException Se o prédio fornecido for nulo.
     */
    Predio save(Predio predio);

    /**
     * Retorna uma lista de todos os prédios cadastrados.
     *
     * @return Uma lista de prédios.
     */
    List<Predio> buscarTodosPredios();

    /**
     * Busca um prédio pelo ID.
     *
     * @param id O ID do prédio a ser buscado.
     * @return Um {@code Optional} contendo o prédio, se encontrado, ou vazio se não encontrado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<Predio> buscarPorId(UUID id);

    /**
     * Atualiza as informações de um prédio existente.
     *
     * @param id     O ID do prédio a ser atualizado.
     * @param predio O prédio com as informações atualizadas.
     * @return O prédio atualizado.
     * @throws IllegalArgumentException Se o ID ou o prédio fornecido forem nulos.
     */
    Predio atualizarPredio(UUID id, Predio predio);

    /**
     * Deleta um prédio pelo ID.
     *
     * @param id O ID do prédio a ser deletado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarPredio(UUID id);
}


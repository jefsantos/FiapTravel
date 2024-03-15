package com.FiapTravel.service;

import com.FiapTravel.model.OpcionalReserva;
import com.FiapTravel.model.OpcionalReservaId;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para operações relacionadas a opcionais de reserva.
 */
public interface OpcionalReservaService {

    /**
     * Salva um novo opcional de reserva.
     *
     * @param opcionalReserva O opcional de reserva a ser salvo.
     * @return O opcional de reserva salvo.
     * @throws IllegalArgumentException Se o opcional de reserva fornecido for nulo.
     */
    OpcionalReserva save(OpcionalReserva opcionalReserva);

    /**
     * Retorna uma lista de todos os opcionais de reserva cadastrados.
     *
     * @return Uma lista de opcionais de reserva.
     */
    List<OpcionalReserva> buscarTodosOpcionaisReserva();

    /**
     * Busca um opcional de reserva pelo ID.
     *
     * @param opcionalReservaId O ID do opcional de reserva a ser buscado.
     * @return Um {@code Optional} contendo o opcional de reserva, se encontrado, ou vazio se não encontrado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<OpcionalReserva> buscarPorId(OpcionalReservaId opcionalReservaId);

    /**
     * Atualiza as informações de um opcional de reserva existente.
     *
     * @param opcionalReservaId     O ID do opcional de reserva a ser atualizado.
     * @param opcionalReserva O opcional de reserva com as informações atualizadas.
     * @return O opcional de reserva atualizado.
     * @throws IllegalArgumentException Se o ID ou o opcional de reserva fornecido forem nulos.
     */
    OpcionalReserva atualizarOpcionalReserva(OpcionalReservaId opcionalReservaId, OpcionalReserva opcionalReserva);

    /**
     * Deleta um opcional de reserva pelo ID.
     *
     * @param opcionalReservaId O ID do opcional de reserva a ser deletado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarOpcionalReserva(OpcionalReservaId opcionalReservaId);
}
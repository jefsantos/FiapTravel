package com.FiapTravel.service;

import com.FiapTravel.model.Reserva;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a reservas.
 */
public interface ReservaService {

    /**
     * Salva uma nova reserva.
     *
     * @param reserva A reserva a ser salva.
     * @return A reserva salva.
     * @throws IllegalArgumentException Se a reserva fornecida for nula.
     */
    Reserva save(Reserva reserva);

    /**
     * Retorna uma lista de todas as reservas cadastradas.
     *
     * @return Uma lista de reservas.
     */
    List<Reserva> buscarTodasReservas();

    /**
     * Busca uma reserva pelo ID.
     *
     * @param id O ID da reserva a ser buscada.
     * @return Um {@code Optional} contendo a reserva, se encontrada, ou vazio se não encontrada.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<Reserva> buscarPorId(UUID id);

    /**
     * Atualiza as informações de uma reserva existente.
     *
     * @param id      O ID da reserva a ser atualizada.
     * @param reserva A reserva com as informações atualizadas.
     * @return A reserva atualizada.
     * @throws IllegalArgumentException Se o ID ou a reserva fornecida forem nulos.
     */
    Reserva atualizarReserva(UUID id, Reserva reserva);

    /**
     * Deleta uma reserva pelo ID.
     *
     * @param id O ID da reserva a ser deletada.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarReserva(UUID id);
}
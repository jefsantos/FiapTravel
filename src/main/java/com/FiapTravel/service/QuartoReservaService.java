package com.FiapTravel.service;

import com.FiapTravel.model.QuartoReserva;
import com.FiapTravel.model.QuartoReservaId;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para operações relacionadas a reservas de quartos.
 */
public interface QuartoReservaService {

    /**
     * Salva uma nova reserva de quarto.
     *
     * @param quartoReserva A reserva de quarto a ser salva.
     * @return A reserva de quarto salva.
     * @throws IllegalArgumentException Se a reserva de quarto fornecida for nula.
     */
    QuartoReserva save(QuartoReserva quartoReserva);

    /**
     * Retorna uma lista de todas as reservas de quartos cadastradas.
     *
     * @return Uma lista de reservas de quartos.
     */
    List<QuartoReserva> buscarTodasQuartoReservas();

    /**
     * Busca uma reserva de quarto pelo ID.
     *
     * @param id O ID da reserva de quarto a ser buscada.
     * @return Um {@code Optional} contendo a reserva de quarto, se encontrada, ou vazio se não encontrada.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<QuartoReserva> buscarPorId(QuartoReservaId id);

    /**
     * Atualiza as informações de uma reserva de quarto existente.
     *
     * @param id             O ID da reserva de quarto a ser atualizada.
     * @param quartoReserva A reserva de quarto com as informações atualizadas.
     * @return A reserva de quarto atualizada.
     * @throws IllegalArgumentException Se o ID ou a reserva de quarto fornecida forem nulos.
     */
    QuartoReserva atualizarQuartoReserva(QuartoReservaId id, QuartoReserva quartoReserva);

    /**
     * Deleta uma reserva de quarto pelo ID.
     *
     * @param id O ID da reserva de quarto a ser deletada.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarQuartoReserva(QuartoReservaId id);
}

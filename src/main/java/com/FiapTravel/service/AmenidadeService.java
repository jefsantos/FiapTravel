package com.FiapTravel.service;

import com.FiapTravel.model.Amenidade;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a amenidades.
 */
public interface AmenidadeService {

    /**
     * Salva uma nova amenidade.
     *
     * @param amenidade A amenidade a ser salva.
     * @return A amenidade salva.
     * @throws IllegalArgumentException Se a amenidade fornecida for nula.
     */
    Amenidade save(Amenidade amenidade);

    /**
     * Retorna uma lista de todas as amenidades cadastradas.
     *
     * @return Uma lista de amenidades.
     */
    List<Amenidade> buscarTodasAmenidades();

    /**
     * Busca uma amenidade pelo ID.
     *
     * @param id O ID da amenidade a ser buscada.
     * @return Um {@code Optional} contendo a amenidade, se encontrada, ou vazio se não encontrada.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<Amenidade> buscarPorId(UUID id);

    /**
     * Atualiza as informações de uma amenidade existente.
     *
     * @param id        O ID da amenidade a ser atualizada.
     * @param amenidade A amenidade com as informações atualizadas.
     * @return A amenidade atualizada.
     * @throws IllegalArgumentException Se o ID ou a amenidade fornecida forem nulos.
     */
    Amenidade atualizarAmenidade(UUID id, Amenidade amenidade);

    /**
     * Deleta uma amenidade pelo ID.
     *
     * @param id O ID da amenidade a ser deletada.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarAmenidade(UUID id);
}
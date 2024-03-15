package com.FiapTravel.service;

import com.FiapTravel.model.AmenidadeLocalidade;
import com.FiapTravel.model.AmenidadeLocalidadeId;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para operações relacionadas a amenidades de localidade.
 */
public interface AmenidadeLocalidadeService {

    /**
     * Salva uma nova amenidade da localidade.
     *
     * @param amenidadeLocalidade A amenidade da localidade a ser salva.
     * @return A amenidade da localidade salva.
     * @throws IllegalArgumentException Se a amenidade da localidade fornecida for nula.
     */
    AmenidadeLocalidade save(AmenidadeLocalidade amenidadeLocalidade);

    /**
     * Retorna uma lista de todas as amenidades de localidade cadastradas.
     *
     * @return Uma lista de amenidades de localidade.
     */
    List<AmenidadeLocalidade> buscarTodasAmenidadesLocalidades();

    /**
     * Busca uma amenidade de localidade pelo ID.
     *
     * @param amenidadeLocalidadeId O ID da amenidade de localidade a ser buscada.
     * @return Um {@code Optional} contendo a amenidade de localidade, se encontrada, ou vazio se não encontrada.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<AmenidadeLocalidade> buscarPorId(AmenidadeLocalidadeId amenidadeLocalidadeId);

    /**
     * Atualiza as informações de uma amenidade de localidade existente.
     *
     * @param amenidadeLocalidadeId O ID da amenidade de localidade a ser atualizada.
     * @param amenidadeLocalidade A amenidade de localidade com as informações atualizadas.
     * @return A amenidade de localidade atualizada.
     * @throws IllegalArgumentException Se o ID ou a amenidade de localidade fornecida forem nulos.
     */
    AmenidadeLocalidade atualizarAmenidadeLocalidade(AmenidadeLocalidadeId amenidadeLocalidadeId, AmenidadeLocalidade amenidadeLocalidade);

    /**
     * Deleta uma amenidade de localidade pelo ID.
     *
     * @param amenidadeLocalidadeId O ID da amenidade de localidade a ser deletada.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarAmenidadeLocalidade(AmenidadeLocalidadeId amenidadeLocalidadeId);
}

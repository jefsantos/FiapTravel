package com.FiapTravel.services;

import com.FiapTravel.model.OpcionalLocalidade;
import com.FiapTravel.model.OpcionalLocalidadeId;

import java.util.List;
import java.util.Optional;

/**
 * Serviço para operações relacionadas a opcionais de localidade.
 */
public interface OpcionalLocalidadeService {

    /**
     * Salva um novo opcional da localidade.
     *
     * @param opcionalLocalidade O opcional da localidade a ser salvo.
     * @return O opcional da localidade salvo.
     * @throws IllegalArgumentException Se o opcional da localidade fornecido for nulo.
     */
    OpcionalLocalidade save(OpcionalLocalidade opcionalLocalidade);

    /**
     * Retorna uma lista de todos os opcionais de localidades cadastrados.
     *
     * @return Uma lista de opcionais de localidades.
     */
    List<OpcionalLocalidade> buscarTodosOpcionaisLocalidades();

    /**
     * Busca um opcional de localidade pelo ID.
     *
     * @param opcionalLocalidadeId O ID do opcional de localidade a ser buscado.
     * @return Um {@code Optional} contendo o opcional de localidade, se encontrado, ou vazio se não encontrado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<OpcionalLocalidade> buscarPorId(OpcionalLocalidadeId opcionalLocalidadeId);

    /**
     * Atualiza as informações de um opcional de localidade existente.
     *
     * @param opcionalLocalidadeId     O ID do opcional de localidade a ser atualizado.
     * @param opcionalLocalidade O opcional de localidade com as informações atualizadas.
     * @return O opcional de localidade atualizado.
     * @throws IllegalArgumentException Se o ID ou o opcional de localidade fornecido forem nulos.
     */
    OpcionalLocalidade atualizarOpcionalLocalidade(OpcionalLocalidadeId opcionalLocalidadeId, OpcionalLocalidade opcionalLocalidade);

    /**
     * Deleta um opcional de localidade pelo ID.
     *
     * @param opcionalLocalidadeId O ID do opcional de localidade a ser deletado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarOpcionalLocalidade(OpcionalLocalidadeId opcionalLocalidadeId);
}

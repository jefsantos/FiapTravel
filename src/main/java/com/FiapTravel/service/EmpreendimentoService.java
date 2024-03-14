package com.FiapTravel.service;

import com.FiapTravel.model.Empreendimento;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a empreendimentos.
 */
public interface EmpreendimentoService {

    /**
     * Salva um novo empreendimeto.
     *
     * @param empreendimento O empreendimento a ser salvo.
     * @return O empreendimento salvo.
     * @throws IllegalArgumentException Se o empreendimento fornecido for nulo.
     */
    Empreendimento save(Empreendimento empreendimento);

    /**
     * Retorna uma lista de todos os empreendimento cadastrados.
     *
     * @return Uma lista de empreendimento.
     */
    List<Empreendimento> buscarTodosEmpreendimentos();

    /**
     * Busca um empreendimento pelo ID.
     *
     * @param id O ID do empreendimento a ser buscado.
     * @return Um {@code Optional} contendo o empreendimento, se encontrado, ou vazio se não encontrado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    Optional<Empreendimento> buscarPorId(UUID id);

    /**
     * Atualiza as informações de um empreendimento existente.
     *
     * @param id     O ID do empreendimento a ser atualizado.
     * @param empreendimento O empreendimento com as informações atualizadas.
     * @return O empreendimento atualizado.
     * @throws IllegalArgumentException Se o ID ou o empreendimento fornecido forem nulos.
     */
    Empreendimento atualizarEmpreendimento(UUID id, Empreendimento empreendimento);

    /**
     * Deleta um empreendimento pelo ID.
     *
     * @param id O ID do empreendimento a ser deletado.
     * @throws IllegalArgumentException Se o ID fornecido for nulo.
     */
    void deletarEmpreendimento(UUID id);
}


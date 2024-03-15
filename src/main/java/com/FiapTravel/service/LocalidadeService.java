package com.FiapTravel.service;

import com.FiapTravel.model.Localidade;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a localidades.
 */
public interface LocalidadeService {

	/**
	 * Salva uma nova localidade.
	 *
	 * @param localidade A localidade a ser salva.
	 * @return A localidade salva.
	 * @throws IllegalArgumentException Se a localidade fornecida for nulo.
	 */
	Localidade save(Localidade localidade);

	/**
	 * Retorna uma lista de todas as localidades cadastradas.
	 *
	 * @return Uma lista de localidades.
	 */
	List<Localidade> buscarTodasLocalidades();

	/**
	 * Busca uma localidade pelo ID.
	 *
	 * @param id O ID da localidade a ser buscada.
	 * @return Um {@code Optional} contendo a localidade, se encontrada, ou vazio se não encontrada.
	 * @throws IllegalArgumentException Se o ID fornecido for nulo.
	 */
	Optional<Localidade> buscarPorId(UUID id);

	/**
	 * Atualiza as informações de uma localidade existente.
	 *
	 * @param id     O ID do localidade a ser atualizado.
	 * @param localidade A localidade com as informações atualizadas.
	 * @return A localidade atualizada.
	 * @throws IllegalArgumentException Se o ID ou o localidade fornecida forem nulos.
	 */
	Localidade atualizarLocalidade(UUID id, Localidade localidade);

	/**
	 * Deleta uma localidade pelo ID.
	 *
	 * @param id O ID da localidade a ser deletada.
	 * @throws IllegalArgumentException Se o ID fornecido for nulo.
	 */
	void deletarLocalidade(UUID id);
}


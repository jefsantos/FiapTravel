package com.FiapTravel.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.FiapTravel.model.User;

/**
 * Serviço para operações relacionadas a users.
 */
public interface UserService {

	/**
	 * Salva um novo user.
	 *
	 * @param user O user a ser salvo.
	 * @return O user salvo.
	 * @throws IllegalArgumentException Se o user fornecido for nulo.
	 */
	User save(User user);

	/**
	 * Retorna uma lista de todos os users cadastrados.
	 *
	 * @return Uma lista de users.
	 */
	List<User> buscarTodosUsers();

	/**
	 * Busca um user pelo ID.
	 *
	 * @param id O ID do user a ser buscado.
	 * @return Um {@code Optional} contendo o user, se encontrado, ou vazio se não encontrado.
	 * @throws IllegalArgumentException Se o ID fornecido for nulo.
	 */
	Optional<User> buscarPorId(UUID id);

	/**
	 * Atualiza as informações de um user existente.
	 *
	 * @param id     O ID do user a ser atualizado.
	 * @param user O user com as informações atualizadas.
	 * @return O user atualizado.
	 * @throws IllegalArgumentException Se o ID ou o user fornecido forem nulos.
	 */
	User atualizarUser(UUID id, User user);

	/**
	 * Deleta um user pelo ID.
	 *
	 * @param id O ID do user a ser deletado.
	 * @throws IllegalArgumentException Se o ID fornecido for nulo.
	 */
	void deletarUser(UUID id);
}


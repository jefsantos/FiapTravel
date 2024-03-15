package com.FiapTravel.service;

import com.FiapTravel.model.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Serviço para operações relacionadas a clientes.
 */
public interface ClienteService {

	/**
	 * Salva um novo cliente.
	 *
	 * @param cliente O cliente a ser salvo.
	 * @return O cliente salvo.
	 * @throws IllegalArgumentException Se o cliente fornecido for nulo.
	 */
	Cliente save(Cliente cliente);

	/**
	 * Retorna uma lista de todos os clientes cadastrados.
	 *
	 * @return Uma lista de clientes.
	 */
	List<Cliente> buscarTodosClientes();

	/**
	 * Busca um cliente pelo ID.
	 *
	 * @param id O ID do cliente a ser buscado.
	 * @return Um {@code Optional} contendo o cliente, se encontrado, ou vazio se não encontrado.
	 * @throws IllegalArgumentException Se o ID fornecido for nulo.
	 */
	Optional<Cliente> buscarPorId(UUID id);

	/**
	 * Atualiza as informações de um cliente existente.
	 *
	 * @param id     O ID do cliente a ser atualizado.
	 * @param cliente O cliente com as informações atualizadas.
	 * @return O cliente atualizado.
	 * @throws IllegalArgumentException Se o ID ou o cliente fornecido forem nulos.
	 */
	Cliente atualizarCliente(UUID id, Cliente cliente);

	/**
	 * Deleta um cliente pelo ID.
	 *
	 * @param id O ID do cliente a ser deletado.
	 * @throws IllegalArgumentException Se o ID fornecido for nulo.
	 */
	void deletarCliente(UUID id);
}


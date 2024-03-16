package com.FiapTravel.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import com.FiapTravel.model.enums.UserRole;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void testNoArgsConstructor() {
        Cliente cliente = new Cliente();
        assertNotNull(cliente);
    }

    @Test
    void testAllArgsConstructor() {
        UUID id = UUID.randomUUID();
        User user = new User("username", "password", UserRole.ADMIN);
        String paisOrigemCliente = "Brasil";
        String cpfCliente = "123.456.789-00";
        String passaporteCliente = "ABC123";
        String nomeCliente = "Fulano de Tal";
        String dataNascimentoCliente = "2000-01-01";
        String logradouroEnderecoCliente = "Rua ABC";
        String codigoPostalEnderecoCliente = "12345-678";
        String cidadeEnderecoCliente = "São Paulo";
        String bairroEnderecoCliente = "Centro";
        String ufEnderecoCliente = "SP";

        Cliente cliente = new Cliente(id, user, paisOrigemCliente, cpfCliente, passaporteCliente,
                nomeCliente, dataNascimentoCliente, logradouroEnderecoCliente, codigoPostalEnderecoCliente,
                cidadeEnderecoCliente, bairroEnderecoCliente, ufEnderecoCliente);

        assertEquals(id, cliente.getId());
        assertEquals(user, cliente.getUser());
        assertEquals(paisOrigemCliente, cliente.getPaisOrigemCliente());
        assertEquals(cpfCliente, cliente.getCpfCliente());
        assertEquals(passaporteCliente, cliente.getPassaporteCliente());
        assertEquals(nomeCliente, cliente.getNomeCliente());
        assertEquals(dataNascimentoCliente, cliente.getDataNascimentoCliente());
        assertEquals(logradouroEnderecoCliente, cliente.getLogradouroEnderecoCliente());
        assertEquals(codigoPostalEnderecoCliente, cliente.getCodigoPostalEnderecoCliente());
        assertEquals(cidadeEnderecoCliente, cliente.getCidadeEnderecoCliente());
        assertEquals(bairroEnderecoCliente, cliente.getBairroEnderecoCliente());
        assertEquals(ufEnderecoCliente, cliente.getUfEnderecoCliente());
    }


    @Test
    void testToString() {
        UUID id = UUID.randomUUID();
        User user = new User("username", "password", UserRole.ADMIN);

        Cliente cliente = new Cliente(id, user, "Brasil", "123.456.789-00", "ABC123", "Fulano",
                "2000-01-01", "Rua ABC", "12345-678", "São Paulo", "Centro", "SP");
        String expectedString = "Cliente(id=" + id + ", user=" + user + ", paisOrigemCliente=Brasil, cpfCliente=123.456.789-00, passaporteCliente=ABC123, nomeCliente=Fulano, dataNascimentoCliente=2000-01-01, logradouroEnderecoCliente=Rua ABC, codigoPostalEnderecoCliente=12345-678, cidadeEnderecoCliente=São Paulo, bairroEnderecoCliente=Centro, ufEnderecoCliente=SP)";
        assertEquals(expectedString, cliente.toString());
    }
}
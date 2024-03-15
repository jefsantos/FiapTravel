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
    void testEqualsAndHashCode() {
        UUID id = UUID.randomUUID();
        User user1 = new User("username1", "password1", UserRole.USER);
        User user2 = new User("username2", "password2", UserRole.ADMIN);

        Cliente cliente1 = new Cliente(id, user1, "Brasil", "123.456.789-00", "ABC123", "Fulano",
                "2000-01-01", "Rua ABC", "12345-678", "São Paulo", "Centro", "SP");
        Cliente cliente2 = new Cliente(id, user2, "Brasil", "123.456.789-00", "ABC123", "Fulano",
                "2000-01-01", "Rua ABC", "12345-678", "São Paulo", "Centro", "SP");
        Cliente cliente3 = new Cliente(UUID.randomUUID(), user1, "Brasil", "123.456.789-00", "ABC123", "Fulano",
                "2000-01-01", "Rua ABC", "12345-678", "São Paulo", "Centro", "SP");

        assertEquals(cliente1, cliente2); // Deve ser igual porque têm o mesmo ID
        assertNotEquals(cliente1, cliente3); // Deve ser diferente porque têm IDs diferentes

        assertEquals(cliente1.hashCode(), cliente2.hashCode());
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
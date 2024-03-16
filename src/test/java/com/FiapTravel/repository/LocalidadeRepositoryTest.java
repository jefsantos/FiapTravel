package com.FiapTravel.repository;

import com.FiapTravel.model.Localidade;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LocalidadeRepositoryTest {

    @Test
    void testFindAll() {
        // Arrange
        List<Localidade> expectedLocalidades = Arrays.asList(
                new Localidade(UUID.randomUUID(), "Nome 1", "Logradouro 1", "CodigoPostal 1", "Cidade 1", "Bairro 1", "UF 1", null),
                new Localidade(UUID.randomUUID(), "Nome 2", "Logradouro 2", "CodigoPostal 2", "Cidade 2", "Bairro 2", "UF 2", null)
        );
        LocalidadeRepository localidadeRepositoryMock = Mockito.mock(LocalidadeRepository.class);
        when(localidadeRepositoryMock.findAll()).thenReturn(expectedLocalidades);

        // Act
        List<Localidade> actualLocalidades = localidadeRepositoryMock.findAll();

        // Assert
        assertEquals(expectedLocalidades, actualLocalidades);
    }

    @Test
    void testFindById() {
        // Arrange
        UUID id = UUID.randomUUID();
        Localidade expectedLocalidade = new Localidade(id, "Nome da localidade", "Logradouro", "CodigoPostal", "Cidade", "Bairro", "UF", null);
        LocalidadeRepository localidadeRepositoryMock = Mockito.mock(LocalidadeRepository.class);
        when(localidadeRepositoryMock.findById(id)).thenReturn(Optional.of(expectedLocalidade));

        // Act
        Optional<Localidade> actualLocalidadeOptional = localidadeRepositoryMock.findById(id);

        // Assert
        assertTrue(actualLocalidadeOptional.isPresent());
        assertEquals(expectedLocalidade, actualLocalidadeOptional.get());
    }

    @Test
    void testSave() {
        // Arrange
        UUID id = UUID.randomUUID();
        Localidade localidadeToSave = new Localidade(id, "Nome da localidade", "Logradouro", "CodigoPostal", "Cidade", "Bairro", "UF", null);
        LocalidadeRepository localidadeRepositoryMock = Mockito.mock(LocalidadeRepository.class);
        when(localidadeRepositoryMock.save(localidadeToSave)).thenReturn(localidadeToSave);

        // Act
        Localidade savedLocalidade = localidadeRepositoryMock.save(localidadeToSave);

        // Assert
        assertEquals(localidadeToSave, savedLocalidade);
    }

    @Test
    void testDeleteById() {
        // Arrange
        UUID id = UUID.randomUUID();
        LocalidadeRepository localidadeRepositoryMock = Mockito.mock(LocalidadeRepository.class);

        // Act
        localidadeRepositoryMock.deleteById(id);

        // Assert
        verify(localidadeRepositoryMock, times(1)).deleteById(id);
    }
}

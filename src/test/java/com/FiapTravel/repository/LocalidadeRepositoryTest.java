package com.FiapTravel.repository;

import com.FiapTravel.model.Empreendimento;
import com.FiapTravel.model.Localidade;
import com.FiapTravel.service.LocalidadeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class LocalidadeRepositoryTest {

    @Mock
    private LocalidadeRepository localidadeRepository;

    @InjectMocks
    private LocalidadeService localidadeService; // Supondo que existe uma classe de serviço para Localidade

    private Localidade localidade;

    @BeforeEach
    public void setup() {
        // Configura uma localidade simulada antes de cada teste
        Empreendimento empreendimento = new Empreendimento(/* dados do empreendimento */);
        localidade = new Localidade(UUID.randomUUID(), "Localidade A", "Rua ABC", "12345-678", "São Paulo", "Centro", "SP", empreendimento);
    }

    @Test
    public void testSaveLocalidade() {
        // Configura o comportamento simulado do repositório para salvar a localidade
        when(localidadeRepository.save(localidade)).thenReturn(localidade);

        // Chama o método da classe de serviço que salva a localidade
        Localidade savedLocalidade = localidadeService.save(localidade);

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à localidade simulada
        verify(localidadeRepository, times(1)).save(localidade);
        assertEquals(localidade, savedLocalidade);
    }

    @Test
    public void testFindById() {
        // Configura o comportamento simulado do repositório para encontrar a localidade por ID
        when(localidadeRepository.findById(localidade.getIdLocalidade())).thenReturn(Optional.of(localidade));

        // Chama o método da classe de serviço que encontra a localidade por ID
        Optional<Localidade> foundLocalidade = localidadeService.buscarPorId(localidade.getIdLocalidade());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à localidade simulada
        verify(localidadeRepository, times(1)).findById(localidade.getIdLocalidade());
        assertEquals(localidade, foundLocalidade.get());
    }

    @Test
    public void testFindAll() {
        // Configura uma lista simulada de localidades
        List<Localidade> localidades = new ArrayList<>();
        localidades.add(localidade);

        // Configura o comportamento simulado do repositório para encontrar todas as localidades
        when(localidadeRepository.findAll()).thenReturn(localidades);

        // Chama o método da classe de serviço que encontra todas as localidades
        List<Localidade> foundLocalidades = localidadeService.buscarTodasLocalidades();

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à lista simulada de localidades
        verify(localidadeRepository, times(1)).findAll();
        assertEquals(localidades.size(), foundLocalidades.size());
        assertEquals(localidade, foundLocalidades.get(0));
    }

    @Test
    public void testDelete() {
        // Chama o método da classe de serviço que deleta a localidade
        localidadeService.deletarLocalidade(UUID.randomUUID());

        // Verifica se o método do repositório foi chamado para deletar a localidade
        verify(localidadeRepository, times(1)).delete(localidade);
    }

}

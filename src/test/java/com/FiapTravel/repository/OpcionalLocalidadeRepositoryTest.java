package com.FiapTravel.repository;

import com.FiapTravel.model.Localidade;
import com.FiapTravel.model.Opcional;
import com.FiapTravel.model.OpcionalLocalidade;
import com.FiapTravel.model.OpcionalLocalidadeId;
import com.FiapTravel.service.OpcionalLocalidadeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class OpcionalLocalidadeRepositoryTest {

    @Mock
    private OpcionalLocalidadeRepository opcionalLocalidadeRepository;

    @InjectMocks
    private OpcionalLocalidadeService opcionalLocalidadeService; // Supondo que existe uma classe de serviço para OpcionalLocalidade

    private OpcionalLocalidade opcionalLocalidade;

    @BeforeEach
    public void setup() {
        // Configura um opcionalLocalidade simulado antes de cada teste
        Localidade localidade = new Localidade(/* dados da localidade */);
        Opcional opcional = new Opcional(/* dados do opcional */);
        OpcionalLocalidadeId id = new OpcionalLocalidadeId();
        opcionalLocalidade = new OpcionalLocalidade(id, localidade, opcional, BigDecimal.valueOf(100.0));
    }

    @Test
    public void testSaveOpcionalLocalidade() {
        // Configura o comportamento simulado do repositório para salvar a opcionalLocalidade
        when(opcionalLocalidadeRepository.save(opcionalLocalidade)).thenReturn(opcionalLocalidade);

        // Chama o método da classe de serviço que salva a opcionalLocalidade
        OpcionalLocalidade savedOpcionalLocalidade = opcionalLocalidadeService.save(opcionalLocalidade);

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à opcionalLocalidade simulada
        verify(opcionalLocalidadeRepository, times(1)).save(opcionalLocalidade);
        assertEquals(opcionalLocalidade, savedOpcionalLocalidade);
    }

    @Test
    public void testFindById() {
        // Configura o comportamento simulado do repositório para encontrar a opcionalLocalidade por ID
        when(opcionalLocalidadeRepository.findById(opcionalLocalidade.getId())).thenReturn(Optional.of(opcionalLocalidade));

        // Chama o método da classe de serviço que encontra a opcionalLocalidade por ID
        Optional<OpcionalLocalidade> foundOpcionalLocalidade = opcionalLocalidadeService.buscarPorId(opcionalLocalidade.getId());

        // Verifica se o método do repositório foi chamado e se o resultado corresponde à opcionalLocalidade simulada
        verify(opcionalLocalidadeRepository, times(1)).findById(opcionalLocalidade.getId());
        assertEquals(opcionalLocalidade, foundOpcionalLocalidade.get());
    }

}

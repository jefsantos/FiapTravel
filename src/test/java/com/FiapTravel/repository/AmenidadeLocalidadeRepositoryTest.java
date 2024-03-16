package com.FiapTravel.repository;

import com.FiapTravel.model.AmenidadeLocalidade;
import com.FiapTravel.model.AmenidadeLocalidadeId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AmenidadeLocalidadeRepositoryTest {

    @Autowired
    private AmenidadeLocalidadeRepository repository;

    @Test
    public void testSaveAndFindById() {
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId();
        AmenidadeLocalidade amenidadeLocalidade = new AmenidadeLocalidade();
        repository.save(amenidadeLocalidade);

        Optional<AmenidadeLocalidade> savedAmenidadeLocalidade = repository.findById(id);
        assertTrue(savedAmenidadeLocalidade.isPresent());
        assertEquals(amenidadeLocalidade, savedAmenidadeLocalidade.get());
    }

    @Test
    public void testFindAll() {
        // Adicione algumas amenidades localidades ao repositório
        // Certifique-se de ter pelo menos algumas para testar
        List<AmenidadeLocalidade> amenidadesLocalidades = repository.findAll();
        assertFalse(amenidadesLocalidades.isEmpty());
    }

    @Test
    public void testDelete() {
        AmenidadeLocalidadeId id = new AmenidadeLocalidadeId();
        AmenidadeLocalidade amenidadeLocalidade = new AmenidadeLocalidade();
        repository.save(amenidadeLocalidade);

        repository.delete(amenidadeLocalidade);

        Optional<AmenidadeLocalidade> deletedAmenidadeLocalidade = repository.findById(id);
        assertFalse(deletedAmenidadeLocalidade.isPresent());
    }
}

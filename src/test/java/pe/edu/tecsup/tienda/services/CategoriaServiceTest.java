package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.tienda.dtos.CategoriaDTO;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class CategoriaServiceTest {

    @Autowired
    CategoriaService categoriaService;

    @Test
    void findAll() throws Exception {

        Boolean VALUE_EXPECTED = true;

        List<CategoriaDTO> categorias = this.categoriaService.findAll();

        categorias.forEach(cat -> log.info(cat.getNombre()));

        assertEquals(VALUE_EXPECTED, !categorias.isEmpty());

    }

    @Test
    void findById() throws Exception {

        String NAME_EXPECTED = "Procesadores";

        Optional<CategoriaDTO> categoriaDTOOptional
                = this.categoriaService.findById(1L);

        if ( categoriaDTOOptional.isPresent() ) {
            CategoriaDTO categoriaDTO = categoriaDTOOptional.get();
            log.info(categoriaDTO.toString());
            assertEquals(NAME_EXPECTED, categoriaDTO.getNombre());
        } else {
            throw new Exception("Categoria no encontrada");
        }

    }

}
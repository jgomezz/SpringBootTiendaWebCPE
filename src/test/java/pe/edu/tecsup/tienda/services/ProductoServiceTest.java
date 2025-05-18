package pe.edu.tecsup.tienda.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.tecsup.tienda.dtos.CategoriaDTO;
import pe.edu.tecsup.tienda.dtos.ProductoDTO;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class ProductoServiceTest {

    @Autowired
    ProductoService productoService;

    @Test
    void findAll() throws Exception {

        Boolean VALUE_EXPECTED = true;

        List<ProductoDTO> productos = this.productoService.findAll();

        productos.forEach(prod -> log.info(prod.getNombre()));
        //log.info(categorias.toString());

        assertEquals(VALUE_EXPECTED, !productos.isEmpty());

    }

    @Test
    void findByName() throws Exception {

        Boolean VALUE_EXPECTED = true;

        List<ProductoDTO> productos = this.productoService.findByNombre("AMD");

        log.info("Print by productos");
        productos.forEach(prod -> log.info(prod.getNombre()));

        assertEquals(VALUE_EXPECTED, !productos.isEmpty());
    }


    @Test
    void findById() throws Exception {

        String NAME_EXPECTED = "Kingstone";

        Optional<ProductoDTO> productoOptional
                = this.productoService.findById(1L);

        if (productoOptional.isPresent()) {
            ProductoDTO productoDTO = productoOptional.get();
            log.info(productoDTO.toString());
            assertEquals(NAME_EXPECTED, productoDTO.getNombre());
        } else {
            throw new Exception("Producto no encontrado");
        }

    }

    @Test
    void save() throws Exception {

        List<ProductoDTO> productoDTOS = this.productoService.findAll();
        int totalAntes = productoDTOS.size();

        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(1L);

        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setCategoriaDTO(categoriaDTO);
        productoDTO.setNombre("AMD");
        productoDTO.setDescripcion("AMD X10");
        productoDTO.setPrecio(280.0);
        productoDTO.setStock(6);
        productoDTO.setEstado(1);

        this.productoService.save(productoDTO);

        productoDTOS = this.productoService.findAll();
        int totalDespues = productoDTOS.size();

        assertEquals(1, totalDespues - totalAntes);
    }


    @Test
    void deleteById() throws Exception {

        List<ProductoDTO> productoDTOS = this.productoService.findAll();
        int totalAntes = productoDTOS.size();
        if (productoDTOS.isEmpty()) {
            return; // test pass
        }

        ProductoDTO ultimoProductoDTO = productoDTOS.get(productoDTOS.size() - 1);
        this.productoService.deleteById(ultimoProductoDTO.getId());

        productoDTOS = this.productoService.findAll();
        int totalDespues = productoDTOS.size();

        assertEquals(1, totalAntes - totalDespues);
    }

    @Test
    void update() throws Exception {

        // Actualizar el nombre del producto
        Long id = 1L; // Relacionado con tus datos de pruebas
        String NOMBRE_ORIGINAL = "Kingstone" ;
        String NOMBRE_A_CAMBIAR = "Kingstone Cambiado" ;
        ProductoDTO productoDTO = null;

        // Actualizar
        productoService.update(id, NOMBRE_A_CAMBIAR);

        // Buscar el producto
        productoDTO = productoService.findById(id).get();

        // Verificar que el nombre ha sido cambiado
        assertEquals(NOMBRE_A_CAMBIAR, productoDTO.getNombre());

        // Actualizar
        productoService.update(id, NOMBRE_ORIGINAL);

        // Buscar el producto
        productoDTO = productoService.findById(id).get();

        // Verificar que el nombre ha sido cambiado
        assertEquals(NOMBRE_ORIGINAL,productoDTO.getNombre());

    }
}
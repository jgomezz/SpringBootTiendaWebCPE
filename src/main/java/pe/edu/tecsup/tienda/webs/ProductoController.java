package pe.edu.tecsup.tienda.webs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.tecsup.tienda.dtos.ProductoDTO;
import pe.edu.tecsup.tienda.entities.Producto;
import pe.edu.tecsup.tienda.services.CategoriaService;
import pe.edu.tecsup.tienda.services.ProductoService;

import java.util.List;

@Slf4j
@Controller
public class ProductoController {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    ProductoService productoService;


    @GetMapping()
    public String index(Model model) throws Exception {

        log.info("call index()");

        List<ProductoDTO> productos = productoService.findAll();

        productos.forEach(item -> log.info(item.getNombre()));

        model.addAttribute("productos", productos);

        return "productos/index";

    }



}

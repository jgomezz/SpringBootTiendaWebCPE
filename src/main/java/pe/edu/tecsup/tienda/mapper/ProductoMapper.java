package pe.edu.tecsup.tienda.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.tecsup.tienda.dtos.ProductoDTO;
import pe.edu.tecsup.tienda.entities.Producto;


import java.time.LocalDateTime;

@Component
public class ProductoMapper {

    @Autowired
    CategoriaMapper categoriaMapper;

    public ProductoDTO mapToDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setStock(producto.getStock());
        productoDTO.setImagen_nombre(producto.getImagen_nombre());
        if (producto.getCategoria() != null )
            productoDTO.setCategoria(this.categoriaMapper.mapToDTO(producto.getCategoria()));
        else
            productoDTO.setCategoria(null);

        return productoDTO;

    }

    public Producto mapToEntity(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        producto.setImagen_nombre(productoDTO.getImagen_nombre());
        producto.setCategoria(this.categoriaMapper.mapToEntity(productoDTO.getCategoria()));
        if (producto.getCreado() == null)
            producto.setCreado(LocalDateTime.now());
        producto.setEstado(1); // Active by default
        return producto;
    }

}

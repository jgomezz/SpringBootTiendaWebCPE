package pe.edu.tecsup.tienda.mapper;

import org.springframework.stereotype.Component;

import pe.edu.tecsup.tienda.dtos.CategoriaDTO;
import pe.edu.tecsup.tienda.entities.Categoria;

@Component
public class CategoriaMapper {

    public CategoriaDTO mapToDTO(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNombre(categoria.getNombre());
        categoriaDTO.setOrden(categoria.getOrden());
        return categoriaDTO;
    }

    public Categoria mapToEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setId(dto.getId());
        categoria.setNombre(dto.getNombre());
        categoria.setOrden(dto.getOrden() != null ? dto.getOrden() : 0);
        return categoria;
    }

}

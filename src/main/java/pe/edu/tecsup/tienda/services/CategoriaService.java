package pe.edu.tecsup.tienda.services;

import pe.edu.tecsup.tienda.dtos.CategoriaDTO;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<CategoriaDTO> findAll() throws Exception;

    Optional<CategoriaDTO> findById(Long id) throws Exception;

}

package pe.edu.tecsup.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.tecsup.tienda.dtos.CategoriaDTO;
import pe.edu.tecsup.tienda.mapper.CategoriaMapper;
import pe.edu.tecsup.tienda.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    CategoriaMapper categoriaMapper;

    @Transactional(readOnly = true)
    @Override
    public List<CategoriaDTO> findAll() throws Exception {

        /*
        List<CategoriaDTO> categoriasDTO = new ArrayList<>();

        List<Categoria> categorias = this.categoriaRepository.findAll();

        for(Categoria entity : categorias) {
            CategoriaDTO dto = categoriaMapper.mapToDTO(entity);
            categoriasDTO.add(dto);

        }

        return categoriasDTO;

        */

        List<CategoriaDTO> categoriasDTO =  this.categoriaRepository.findAll()
                                                .stream()
                                                .map(this.categoriaMapper::mapToDTO)
                                                .collect(Collectors.toList());


        return categoriasDTO;
    }

    @Override
    public Optional<CategoriaDTO> findById(Long id) throws Exception {

        return this.categoriaRepository.findById(id)
                .map(this.categoriaMapper::mapToDTO);

    }
}

package pe.edu.tecsup.tienda.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoDTO {

    private Long id;
    private Long categoria_id;
    private CategoriaDTO categoriaDTO;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private String imagen_nombre;
    private String imagen_tipo;
    private Long imagen_tamanio;
    private Integer estado;
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime creado;

}

package pe.edu.tecsup.tienda.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    private Categoria categoria;

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

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", imagen_nombre='" + imagen_nombre + '\'' +
                ", imagen_tipo='" + imagen_tipo + '\'' +
                ", imagen_tamanio=" + imagen_tamanio +
                ", estado=" + estado +
                '}';
    }
}

package pe.edu.tecsup.tienda.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.tecsup.tienda.entities.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto,Long> {

     //List<Producto> findAll() ;

     List<Producto> findByNombre(String nombre) ;

     @Modifying
     @Query("UPDATE Producto p SET p.nombre = :nombreProducto WHERE p.id = :id")
     void update(@Param("id") Long id, @Param("nombreProducto") String nombreProducto);

}

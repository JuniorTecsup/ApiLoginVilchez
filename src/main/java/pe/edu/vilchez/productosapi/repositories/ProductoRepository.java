package pe.edu.vilchez.productosapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pe.edu.vilchez.productosapi.entities.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {

	@Override
	List<Producto> findAll();
	
	/*@Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:name%")
	List<Producto> searchByNameLike(@Param("name") String name);*/

//Esete java conecta con el paquete entities para usar el java class Producto	
}


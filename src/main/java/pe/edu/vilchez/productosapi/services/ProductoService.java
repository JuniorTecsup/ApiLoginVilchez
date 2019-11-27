package pe.edu.vilchez.productosapi.services;

import java.util.List;

import pe.edu.vilchez.productosapi.entities.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	public void save(Producto producto);
	
	public void deleteById(Long id);
	//conecta con java class Producto que esta en entities
} 

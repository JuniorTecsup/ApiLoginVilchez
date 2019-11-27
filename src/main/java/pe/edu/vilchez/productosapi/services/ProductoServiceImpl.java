package pe.edu.vilchez.productosapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.vilchez.productosapi.entities.Producto;
import pe.edu.vilchez.productosapi.repositories.ProductoRepository;

//Entities.Producto y Repositorio.ProductoRespositorio. Conectan

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	//listan
	@Override
	public List<Producto> findAll() {
		return productoRepository.findAll();
	}
    //lista uno solo
	@Override
	public Producto findById(Long id) {
		return productoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
	}

	@Override
	public void save(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void deleteById(Long id) {
		productoRepository.deleteById(id);
	}

} 


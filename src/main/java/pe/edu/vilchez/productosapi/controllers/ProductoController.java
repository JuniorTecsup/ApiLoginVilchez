package pe.edu.vilchez.productosapi.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.vilchez.productosapi.entities.Producto;
import pe.edu.vilchez.productosapi.services.ProductoService;


@RestController
@RequestMapping("/api")
public class ProductoController {

	private String STORAGEPATH;
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> productos() {
		
		List<Producto> productos = productoService.findAll();
		
		return productos;
	}
	
	@GetMapping("/productos/{id}")
	public Producto obtener(@PathVariable Long id) {
		//logger.info("call obtener: " + id);
		
		Producto producto = productoService.findById(id);
			
		return producto;
	}
	
	/*@GetMapping("/productos/images/{filename:.+}")
	public ResponseEntity<Resource> files(@PathVariable String filename) throws Exception{
		//logger.info("call images: " + filename);
		
		Path path = Paths.get(STORAGEPATH).resolve(filename);
		//logger.info("Path: " + path);
		
		if(!Files.exists(path)) {
			return ResponseEntity.notFound().build();
		}
		
		Resource resource = new UrlResource(path.toUri());
		//logger.info("Resource: " + resource);
		
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\""+resource.getFilename()+"\"")
				.header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Paths.get(STORAGEPATH).resolve(filename)))
				.header(HttpHeaders.CONTENT_LENGTH, String.valueOf(resource.contentLength()))
				.body(resource);
	}*/

	
}


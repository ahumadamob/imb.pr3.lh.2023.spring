package imb.pr3.lh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.pr3.lh.entity.Catalogo;
import imb.pr3.lh.service.ICatalogoService;

// localhost:8080/api/v1/catalogo

@RestController
@RequestMapping("/api/v1")
public class CatalogoController {
	
	@Autowired
	private ICatalogoService service;
	
	@GetMapping("/catalogo")
	public List<Catalogo> verTodos() {
		return service.mostrarTodos();
		
	}
}

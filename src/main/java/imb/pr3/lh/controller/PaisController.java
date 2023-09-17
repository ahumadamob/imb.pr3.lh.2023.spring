package imb.pr3.lh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import imb.pr3.lh.entity.Pais;
import imb.pr3.lh.service.IPaisService;

@RestController
@RequestMapping("/api/v1/pais")
public class PaisController {
	
	@Autowired	
	private IPaisService servicio;
	
	@GetMapping("/all")
	public List<Pais> mostrarTodos() {
		return servicio.buscarTodos();
	}
}

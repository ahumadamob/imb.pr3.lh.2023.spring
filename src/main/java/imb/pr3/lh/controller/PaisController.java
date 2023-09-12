package imb.pr3.lh.controller;


	import java.util.List;

	
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
	import imb.pr3.lh.entity.*;
	import imb.pr3.lh.service.IPaisService;
	
	// localhost:8080/api/v1/pais//

	@RestController
	@RequestMapping("/api/v1")
	public class PaisController {
		
		
		@Autowired
		private IPaisService service;
		
		@GetMapping("/pais")
	    public List<Pais> verTodos(){
		return service.buscarTodos();
}
		 @GetMapping("/pais/{id}")
		    public Pais buscarPorIdPais(@PathVariable Integer id) {
		        return service.buscarPorId(id);
		    }
			
			@PostMapping("/pais")
		    public Pais crearPais(@RequestBody Pais pais) {
		        service.crear(pais);
		        return pais;
		    }
			
			@PutMapping("/pais")
			public Pais modificarPais(@RequestBody Pais pais) {
				service.modificar(pais);
				return pais;
			}
			
			@DeleteMapping("/pais/{id}")
			public void eliminarPais(@PathVariable("id") Integer id) {
				service.eliminar(id);
			}
		
}
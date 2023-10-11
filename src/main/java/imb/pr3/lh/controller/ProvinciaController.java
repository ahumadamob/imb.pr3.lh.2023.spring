package imb.pr3.lh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import imb.pr3.lh.entity.Provincia;
import imb.pr3.lh.service.ProvinciaService;

@RestController
@RequestMapping("/Provincia")

public class ProvinciaController {
	
		@Autowired	
		private ProvinciaService provservicio;
		
		@GetMapping("/all")
		public List<Provincia> mostrarTodos() {
			return provservicio.mostrarTodos();
	    }
		
		@GetMapping("/{id}")
	    public Provincia mostrarPorId(@PathVariable Integer id) {
	        return provservicio.mostrarPorId(id);
		}
		
		@PostMapping("/")
	    public Provincia crear(@RequestBody Provincia provincia) {
	        return provservicio.crearProvincia(provincia);
	    }

	    @PutMapping("/{id}")
	    public Provincia modificar(@PathVariable Integer id, @RequestBody Provincia provincia) {
	        return provservicio.modificarProvincia(id, provincia);
	    }
		 @DeleteMapping("/{id}")
		    public void eliminar(@PathVariable Integer id) {
			 provservicio.eliminarProvincia(id);
		    }
	}
}

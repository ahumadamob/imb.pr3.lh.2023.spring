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

import imb.pr3.lh.entity.Alquiler;
import imb.pr3.lh.service.IAlquilerService;

//http://localhost:8080/api/v1/alquileres

@RestController
@RequestMapping("/api/v1")
public class AlquilerController {
	
	@Autowired
	private IAlquilerService alquilerService;
	
	@GetMapping("/alquileres")
	public List<Alquiler> mostrarTodos() {
        return alquilerService.mostrarAlquileres();
    }
	
    @GetMapping("/alquileres/{id}")
    public Alquiler mostrarAlquilerPorId(@PathVariable Integer id) {
        return alquilerService.mostrarAlquilerPorId(id);
    }
	
	@PostMapping("/alquileres")
    public Alquiler crearAlquiler(@RequestBody Alquiler alquiler) {
        alquilerService.crearAlquiler(alquiler);
        return alquiler;
    }
	
	@PutMapping("/alquileres")
	public Alquiler modificarAlquiler(@RequestBody Alquiler alquiler) {
		alquilerService.modificarAlquiler(alquiler);
		return alquiler;
	}
	
	@DeleteMapping("/alquileres/{id}")
	public void eliminarAlquiler(@PathVariable("id") Integer id) {
		alquilerService.eliminarAlquiler(id);
	}
	
}

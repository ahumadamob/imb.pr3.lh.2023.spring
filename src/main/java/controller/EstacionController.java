package controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Estacion;
import service.IEstacion;


//http://localhost:8081/app/v1/estacion

@RestController
@RequestMapping("/app/v1")
public class EstacionController {
	
	private IEstacion EstacionService;
	
	@GetMapping("/estacion")
	public List<Estacion> mostrarTodos(){
		return EstacionService.mostrarEstacion();
	}
	
	@GetMapping("/estacion/{id}")
	public Estacion mostrarEstacionPorId(@PathVariable Integer id) {
		return EstacionService.mostrarEstacionPorId(id);
	}
	
	@PostMapping("/estacion")
	public Estacion crearEstacion(@RequestBody Estacion estacion) {
		EstacionService.crearEstacion(estacion);
		return estacion;
	}
	
	@PutMapping("/estacion")
	public Estacion modificarEstacion(@RequestBody Estacion estacion) {
		EstacionService.modificarEstacion(estacion);
		return estacion;
	}
	
	@DeleteMapping("/estacion/{id}")
	public void eliminarEstacion(@PathVariable("id") Integer id) {
		EstacionService.eliminarEstacion(id);
		}
	
	
}

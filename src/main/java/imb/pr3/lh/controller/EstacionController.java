package imb.pr3.lh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.pr3.lh.entity.Estacion;
import imb.pr3.lh.service.IEstacion;
import jakarta.validation.ConstraintViolationException;


@RestController
@RequestMapping("/app/v1")
public class EstacionController {
	

	@Autowired
	private IEstacion EstacionService;
	
	@GetMapping("/estacion")
	public ResponseEntity<APIResponse<List<Estacion>>> mostrarTodos(){
		List<Estacion> estacion = EstacionService.buscarTodos();
		return (estacion.isEmpty())? ResponseUtil.notFound("No se encontraron estaciones"): ResponseUtil.success(estacion);
		//el "return...?" se refiere a un if mas sintetizado donde el : es un else
	}
	
	
	@GetMapping("/{id}")

	public ResponseEntity<APIResponse<Estacion>> mostrarEstacionPorId(@PathVariable Integer id) {
		
		return (EstacionService.existe(id))? ResponseUtil.success(EstacionService.buscarPorId(id)):ResponseUtil.notFound("Estacion No Encontrada o ID no ingresado"); 			
	}
	
	@PostMapping("/")
	public ResponseEntity<APIResponse<Estacion>>crearEstacion(@RequestBody Estacion estacion) {
		return (EstacionService.existe(estacion.getId()))? ResponseUtil.badRequest(""):ResponseUtil.created(EstacionService.guardar(estacion));
				
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<APIResponse<Estacion>> modificarEstacion(@RequestBody Estacion estacion) {
		return EstacionService.existe(estacion.getId()) 
				?ResponseUtil.success(EstacionService.guardar(estacion))
				:ResponseUtil.badRequest("No se pudo actualizar"+estacion+", el ID proporcionado");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse<Estacion>> eliminarEstacion(@PathVariable Integer id) {
		return EstacionService.existe(id)
				?ResponseUtil.success(EstacionService.eliminar(id))
				:ResponseUtil.badRequest("No se pudo eliminar");
		}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIResponse<Estacion>> handleConstraintViolationException(ConstraintViolationException ex){
		return ResponseUtil.handleConstraintException(ex);
	}
}

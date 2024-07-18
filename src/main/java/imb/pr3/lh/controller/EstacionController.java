package imb.pr3.lh.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.pr3.lh.entity.Estacion;
import imb.pr3.lh.service.IEstacion;


//http://localhost:8081/app/v1/estacion

@RestController
@RequestMapping("/app/v1")
public class EstacionController {
	
	private IEstacion EstacionService;
	
	
    public EstacionController(IEstacion EstacionService) {
	      this.EstacionService = EstacionService;
	}
	
	@GetMapping("/estacion")
	public APIResponse<List<Estacion>> mostrarTodos(){
		
		List<String> messages = new ArrayList<>();
		messages.add("Se muestra el listado de las estaciones correctamente");
		
		List<Estacion> listadoEstacion = EstacionService.mostrarEstacion();
		
		APIResponse<List<Estacion>> response = new APIResponse<>(200, messages, listadoEstacion);	
		response.setStatus(0);
		response.setMessages(messages);
		response.setData(EstacionService.mostrarEstacion());
		return response;
		
	}
	
	
	@GetMapping("/estacion/{id}")
    public APIResponse<Estacion> mostrarEstacionPorId(@PathVariable Integer id) {
        List<String> messages = new ArrayList<>();
        Integer status;

        Estacion EstacionPorId = EstacionService.mostrarEstacionPorId(id);
        if (EstacionPorId == null) {
            messages.add("No se encuentra una estacion con el ID proporcionado");
            status = 404;
        } else {
            status = 200;
        }
        APIResponse<Estacion> response = new APIResponse<>(status, messages, EstacionPorId);
        return response;
    }
	
	@PostMapping("/")
	public Estacion crearEstacion(@RequestBody Estacion estacion) {
		EstacionService.crearEstacion(estacion);
		return estacion;
	}
	
	@PutMapping("/estacion/{id}")
	public Estacion modificarEstacion(@RequestBody Estacion estacion) {
		EstacionService.modificarEstacion(estacion);
		return estacion;
	}
	
	@DeleteMapping("/estacion/{id}")
	public void eliminarEstacion(@PathVariable("id") Integer id) {
		EstacionService.eliminarEstacion(id);
		}
	
	
}

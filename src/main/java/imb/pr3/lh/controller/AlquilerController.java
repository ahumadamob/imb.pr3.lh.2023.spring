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

import imb.pr3.lh.entity.Alquiler;
import imb.pr3.lh.service.IAlquilerService;
import jakarta.validation.ConstraintViolationException;

//http://localhost:8080/api/v1/alquiler

@RestController
@RequestMapping("/api/v1/alquiler")
public class AlquilerController {
	
	@Autowired
	private IAlquilerService alquilerService;
	
	@GetMapping("")
	public ResponseEntity<APIResponse<List<Alquiler>>> buscarTodosLosAlquileres(){
		List<Alquiler> alquileres = alquilerService.buscarTodos();
		return alquileres.isEmpty() ? ResponseUtil.notFound("No hay alquileres")
				: ResponseUtil.success(alquileres);
	}
	
    @GetMapping("{id}")
    public ResponseEntity<APIResponse<Alquiler>> buscarAlquilerPorid(@PathVariable("id") Integer id){
    	Alquiler alquiler = alquilerService.buscarPorId(id);
    	return alquiler == null ? ResponseUtil.notFound("No se encontro el alquiler con el identificador proporcionado")
    			: ResponseUtil.success(alquiler);
    }
	
	@PostMapping("")
	public ResponseEntity<APIResponse<Alquiler>> crearAlquiler(@RequestBody Alquiler alquiler){
		return alquilerService.existe(alquiler.getId()) ? ResponseUtil.badRequest("No se pudo crear el alquiler, el Id ingresado ya existe")
				: ResponseUtil.created(alquilerService.guardar(alquiler));
	}
	
	@PutMapping("")
	 public ResponseEntity<APIResponse<Alquiler>> modificarAlquiler(@RequestBody Alquiler alquiler){
		return alquilerService.existe(alquiler.getId()) ? ResponseUtil.success(alquilerService.guardar(alquiler))
				: ResponseUtil.badRequest("No se pudo actualizar el alquiler, el id ingresado no ha sido creado");
	}
	
	
	// Método para buscar alquileres por ID de cliente
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<APIResponse<List<Alquiler>>> buscarAlquileresPorIdCliente(@PathVariable("clienteId") Integer clienteId) {
        List<Alquiler> alquileres = alquilerService.buscarPorIdCliente(clienteId);
        return alquileres.isEmpty() ? ResponseUtil.notFound("No se encontraron alquileres para el cliente con el ID proporcionado")
                : ResponseUtil.success(alquileres);
    }
	
    @DeleteMapping("{id}")
    public ResponseEntity<APIResponse<Alquiler>> eliminarAlquiler(@PathVariable("id") Integer id) {
        if (alquilerService.existe(id)) {
            alquilerService.eliminar(id); // Llama al método para eliminar el alquiler
            return ResponseUtil.success("Eliminacion correcta del alquiler"); // Confirmación de eliminación exitosa
        } else {
            return ResponseUtil.badRequest("No existe el alquiler con el id ingresado"); // Error si no existe
        }
    }
    
    @GetMapping("/estacion-salida/{estacionSalidaId}")
    public ResponseEntity<List<Alquiler>> buscarAlquileresPorEstacionSalida(@PathVariable Integer estacionSalidaId) {
        List<Alquiler> alquileres = alquilerService.buscarPorEstacionSalida(estacionSalidaId);
        return ResponseEntity.ok(alquileres);
    }
	//Excepciones
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIResponse<Alquiler>> handleException(Exception ex) {
		return ResponseUtil.badRequest(ex.getMessage());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<APIResponse<Alquiler>> handleConstraintViolationException(ConstraintViolationException ex) {
		return ResponseUtil.handleConstraintException(ex);
	}

}
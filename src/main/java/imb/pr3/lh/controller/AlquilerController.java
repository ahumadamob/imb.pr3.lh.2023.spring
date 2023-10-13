package imb.pr3.lh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
	public ResponseEntity<APIResponse<Alquiler>> crearAlquiler(@RequestBody Alquiler alquiler, BindingResult result){
		return alquilerService.existe(alquiler.getId()) ? ResponseUtil.badRequest("No se pudo crear el alquiler, el Id ingresado ya existe")
				: ResponseUtil.created(alquilerService.guardar(alquiler));
	}
	
	@PutMapping("")
	 public ResponseEntity<APIResponse<Alquiler>> modificarAlquiler(@RequestBody Alquiler alquiler){
		return alquilerService.existe(alquiler.getId()) ? ResponseUtil.success(alquilerService.guardar(alquiler))
				: ResponseUtil.badRequest("No se pudo actualizar el alquiler, el id ingresado no ha sido creado");
	}
	// Método para eliminar un Alquiler mediante una solicitud HTTP DELETE en una URL que utiliza "id" como parámetro pasado en el body de la consulta.
	@DeleteMapping("{id}")
	// Definición del método "eliminarAlquiler" que recibe un parámetro de tipo "id" de tipo Integer.
	// La anotación "@PathVariable" indica que el valor de "id" se tomará de la URL.
	// Devuelve un objeto ResponseEntity que contiene un objeto de tipo APIResponse que a su vez contiene un objeto de tipo Alquiler.
	public ResponseEntity<APIResponse<Alquiler>> eliminarAlquiler(@PathVariable("id") Integer id){
	// Se verifica si el ID del alquiler existe llamando al método "existe" del servicio "alquilerService".
	// Si la condición "alquilerService.existe(id)" es verdadera, significa que el alquiler existe, por lo tanto, se elimina al alquiler identificado por el ID.
	// En este caso, no se devuelve ningún contenido, solo se confirma la eliminación exitosa.
	   return alquilerService.existe(id) ? ResponseUtil.success(null)
	// Si la condición "alquilerService.existe(id)" es falsa, significa que el alquiler no existe.
    // En este caso, se genera una respuesta HTTP de error BadRequest con un mensaje que indica que el alquiler no existe.
			   : ResponseUtil.badRequest("No existe el alquiler con el id ingresado");
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
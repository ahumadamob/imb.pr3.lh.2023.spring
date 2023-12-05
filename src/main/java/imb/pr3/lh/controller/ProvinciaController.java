package imb.pr3.lh.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.pr3.lh.entity.Provincia;
import imb.pr3.lh.service.IProvinciaService;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/app/v1")

public class ProvinciaController {
	@Autowired	
	private IProvinciaService provservicio;
	
	@GetMapping ("/provincia")
	public ResponseEntity<APIResponse<List<Provincia>>>mostrarTodas() {
		List<Provincia> provincia=provservicio.buscarProvincia();
		return (provincia.isEmpty())
				? ResponseUtil.notFound("no se encontro registros")
		        : ResponseUtil.success(provincia);
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<Provincia>> mostrarPorId(@PathVariable("id") Integer id) {
	    return (provservicio.existeProvincia(id))
	    		? ResponseUtil.success(provservicio.buscarProvinciaPorId(id))
	    		: ResponseUtil.badRequest("No existe provincia con ese Id");
	}

	@PostMapping("/provincia")
	public ResponseEntity<APIResponse<Provincia>> crearProvincia(@RequestBody Provincia provincia) {
		return(provservicio.existeProvincia(provincia.getId()))
				? ResponseUtil.badRequest("La provincia ya existe")
			    :ResponseUtil.created(provservicio.guardarProvincia(provincia));
	}

    @PutMapping("/provincia")
	public ResponseEntity<APIResponse<Provincia>> modificarProvincia(@RequestBody Provincia provincia) {
	    return provservicio.existeProvincia(provincia.getId())
	    		? ResponseUtil.success(provservicio.guardarProvincia(provincia))
	            : ResponseUtil.badRequest("No se pudo modificar");   
	}
    
    @DeleteMapping("/provincia/{id}")
    public ResponseEntity<APIResponse<Provincia>> eliminar(@PathVariable("id") Integer id) {
		if (provservicio.existeProvincia(id)) {
				provservicio.eliminarProvincia(id);
				return ResponseUtil.success("Se elimino correctamente el medio de pago");
		}
		 else {
				return ResponseUtil.badRequest("No se pudo eliminar");
		}
    
    }
    
    @ExceptionHandler(Exception.class)
	public ResponseEntity<APIResponse<Provincia>> handleException(Exception ex) {
		return ResponseUtil.badRequest(ex.getMessage());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<APIResponse<Provincia>> handleConstraintViolationException(ConstraintViolationException ex) {
		return ResponseUtil.handleConstraintException(ex);
	}
}

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
import imb.pr3.lh.entity.MedioDePago;
import imb.pr3.lh.service.IMedioDePago;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/v1")
public class MedioDePagoContoller {

	@Autowired
	private IMedioDePago medioDePagoService;

	@GetMapping("/medioDePago")
	public ResponseEntity<APIResponse<List<MedioDePago>>> mostrarTodos() {
		List<MedioDePago> medioDePago = medioDePagoService.buscar();
		
		return (medioDePago.isEmpty())? ResponseUtil.notFound("no se encontraron registros")
				: ResponseUtil.success(medioDePago);
	}

	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<MedioDePago>> mostrarMedioDePagoPorId(@PathVariable("id") Integer id) {
		return (medioDePagoService.existe(id))? ResponseUtil.success(medioDePagoService.buscarPorId(id))
				: ResponseUtil.badRequest("el Id proporcionado no es valido");
	}

	@PostMapping("/medioDePago")
	public ResponseEntity<APIResponse<MedioDePago>> crearMedioDePago(@RequestBody MedioDePago medioDePago) {
		if(medioDePagoService.existe(medioDePago.getId())) {
			return ResponseUtil.badRequest("este medio de pago ya existe");
		}else {
			return ResponseUtil.created(medioDePagoService.guardar(medioDePago));
		}
	}

	@PutMapping("/medioDePago")
	public ResponseEntity<APIResponse<MedioDePago>> modificarMedioDePago(@RequestBody MedioDePago medioDePago) {
	   return medioDePagoService.existe(medioDePago.getId()) 
			   ? ResponseUtil.success(medioDePagoService.guardar(medioDePago)) 
			   : ResponseUtil.badRequest("no se pudo actualizar"+medioDePago+", el Id proporcionado no es valido");
	}

	@DeleteMapping("/medioDePago/{id}")
	public ResponseEntity<APIResponse<MedioDePago>> eliminarMedioDePago(@PathVariable("id") Integer id) {
		 if(medioDePagoService.existe(id)) {
			
			 	medioDePagoService.eliminar(id);
			 	return ResponseUtil.success("Se elimino correctamente el medio de pago");
		}
		 else {
				return ResponseUtil.badRequest("No se pudo eliminar el medio de pago para este Id");
			}
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIResponse<MedioDePago>> handleException(Exception ex) {
		return ResponseUtil.badRequest(ex.getMessage());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<APIResponse<MedioDePago>> handleConstraintViolationException(ConstraintViolationException ex) {
		return ResponseUtil.handleConstraintException(ex);
	}
	
}

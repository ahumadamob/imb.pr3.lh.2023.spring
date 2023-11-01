package imb.pr3.lh.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.pr3.lh.entity.MedioDePago;
import imb.pr3.lh.entity.Pago;
import imb.pr3.lh.service.PagoService;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/v1/pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<APIResponse<List<Pago>>> mostrarTodos() {
        
    	List<Pago>pago=pagoService.buscarTodos();
               
    	return (pago.isEmpty())? ResponseUtil.notFound("No se encontraron registros") : ResponseUtil.success(pago);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Pago>> mostrarPorId(@PathVariable Integer id) {
    	
    	return (pagoService.existe(id))? ResponseUtil.success(pagoService.buscarPorId(id)) : ResponseUtil.notFound("Pago no Encontrado");
		    	
    }

    @PostMapping    
    public ResponseEntity<APIResponse<Pago>> crearPago(@RequestBody Pago pago ) {
    	return (pagoService.existe(pago.getId()))? ResponseUtil.badRequest("Pago ya Existente") : ResponseUtil.created(pagoService.guardar(pago));
    }
    
	@PutMapping
	public ResponseEntity<APIResponse<Pago>> modificarPago(@RequestBody Pago pago){
		return pagoService.existe(pago.getId()) ? ResponseUtil.success(pagoService.guardar(pago)) : ResponseUtil.badRequest("No se pudo actualizar el pago, el id ingresado no existe");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse<MedioDePago>> eliminarPago(@PathVariable("id") Integer id) {
		 if(pagoService.existe(id)) {
			
			 	pagoService.eliminar(id);
			 	return ResponseUtil.success("Se elimino correctamente el registro de pago");
		}
		 else {
				return ResponseUtil.badRequest("No se pudo eliminar el registro de pago para este Id");
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


package imb.pr3.lh.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.pr3.lh.entity.Pago;
import imb.pr3.lh.service.PagoService;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/pago")
    public ResponseEntity<APIResponse<List<Pago>>> mostrarTodos() {
        
    	List<Pago>pago=pagoService.buscarTodos();
               
    	return (pago.isEmpty())? ResponseUtil.notFound("No se encontraron registros") : ResponseUtil.success(pago);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<Pago>> mostrarPorId(@PathVariable Integer id) {
    	
    	return (pagoService.existe(id))? ResponseUtil.success(pagoService.buscarPorId(id)) : ResponseUtil.notFound("Pago no Encontrado");
		    	
    }

    @PostMapping("/")
    
    public ResponseEntity<APIResponse<Pago>> crearPago(@PathVariable Pago pago ) {
    	return (pagoService.existe(pago.getId()))? ResponseUtil.badRequest("Pago ya Existente") : ResponseUtil.created(pagoService.guardar(pago));
    }
    
	@PutMapping("")
	 public ResponseEntity<APIResponse<Pago>> modificarPago(@RequestBody Pago pago){
		return pagoService.existe(pago.getId()) ? ResponseUtil.success(pagoService.guardar(pago)) : ResponseUtil.badRequest("No se pudo actualizar el pago, el id ingresado no existe");
	}

 

    @DeleteMapping("/{id}")
	 public ResponseEntity<APIResponse<Pago>> eliminarPago(@RequestBody Integer id){
		return pagoService.existe(id) ? ResponseUtil.success(pagoService.eliminar(id)) : ResponseUtil.badRequest("No se pudo eliminar el pago, el id ingresado no existe");
	}
    
    
}


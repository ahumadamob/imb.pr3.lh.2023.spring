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

import imb.pr3.lh.entity.Inventario;
import imb.pr3.lh.service.IInventarioService;
import jakarta.validation.ConstraintViolationException;

@RestController
@RequestMapping("/api/v1")
public class InventarioController {
	
	@Autowired
	private IInventarioService inventarioService;
	
	@GetMapping("/inventario")
	public ResponseEntity<APIResponse<List<Inventario>>> buscarTodosLosInventarios(){
		List<Inventario> inventario = inventarioService.buscarTodos();
		return inventario.isEmpty() ? ResponseUtil.notFound("No hay inventario :(") : ResponseUtil.success(inventario);
	}
	
    @GetMapping("inventario/{id}")
    public ResponseEntity<APIResponse<Inventario>> buscarInventarioPorid(@PathVariable("id") Integer id){
    	Inventario inventario = inventarioService.buscarPorId(id);
    	return inventario == null ? ResponseUtil.notFound("No hay inventario con ese id :(") : ResponseUtil.success(inventario);
    }
	
	@PostMapping("/inventario")
	public ResponseEntity<APIResponse<Inventario>> crearInventario(@RequestBody Inventario inventario){
		return inventarioService.existe(inventario.getId()) ? ResponseUtil.badRequest("No se puede crear el inventario,porque  el id ingresado ya existe") : ResponseUtil.created(inventarioService.guardar(inventario));
	}
	
	@PutMapping("/inventario")
	 public ResponseEntity<APIResponse<Inventario>> modificarInvenatrio(@RequestBody Inventario inventario){
		return inventarioService.existe(inventario.getId()) ? ResponseUtil.success(inventarioService.guardar(inventario)) : ResponseUtil.badRequest("No podemos actualizar el inventario,porque el id ingresado no ha sido creado");
	}
	
	@DeleteMapping("/inventario/{id}")
	public ResponseEntity<APIResponse<Inventario>> eliminarInventario(@PathVariable("id") Integer id){
	   return inventarioService.existe(id) ? ResponseUtil.success(null) : ResponseUtil.badRequest("No existe el inventario con el id proporcionado");
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<APIResponse<Inventario>> handleException(Exception ex) {
		return ResponseUtil.badRequest(ex.getMessage());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<APIResponse<Inventario>> handleConstraintViolationException(ConstraintViolationException ex) {
		return ResponseUtil.handleConstraintException(ex);
	}
}
package imb.pr3.lh.controller;


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

import imb.pr3.lh.entity.Pais;
import imb.pr3.lh.service.IPaisService;
import jakarta.validation.ConstraintViolationException;


import java.util.List;


@RestController
@RequestMapping("/api/v1/")
public class PaisController {
	
	@Autowired	
	private IPaisService iPaisService;
	
	@GetMapping("/pais")
	
         public ResponseEntity<APIResponse<List<Pais>>>mostrarTodos() {
			
			List<Pais> pais = iPaisService.buscarTodos();
			return (pais.isEmpty())? ResponseUtil.notFound("No se encontraron registros")
					: ResponseUtil.success(pais);
	
	}
         public List<Pais> verTodos(){
		return iPaisService.buscarTodos();
}
		 @GetMapping("/pais/{id}")
		 
		 public ResponseEntity<APIResponse<Pais>> buscarPorId (@PathVariable Integer id) {
			 
	        return  (iPaisService.existe(id)) ? ResponseUtil.success(iPaisService.buscarPorId(id)) 
	        		:  ResponseUtil.notFound("El ID indicado  no es valido");
			 }
		 @GetMapping("/pais/idioma/{idiomaOficial}")
		 public ResponseEntity<APIResponse<List<Pais>>> buscarPorIdiomaOficial(@PathVariable String idiomaOficial) {
		     List<Pais> paises = iPaisService.buscarPorIdiomaOficial(idiomaOficial);

		     if (idiomaOficial == null) {
		         return ResponseUtil.badRequest("El idioma oficial proporcionado es nulo");
		     }

		     return (paises.isEmpty()) ? ResponseUtil.notFound("No se encontraron países con el idioma oficial indicado")
		             : ResponseUtil.success(paises);
		 }

			
			
			@PostMapping("/pais")
		    public ResponseEntity<APIResponse<Pais>> crearPais(@RequestBody Pais pais) {
				if (iPaisService.existe(pais.getId())) {
					return ResponseUtil.badRequest("Este pais ya existe");
					
				}else {
				
				return  ResponseUtil.created(iPaisService.guardar(pais));
                }
            	
			}
			@PutMapping("/pais/{id}")
			public ResponseEntity<APIResponse<Pais>> modificarPais(@PathVariable Integer id, @RequestBody Pais nuevoPais) {
			    if (!iPaisService.existe(id)) {
			        return ResponseUtil.notFound("El país con el ID indicado no existe");
			    }

			    // Obtener el país existente
			    Pais paisExistente = iPaisService.buscarPorId(id);

			    // Actualizar los campos que desees
			    paisExistente.setNombre(nuevoPais.getNombre());
			    paisExistente.setHabilitado(nuevoPais.getHabilitado());
			    paisExistente.setIdiomaOficial(nuevoPais.getIdiomaOficial());

			    // Guardar la actualización
			    Pais paisActualizado = iPaisService.guardar(paisExistente);

			    return ResponseUtil.success(paisActualizado);
			}


			//@PutMapping ("/pais")
		    //public ResponseEntity<APIResponse<Pais>> modificarPais(@RequestBody Pais pais) {
			 //return iPaisService.existe(pais.getId())? ResponseUtil.success(iPaisService.guardar(pais)) 
				//	 : ResponseUtil.badRequest("Este Pais no se puedo actualizar");
                 
             	 //}
		 
			
			@DeleteMapping("/pais/{id}")
		    public ResponseEntity<APIResponse<Pais>>eliminarPais(@PathVariable("id") Integer id) {
			if (iPaisService.existe(id)) { 
				
				iPaisService.eliminar(id);
				return  ResponseUtil.success("Se elimino correctamente el pais");
			}
			else {
				
			    return ResponseUtil.badRequest("No se pudo eliminar el Pais");
			}
		}
	
			@ExceptionHandler(Exception.class)
			public ResponseEntity<APIResponse<Pais>> handleException(Exception ex) {
				return ResponseUtil.badRequest(ex.getMessage());
			}

			@ExceptionHandler(ConstraintViolationException.class)
			public ResponseEntity<APIResponse<Pais>> handleConstraintViolationException(ConstraintViolationException ex) {
				return ResponseUtil.handleConstraintException(ex);
			}
}

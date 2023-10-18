package imb.pr3.lh.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


import imb.pr3.lh.entity.Pais;
import imb.pr3.lh.service.IPaisService;

@RestController
@RequestMapping("/api/v1/pais")
public class PaisController {
	
	@Autowired	
	private IPaisService iPaisService;
	
	@GetMapping("")
	
         public ResponseEntity<APIResponse<List<Pais>>>mostrarTodos() {
			
			List<Pais> pais = iPaisService.buscarTodos();
			return (pais.isEmpty())? ResponseUtil.notFound("no se encontro registros"): ResponseUtil.success(pais);
	
	}
         public List<Pais> verTodos(){
		return iPaisService.buscarTodos();
}
		 @GetMapping("/{id}")
		 
		 public ResponseEntity<APIResponse<Pais>> buscarPorId (@PathVariable Integer id) {
			 
	        return  (iPaisService.existe(id)) ? ResponseUtil.success(iPaisService.buscarPorId(id)) :  ResponseUtil.notFound("No se encontraron elementos");
			 }
			
			
			@PostMapping("/pais")
		    public ResponseEntity<APIResponse<Pais>> crearPais(@RequestBody Pais pais) {
				return (iPaisService.existe(pais.getId())) ?  ResponseUtil.badRequest(""): ResponseUtil.created(iPaisService.guardar(pais));
                }

			@PutMapping ("/pais")
		    public ResponseEntity<APIResponse<Pais>> modificarPais(@RequestBody Pais pais) {
			 return iPaisService.existe(pais.getId())? ResponseUtil.success(iPaisService.guardar(pais)) : ResponseUtil.badRequest("no act");
                 
             	 }
		 
			
			@DeleteMapping("/pais/{id}")
		    public ResponseEntity<APIResponse<Pais>>eliminarPais(@RequestBody Integer id) {
				return iPaisService.existe(id) ? ResponseUtil.success(iPaisService.eliminar(id)) :ResponseUtil.badRequest("no act");
			}
		
		 }
	


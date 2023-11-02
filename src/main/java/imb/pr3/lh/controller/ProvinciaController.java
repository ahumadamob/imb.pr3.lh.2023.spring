package imb.pr3.lh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.pr3.lh.entity.Provincia;
import imb.pr3.lh.service.IProvinciaService;

@RestController
@RequestMapping("/Provincia")

public class ProvinciaController {
	
	@Autowired
		private IProvinciaService provservicio;
		
		@GetMapping ("/")
		public ResponseEntity<APIResponse<List<Provincia>>>buscartodaslasprovinciass() {
			List<Provincia> provincia=provservicio.buscarTodos();
			return (provincia.isEmpty())? ResponseUtil.notFound("no se encontro registros")
		    : ResponseUtil.success(provincia);
		}
	
		@GetMapping("/{id}")
	    public ResponseEntity<APIResponse<Provincia>> buscarPorIdProvincia(@PathVariable Integer id) {
			return (provservicio.existe(id))? ResponseUtil.success(provservicio.buscarPorId(id))
			: ResponseUtil.badRequest("No existe provincia con ese Id");
		}
		
		@PostMapping("/Provincia")
		public ResponseEntity<APIResponse<Provincia>> guardarProvincia(@RequestBody Provincia provincia) {
			return(provservicio.existe(provincia.getId()))? ResponseUtil.badRequest("La provincia ya existe")
			:ResponseUtil.created(provservicio.guardar(provincia));
		 }
		 
		 @PutMapping("/")
		 public ResponseEntity<APIResponse<Provincia>> modificarProvincia(@PathVariable Provincia provincia) {
	        return provservicio.existe(provincia.getId())? ResponseUtil.success(provservicio.guardar(provincia))
	        : ResponseUtil.badRequest("No se pudo modificar");   
	        
		}
 
		 @DeleteMapping("/Provincia{id}")
		 public ResponseEntity<APIResponse<Provincia>> eliminarProvincia(@PathVariable Integer id) {
			 if(provservicio.existe(id)) {
				 provservicio.eliminar(id);
				return ResponseUtil.success("se elimino el id correctamente");
			 } else {
			return	 ResponseUtil.badRequest("No se pudo eliminar"); 
			 }
		       
		    }
		
	}


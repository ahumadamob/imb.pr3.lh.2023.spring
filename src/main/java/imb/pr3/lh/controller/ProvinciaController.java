package imb.pr3.lh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.pr3.lh.entity.Provincia;
import imb.pr3.lh.service.IProvinciaService;

@RestController
@RequestMapping("/api/v1/Provincia")
public class ProvinciaController {
	
	@Autowired
	private IProvinciaService provservicio;
		
	@GetMapping
	public ResponseEntity<APIResponse<List<Provincia>>> buscarTodasLasProvincias() {
		List<Provincia> provincias = provservicio.buscarTodos();
		return (provincias.isEmpty()) ? ResponseUtil.notFound("No se encontraron registros")
				: ResponseUtil.success(provincias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<APIResponse<Provincia>> buscarPorIdProvincia(@PathVariable Integer id) {
		return (provservicio.existe(id)) ? ResponseUtil.success(provservicio.buscarPorId(id))
				: ResponseUtil.badRequest("No existe una provincia con ese ID");
	}
	
	@PostMapping
	public ResponseEntity<APIResponse<Provincia>> guardarProvincia(@RequestBody Provincia provincia) {
		return (provservicio.existe(provincia.getId())) ? ResponseUtil.badRequest("La provincia ya existe")
				: ResponseUtil.created(provservicio.guardar(provincia));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<APIResponse<Provincia>> modificarProvincia(@PathVariable Integer id, @RequestBody Provincia provincia) {
		if (provservicio.existe(id)) {
			provincia.setId(id);
			return ResponseUtil.success(provservicio.guardar(provincia));
		} else {
			return ResponseUtil.badRequest("No se pudo modificar la provincia");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<APIResponse<Provincia>> eliminarProvincia(@PathVariable Integer id) {
		if (provservicio.existe(id)) {
			provservicio.eliminar(id);
			return ResponseUtil.success("Se eliminó la provincia correctamente");
		} else {
			return ResponseUtil.badRequest("No se pudo eliminar la provincia");
		}
	}
}
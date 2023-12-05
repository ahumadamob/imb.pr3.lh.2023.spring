package imb.pr3.lh.controller;

import java.util.List;

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

import imb.pr3.lh.entity.Catalogo;
import imb.pr3.lh.service.ICatalogoService;

// localhost:8080/api/v1/catalogo

@RestController
@RequestMapping("/api/v1/catalogo")
public class CatalogoController {
	
	@Autowired
	private ICatalogoService service;
	
		// Método para eliminar un Alquiler mediante una solicitud HTTP DELETE en una URL que utiliza "id" como parámetro pasado en el body de la consulta.
	@GetMapping
		
		// Definición del método "buscarTodosCatalogo" que realiza la funcion de ir a buscar todos los productos creados en el Catalogo.
		// La anotación "@GetMapping" indica que la busqueda, peticion del tipo get, se realizara en la URL indicada.
		// Devuelve un objeto ResponseEntity que contiene un objeto de tipo APIResponse que a su vez contiene la list del objeto Catalogo.
	public ResponseEntity<APIResponse<List<Catalogo>>> buscarTodosCatalogo(){
		
		// Realizada la peticion, devuelve todo el contenido del catalogo, en caso de estar vacio no devolvera ningún contenido.

		List<Catalogo> catalogo = service.buscarTodos();
		return catalogo.isEmpty() ? ResponseUtil.notFound("No se encuentro el producto")
				: ResponseUtil.success(catalogo);
				
	}
	
	 @GetMapping("/{id}")
	 	// En este caso, como se especifica entre (), se verifica si el ID del catalogo existe, llamando al método "buscarPorIdCatalogo" del servicio "service".
	 	// En caso de hallar el ID en el catalogo, devolvera el producto correspondiente; en caso contrario un mensaje aclarando que el ID no fue hallado.
	 public ResponseEntity<APIResponse<Catalogo>> buscarPorIdCatalogo(@PathVariable("id") Integer id){
	    Catalogo catalogo = service.buscarPorId(id);
	    return catalogo == null ? ResponseUtil.notFound("No se encontro el producto con el identificador proporcionado")
	    		: ResponseUtil.success(catalogo);
	}
	 
	 @PostMapping
	 public ResponseEntity<APIResponse<Catalogo>> crearCatalogo(@RequestBody Catalogo catalogo){
		return service.existe(catalogo.getId()) ? ResponseUtil.badRequest("No se pudo crear el producto del catalogo, el Id ingresado ya existe")
				: ResponseUtil.created(service.guardar(catalogo));
	 }
	 
	 @PutMapping
	 public ResponseEntity<APIResponse<Catalogo>> modificarCatalogo(@RequestBody Catalogo catalogo){
		return service.existe(catalogo.getId()) ? ResponseUtil.success(service.guardar(catalogo))
				: ResponseUtil.badRequest("No se pudo actualizar el catalogo, el id ingresado no ha sido creado");
	}
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<APIResponse<Catalogo>> eliminar(@PathVariable("id") Integer id){
		 return service.existe(id) ? ResponseUtil.success(null)
				 : ResponseUtil.badRequest("No existe el producto con el id ingresado");
	 }
}





















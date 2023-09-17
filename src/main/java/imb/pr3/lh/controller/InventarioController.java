package imb.pr3.lh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import imb.pr3.lh.entity.Inventario;
import imb.pr3.lh.service.IInventarioService;

@RestController
@RequestMapping("/api/v1")
public class InventarioController {
	@Autowired
	private IInventarioService inventarioService;
	
	@GetMapping("/inventario")
	public List<Inventario> getAll() {
        return inventarioService.getAll();
    }
	
    @GetMapping("/inventario/{id}")
    public Inventario getXId(@PathVariable Integer id) {
        return inventarioService.getXId(id);
    }
	
	@PostMapping("/inventario")
    public Inventario crearIInventario(@RequestBody Inventario inv) {
		inventarioService.crearIInventario(inv);
        return inv;
    }
	
	@PutMapping("/inventario")
	public Inventario modIInventario(@RequestBody Inventario inv) {
		inventarioService.modIInventario(inv);
		return inv;
	}
	
	@DeleteMapping("/inventario/{id}")
	public void eliminarIInventario(@PathVariable("id") Integer id) {
		inventarioService.eliminarIInventario(id);
	}
}

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

import imb.pr3.lh.entity.MedioDePago;
import imb.pr3.lh.service.IMedioDePago;

@RestController
@RequestMapping("/api/v1")

public class MedioDePagoContoller {

	@Autowired

	private IMedioDePago medioDePagoService;

	@GetMapping("/medioDePago")

	public List<MedioDePago> mostrarTodos() {
		return medioDePagoService.mostrarMedioDePago();

	}

	@GetMapping("/{id}")
	public MedioDePago mostrarMedioDePagoPorId(@PathVariable Integer id) {
		return medioDePagoService.mostrarMedioDePagoPorId(id);
	}

	@PostMapping("/medioDePago")
	public MedioDePago crearMedioDePago(@RequestBody MedioDePago medioDePago) {
		medioDePagoService.crearMedioDePago(medioDePago);
		return medioDePago;
	}

	@PutMapping("/medioDePago")
	public MedioDePago modificarMedioDePago(@RequestBody MedioDePago medioDePago) {
		medioDePagoService.modificarMedioDePago(medioDePago);
		return medioDePago;
	}

	@DeleteMapping("/medioDePago/{id}")
	public void eliminarMedioDePago(@PathVariable("id") Integer id) {
		medioDePagoService.eliminarMedioDePago(id);
	}

}

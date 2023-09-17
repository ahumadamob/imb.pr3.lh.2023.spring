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

import imb.pr3.lh.entity.Cliente;
import imb.pr3.lh.service.IClienteService;


@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	
	@Autowired
	private IClienteService  clienteservice;
	
	@GetMapping("/Cliente")
	public List<Cliente> mostrarCliente() {
        return clienteservice.mostrarCliente();
    }
	
    @GetMapping("/Cliente/{id}")
    public Cliente mostrarClientePorId(@PathVariable Integer id) {
        return clienteservice.mostrarClientePorId(id);
    }
	
	@PostMapping("/Cliente")
    public Cliente crearICliente(@RequestBody Cliente cli) {
		        clienteservice.crearICliente(cli);
        return cli;
    }
	
	@PutMapping("/Cliente")
	public Cliente modificarICliente(@RequestBody Cliente cli) {
		clienteservice.modificarICliente(cli);
		return cli;
	}
	
	@DeleteMapping("/Cliente/{id}")
	public void eliminarICliente(@PathVariable("id") Integer id) {
		clienteservice.eliminarICliente(id);
	}
	

}

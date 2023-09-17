package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> mostrarCliente();
	public Cliente mostrarClientePorId(Integer id);
	public void crearICliente(Cliente cli);
	public void modificarICliente(Cliente cli);
	public void eliminarICliente(Integer id);
	
	
}

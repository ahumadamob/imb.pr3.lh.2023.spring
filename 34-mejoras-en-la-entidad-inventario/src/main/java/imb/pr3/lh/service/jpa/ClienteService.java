package imb.pr3.lh.service.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.Cliente;
import imb.pr3.lh.repository.ClienteRepository;
import imb.pr3.lh.service.IClienteService;

@Service
public class ClienteService implements IClienteService {
	
	private ClienteRepository clirepo;

	@Override
	public List<Cliente> mostrarCliente() {
		return clirepo.findAll();
	}

	@Override
	public Cliente mostrarClientePorId(Integer id) {
		return clirepo.findById(id).orElse(null);
	}

	@Override
	public void crearICliente(Cliente cli) {
		clirepo.save(cli);

	}

	@Override
	public void modificarICliente(Cliente cli) {
		clirepo.save(cli);
	}

	@Override
	public void eliminarICliente(Integer id) {
		clirepo.deleteById(id);
	}

}


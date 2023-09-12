package imb.pr3.lh.service.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.Inventario;
import imb.pr3.lh.repository.InventarioRepository;
import imb.pr3.lh.service.IInventarioService;
@Service
public class InventarioService implements IInventarioService {
	
	private InventarioRepository invrepo;

	@Override
	public List<Inventario> getAll() {
		return invrepo.findAll();
	}

	@Override
	public Inventario getXId(Integer id) {
		return invrepo.findById(id).orElse(null);
	}

	@Override
	public void crearIInventario(Inventario inv) {
		invrepo.save(inv);
		
	}

	@Override
	public void modIInventario(Inventario inv) {
		invrepo.save(inv);
	}

	@Override
	public void eliminarIInventario(Integer id) {
		invrepo.deleteById(id);
	}

}

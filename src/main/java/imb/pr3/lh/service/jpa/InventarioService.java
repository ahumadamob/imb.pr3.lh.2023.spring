package imb.pr3.lh.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.Inventario;
import imb.pr3.lh.repository.InventarioRepository;
import imb.pr3.lh.service.IInventarioService;

@Service
public class InventarioService implements IInventarioService {
	
	@Autowired
	private InventarioRepository inventarioRepository;
	
	@Override
	public List<Inventario> buscarTodos() {
		return inventarioRepository.findAll();
		//inventarioRepository.find
	}

	@Override
	public Inventario buscarPorId(Integer id) {
		 Optional<Inventario> optional = inventarioRepository.findById(id);
		 return optional.orElse(null);
    }
	
	@Override
	public Inventario guardar(Inventario inventario) {
		 return inventarioRepository.save(inventario);
	}

	@Override
	public void eliminar(Integer id) {
		 inventarioRepository.deleteById(id);
	}
	
	@Override
	public boolean existe(Integer id) {
		 return id != null && inventarioRepository.existsById(id);
	}

	@Override
	public List<Inventario> buscarPorDisponible(boolean disp) {
		return inventarioRepository.findByDisponibilidad(disp);
	}

}
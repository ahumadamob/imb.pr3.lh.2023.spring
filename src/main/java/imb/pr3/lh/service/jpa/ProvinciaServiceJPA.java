package imb.pr3.lh.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import imb.pr3.lh.entity.Provincia;
import imb.pr3.lh.repository.ProvinciaRepository;
import imb.pr3.lh.service.ProvinciaService;

public class ProvinciaServiceJPA implements ProvinciaService {
	
@ Autowired

private ProvinciaRepository provinciaRepository;

	@Override
	public List<Provincia> buscarTodos() {
		return provinciaRepository.findAll();
	}

	@Override
	public Provincia buscarPorId(Integer id) {
		Optional<Provincia> optional;
		optional =provinciaRepository.findAll(id);
		if (optional.isPresent()) {
		return optional.get();
		}else {
		return null;
		}
	}

	@Override
	public Provincia guardar(Provincia provincia) {
		return provinciaRepository.save(provincia);
	}

	@Override
	public boolean  existe(Integer id) {
		return provinciaRepository.existsById(id);
	}

	@Override
	public Provincia eliminar(Integer id) {
		provinciaRepository.deleteById(id);;
		return null;
		
	}

}

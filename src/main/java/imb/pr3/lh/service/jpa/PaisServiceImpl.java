package imb.pr3.lh.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.Pais;
import imb.pr3.lh.repository.PaisRepository;
import imb.pr3.lh.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService {
	
@Autowired
private PaisRepository paisRepository;

	@Override
	public List<Pais> buscarTodos() {
		return paisRepository.findAll();
		
	}

	@Override
	public Pais buscarPorId(Integer id) {
		Optional<Pais> optional;
		optional = paisRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	
	
	}

	@Override
	public Pais guardar(Pais pais) {
		return paisRepository.save(pais);
		
	}

	@Override
	public Pais eliminar(Integer id) {
		paisRepository.deleteById(id);
		return null;
	}

	@Override
	public boolean existe(Integer id) {
	
		return paisRepository.existsById(id);
	
	}
}
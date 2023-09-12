package imb.pr3.lh.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import imb.pr3.lh.entity.Pais;
import imb.pr3.lh.repository.PaisRepository;
import imb.pr3.lh.service.IPaisService;

@Service

public class PaisService implements IPaisService {
	
	@Autowired
	private  PaisRepository paisRepository;

	@Override
	public List<Pais> buscarTodos() {
		return paisRepository.findAll();
		}

	@Override
	public Pais buscarPorId(Integer id) {
		return paisRepository.findById(id).orElse(null);
	}
	
	@Override
	public void crear(Pais pais) {
	   paisRepository.save(pais);
	}

	@Override
	public void guardar(Pais pais) {
		paisRepository.save(pais);

	}

	@Override
	public void modificar(Pais pais) {
		paisRepository.save(pais);

	}

	@Override
	public void eliminar(Integer id) {
		paisRepository.deleteById(id);
	}

}

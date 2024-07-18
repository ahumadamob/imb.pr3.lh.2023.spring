package imb.pr3.lh.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.Alquiler;
import imb.pr3.lh.repository.AlquilerRepository;
import imb.pr3.lh.service.IAlquilerService;

@Service
public class AlquilerService implements IAlquilerService {
	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Override
	public List<Alquiler> buscarTodos() {
		return alquilerRepository.findAll();
	}

	@Override
	public Alquiler buscarPorId(Integer id) {
		 Optional<Alquiler> optional = alquilerRepository.findById(id);
		 return optional.orElse(null);
    }
	
	@Override
	public Alquiler guardar(Alquiler alquiler) {
		 return alquilerRepository.save(alquiler);
	}

	@Override
	public void eliminar(Integer id) {
		 alquilerRepository.deleteById(id);
	}
	
	@Override
	public boolean existe(Integer id) {
		 return id != null && alquilerRepository.existsById(id);
	}

}
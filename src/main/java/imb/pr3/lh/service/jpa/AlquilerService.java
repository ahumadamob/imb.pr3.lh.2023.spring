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
	public List<Alquiler> mostrarAlquileres() {
		return alquilerRepository.findAll();
	}

	@Override
	public Alquiler mostrarAlquilerPorId(Integer id) {
		Optional<Alquiler>optional;
		optional = alquilerRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	@Override
	public void crearAlquiler(Alquiler alquiler) {
	    alquilerRepository.save(alquiler);
	}

	@Override
	public void modificarAlquiler(Alquiler alquiler) {
		 alquilerRepository.save(alquiler);
	}

	@Override
	public void eliminarAlquiler(Integer id) {
		 alquilerRepository.deleteById(id);
	}
}
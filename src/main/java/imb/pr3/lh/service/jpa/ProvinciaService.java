package imb.pr3.lh.service.jpa;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.Provincia;
import imb.pr3.lh.repository.ProvinciaRepository;
import imb.pr3.lh.service.IProvinciaService;

@Service
public class ProvinciaService implements IProvinciaService {
	
	@ Autowired
	private ProvinciaRepository provinciaRepository;
	
	@Override
	public List<Provincia> buscarProvincia() {

		return provinciaRepository.findAll();
	}
	
	@Override
	public Provincia buscarProvinciaPorId(Integer id) {

		Optional<Provincia>optional;
		optional = provinciaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	@Override
	public boolean existeProvincia(Integer id) {
		
		return	provinciaRepository.existsById(id);
	}

	@Override
	public Provincia guardarProvincia(Provincia provincia) {
		
		 return provinciaRepository.save(provincia);
	}

	@Override
	public void eliminarProvincia(Integer id) {
		
		provinciaRepository.deleteById(id);
	}

	

}
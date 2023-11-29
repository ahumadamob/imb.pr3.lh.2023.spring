package imb.pr3.lh.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.MedioDePago;
import imb.pr3.lh.repository.MedioDePagoRepository;
import imb.pr3.lh.service.IMedioDePago;

@Service

public class MedioDePagoService implements IMedioDePago {
	@Autowired
	private MedioDePagoRepository medioDePagoRepository;

	@Override

	public List<MedioDePago> buscar() {

		return medioDePagoRepository.findAll();
	}

	@Override
	public MedioDePago buscarPorId(Integer id) {
		
		return medioDePagoRepository.findById(id).orElse(null);
	}

	@Override
	public MedioDePago guardar(MedioDePago medioDePago) {
		
		 return medioDePagoRepository.save(medioDePago);
	}


	@Override
	public void eliminar(Integer id) {
		
		medioDePagoRepository.deleteById(id);
	}

	@Override
	public boolean existe(Integer id) {
		if(id == null) {
			return false;
		}else {
		return	medioDePagoRepository.existsById(id);
		}
	}
	
	@Override
	public List<MedioDePago> buscarPorActivo(boolean activo) {
		return medioDePagoRepository.findByActivo(activo);
	}
}

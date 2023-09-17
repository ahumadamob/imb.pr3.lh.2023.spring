package imb.pr3.lh.service.jpa;

import java.util.List;
import java.util.Optional;

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

	public List<MedioDePago> mostrarMedioDePago() {

		return medioDePagoRepository.findAll();
	}

	@Override
	public MedioDePago mostrarMedioDePagoPorId(Integer id) {
		Optional<MedioDePago> optional;
		optional = medioDePagoRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	@Override
	public void crearMedioDePago(MedioDePago medioDePago) {
		medioDePagoRepository.save(medioDePago);
	}

	@Override
	public void modificarMedioDePago(MedioDePago medioDePago) {
		medioDePagoRepository.save(medioDePago);
	}

	@Override
	public void eliminarMedioDePago(Integer id) {
		medioDePagoRepository.deleteById(id);
	}
}

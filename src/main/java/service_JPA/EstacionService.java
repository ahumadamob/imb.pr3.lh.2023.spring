package service_JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import entity.Estacion;
import repository.EstacionRepository;
import service.IEstacion;

public class EstacionService implements IEstacion{

	@Autowired
	private EstacionRepository estacionRepository;
	
	@Override
	public List<Estacion> mostrarEstacion(){
		return estacionRepository.findAll();
	}
	
	public Estacion mostrarEstacionPorId(Integer id) {
		Optional<Estacion>optional;
		optional = estacionRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	@Override
	public void crearEstacion(Estacion estacion) {
		estacionRepository.save(estacion);		
	}

	@Override
	public void modificarEstacion(Estacion estacion) {
		estacionRepository.save(estacion);		
	}

	@Override
	public void eliminarEstacion(Integer id) {
		estacionRepository.deleteById(id);		
	
	}

		
}

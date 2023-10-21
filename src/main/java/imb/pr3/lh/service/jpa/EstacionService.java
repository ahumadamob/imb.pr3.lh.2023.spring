package imb.pr3.lh.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import imb.pr3.lh.entity.Estacion;
import imb.pr3.lh.repository.EstacionRepository;
import imb.pr3.lh.service.IEstacion;

public class EstacionService implements IEstacion{

	@Autowired
	private EstacionRepository estacionRepository;
	@Override
	public List<Estacion> buscarTodos() {
		return estacionRepository.findAll();	
	}

	@Override
	public Estacion buscarPorId(Integer id) {
		Optional<Estacion>optional;
		optional = estacionRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}		
	}

	@Override
	public Estacion guardar(Estacion estacion) {
		return estacionRepository.save(estacion);
	}

	@Override
	public Estacion eliminar(Integer id) {
		estacionRepository.deleteById(id);
		return null;
	} //Se coloca el return null ya que necesitamos que en el EstacionController se pueda eliminar el Id, es decir, el deleteById.

	@Override
	public boolean existe(Integer id) {
		return estacionRepository.existsById(id);		
	}

	//Se cambio al codigo anterior ya que se tiene que unificar todo
	/*@Autowired
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
	
	}*/

		
}

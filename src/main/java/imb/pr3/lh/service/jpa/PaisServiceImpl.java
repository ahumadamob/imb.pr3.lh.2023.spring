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

/*  Esta línea inyecta una instancia de PaisRepository en el servicio 
 * mediante la anotación @Autowired.
 *  Esto permite que el servicio acceda a los métodos 
 *  proporcionados por el repositorio para 
 *  interactuar con la base de datos.*/

	@Override
	public List<Pais> buscarTodos() {
		return paisRepository.findAll();
		
	}
	
	/*   Este método buscarTodos devuelve una lista de todos los objetos Pais en la base de datos. 
	 *   Utiliza el método findAll() proporcionado por PaisRepository para recuperar todos los
	 *    registros de la tabla de países.*/

	@Override
	public Pais buscarPorId(Integer id) {
		Optional<Pais> optional;
		optional = paisRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	
/* El método buscarPorId toma un id como parámetro y busca un país en la base de datos con ese ID.
 *  Utiliza el método findById(id) proporcionado por PaisRepository, que devuelve un objeto Optional<Pais>.
 *   Si se encuentra un país con el ID especificado, 
 * se extrae el objeto Pais del Optional y se devuelve.
 *  Si no se encuentra ningún país con ese ID, se devuelve null.*/
	}

	@Override
	public Pais guardar(Pais pais) {
		return paisRepository.save(pais);
		
	}
	/*El método guardar toma un objeto Pais como parámetro y lo guarda en la base de datos. 
	 * Utiliza el método save(pais) proporcionado por PaisRepository, 
	 * que guarda el objeto en la base de datos y devuelve el objeto guardado (con un posible ID generado).  */

	@Override
	public Pais eliminar(Integer id) {
		paisRepository.deleteById(id);
		return null;
	}
	/* El método eliminar toma un id como parámetro y elimina el país correspondiente de la base de datos.
	 *  Utiliza el método deleteById(id) proporcionado por PaisRepository para eliminar el registro de la base de datos.
	 *   Este método no devuelve el país eliminado, y en su lugar, siempre devuelve null.
	*/

	@Override
	public boolean existe(Integer id) {
	if(id == null) {
		return false;
	}else {
		return paisRepository.existsById(id);
	}
	}
	@Override
	public List<Pais> buscarPorIdiomaOficial(String idiomaOficial) {
	    return paisRepository.findByIdiomaOficial(idiomaOficial);
	}
} /*  El método existe toma un id como parámetro y verifica si un país con ese ID existe en la base de datos. 
      Utiliza el método existsById(id) proporcionado por PaisRepository para comprobar la existencia y 
      devuelve true si existe o false si no existe */

  
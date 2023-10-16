package imb.pr3.lh.service.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.Catalogo;
import imb.pr3.lh.repository.CatalogoRepository;
import imb.pr3.lh.service.ICatalogoService;

@Service
public class CatalogoService implements ICatalogoService {
	
	@Autowired
	private CatalogoRepository repo;

	@Override
	public List<Catalogo> mostrarTodos() {
		return repo.findAll();
	}

	@Override
	public List<Catalogo> mostrarPorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Catalogo> crear() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Catalogo> modificar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Catalogo> eliminar() {
		// TODO Auto-generated method stub
		return null;
	}

}
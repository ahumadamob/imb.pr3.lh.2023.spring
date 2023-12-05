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
	public List<Catalogo> buscarTodos() {
		return repo.findAll();
	}

	@Override
	 public Catalogo buscarPorId(Integer id) {		
		return repo.findById(id).orElse(null);
		
	}

	@Override
	 public Catalogo guardar (Catalogo catalogo) {
		return repo.save(catalogo);

	}

	@Override
	 public void eliminar(Integer id) {
		repo.deleteById(id);
	
	}

	@Override
	public boolean existe(Integer id) {
		// TODO Auto-generated method stub
		//return (Boolean) null;
		
		if(id==null) {
			return false;
		}else {
			return repo.existsById(id);
		}
		
		//return (id==null)? false : repo.existsById(id);
		
		
	}

}
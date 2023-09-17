package imb.pr3.lh.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.Pais;
import imb.pr3.lh.repository.PaisRepository;
import imb.pr3.lh.service.IPaisService;

@Service
public class PaisServiceImpl implements IPaisService {
	
	@Autowired
	private PaisRepository repo;

	@Override
	public List<Pais> buscarTodos() {
		return repo.findAll();
	}

	@Override
	public Pais buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardar(Pais pais) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}

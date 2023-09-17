package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Pais;

public interface IPaisService {
	List<Pais> buscarTodos();
	Pais buscarPorId(Integer id);
	void guardar(Pais pais);
	void eliminar(Integer id);

}

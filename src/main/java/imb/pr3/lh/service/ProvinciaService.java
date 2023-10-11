package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Provincia;

public interface ProvinciaService {
	List<Provincia> mostrarTodos();
	Provincia mostrarPorId(Integer id);
	Provincia crearProvincia(Provincia provincia);
	Provincia modificarProvincia(Integer id, Provincia provincia);
	void eliminarProvincia(Integer id);
}

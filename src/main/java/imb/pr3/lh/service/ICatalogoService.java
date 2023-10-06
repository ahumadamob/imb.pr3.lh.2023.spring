package imb.pr3.lh.service;

import java.util.List;
import imb.pr3.lh.entity.Catalogo;

public interface ICatalogoService {
	List<Catalogo> mostrarTodos();
	List<Catalogo> mostrarPorld();
	List<Catalogo> crear();
	List<Catalogo> modificar();
	List<Catalogo> eliminar();
}
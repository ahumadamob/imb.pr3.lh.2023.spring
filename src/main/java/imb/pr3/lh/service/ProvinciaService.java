package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Provincia;

public interface ProvinciaService {
	public List<Provincia> buscarTodos();
	public Provincia buscarPorId(Integer id);
	public Provincia guardar(Provincia provincia);
	public boolean existe(Integer id);
	public Provincia eliminar(Integer id);
}

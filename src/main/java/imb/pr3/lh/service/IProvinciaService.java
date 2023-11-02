package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Provincia;

public interface IProvinciaService {
	public List<Provincia> buscarTodos();
	public Provincia buscarPorId(Integer id);
	public Provincia guardar(Provincia provincia);
	public boolean existe(Integer id);
	public void eliminar(Integer id);
}

package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Pais;

public interface IPaisService {
	
	
	public List<Pais> buscarTodos();
	
	
	public Pais buscarPorId(Integer id);
	
	
	public Pais guardar(Pais pais);
	
	
	public Pais eliminar(Integer id);
	
	
	public boolean existe(Integer id);


	public List<Pais> buscarPorIdiomaOficial(String idiomaOficial);
}
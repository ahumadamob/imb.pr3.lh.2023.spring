package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Pais;

public interface IPaisService {
	
	/*  Obtiene y devuelve una lista de todos los países.*/
	public List<Pais> buscarTodos();
	
	/*  Busca y devuelve un país por su ID.*/
	public Pais buscarPorId(Integer id);
	
	/*  Guarda un país en la base de datos o actualiza uno existente.*/
	public Pais guardar(Pais pais);
	
	/*  Elimina un país de la base de datos por su ID.*/
	public Pais eliminar(Integer id);
	
	/* Verifica si un país con el ID especificado existe en la base de datos.*/
	public boolean existe(Integer id);
}
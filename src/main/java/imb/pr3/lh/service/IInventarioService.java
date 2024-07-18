package imb.pr3.lh.service;

import java.util.List;


import imb.pr3.lh.entity.Inventario;

public interface IInventarioService {
	public List<Inventario> buscarTodos();
	public Inventario buscarPorId(Integer id);
	public List<Inventario> buscarPorDisponible(boolean disp);
    public Inventario guardar(Inventario alquiler);
    public void eliminar(Integer id);
    public boolean existe (Integer id);
}
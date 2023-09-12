package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Inventario;

public interface IInventarioService {
	public List<Inventario> getAll();
	public Inventario getXId(Integer id);
	public void crearIInventario(Inventario inv);
	public void modIInventario(Inventario inv);
	public void eliminarIInventario(Integer id);
}

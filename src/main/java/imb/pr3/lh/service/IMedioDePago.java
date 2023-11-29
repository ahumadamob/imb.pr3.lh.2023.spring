package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.MedioDePago;

public interface IMedioDePago {

	public List<MedioDePago> buscar();

	public MedioDePago buscarPorId(Integer id);

	public MedioDePago guardar(MedioDePago medioDePago);

	public void eliminar(Integer id);
	
	public boolean existe(Integer id);
	
	public List<MedioDePago> buscarPorActivo(boolean activo);

}

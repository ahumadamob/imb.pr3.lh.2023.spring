package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.MedioDePago;

public interface IMedioDePago {

	public List<MedioDePago> mostrarMedioDePago();

	public MedioDePago mostrarMedioDePagoPorId(Integer id);

	public void crearMedioDePago(MedioDePago medioDePago);

	public void modificarMedioDePago(MedioDePago medioDePago);

	public void eliminarMedioDePago(Integer id);

}

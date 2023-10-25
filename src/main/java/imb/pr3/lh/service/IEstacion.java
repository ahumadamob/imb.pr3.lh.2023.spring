package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Estacion;

public interface IEstacion {
	
	public List<Estacion> mostrarEstacion();
	public Estacion mostrarEstacionPorId(Integer Id);
	
	public void crearEstacion(Estacion estacion);
	public void modificarEstacion(Estacion estacion);
	public void eliminarEstacion(Integer id);
}

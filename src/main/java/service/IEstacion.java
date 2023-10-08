package service;

import java.util.List;

import entity.Estacion;

public interface IEstacion {
	
	public List<Estacion> mostrarEstacion();
	public Estacion mostrarEstacionPorId(Integer Id);
	
	public void crearEstacion(Estacion estacion);
	public void modificarEstacion(Estacion estacion);
	public void eliminarEstacion(Integer id);
}

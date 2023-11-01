package imb.pr3.lh.service;

import java.util.List;

import imb.pr3.lh.entity.Estacion;

public interface IEstacion {
	
/*<<<<<<< HEAD
	/*public List<Estacion> mostrarEstacion();
	
	public Estacion mostrarEstacionPorId(Integer Id);
	
	public void crearEstacion(Estacion estacion);
	
	public void modificarEstacion(Estacion estacion);
	
	public void eliminarEstacion(Integer id);*/
	//Se comenta el codigo nterior y se cambia a esto para generalizar el codigo
	
	public List<Estacion> buscarTodos();
	public Estacion buscarPorId(Integer id);
    public Estacion guardar (Estacion estacion);
    public Estacion eliminar(Integer id);
    public boolean existe(Integer id);
}

//=======
	/*public List<Estacion> mostrarEstacion();
	public Estacion mostrarEstacionPorId(Integer Id);	
	public void crearEstacion(Estacion estacion);
	public void modificarEstacion(Estacion estacion);
	public void eliminarEstacion(Integer id);
}
//>>>>>>> master*/

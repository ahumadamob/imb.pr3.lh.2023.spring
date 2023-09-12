package imb.pr3.lh.service;

import java.util.List;


import imb.pr3.lh.entity.Alquiler;

public interface IAlquilerService {
	public List<Alquiler> mostrarAlquileres();
	public Alquiler mostrarAlquilerPorId(Integer id);
    public void crearAlquiler(Alquiler alquiler);
    public void modificarAlquiler(Alquiler alquiler);
    public void eliminarAlquiler(Integer id);
}

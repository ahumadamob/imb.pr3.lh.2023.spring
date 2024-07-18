package imb.pr3.lh.service;

import java.util.List;


import imb.pr3.lh.entity.Alquiler;

public interface IAlquilerService {
	public List<Alquiler> buscarTodos();
	public Alquiler buscarPorId(Integer id);
    public Alquiler guardar(Alquiler alquiler);
    public void eliminar(Integer id);
    public boolean existe (Integer id);
}

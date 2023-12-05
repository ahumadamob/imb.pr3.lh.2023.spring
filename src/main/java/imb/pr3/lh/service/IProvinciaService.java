package imb.pr3.lh.service;
import java.util.List;

import imb.pr3.lh.entity.Provincia;

public interface IProvinciaService {
	public List<Provincia> buscarProvincia();
	public Provincia buscarProvinciaPorId(Integer id);
	public boolean existeProvincia(Integer id);
	public Provincia guardarProvincia(Provincia provincia);
	public void eliminarProvincia(Integer id);
}
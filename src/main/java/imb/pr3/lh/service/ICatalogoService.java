package imb.pr3.lh.service;

import java.util.List;
import imb.pr3.lh.entity.Catalogo;

public interface ICatalogoService {

    public List<Catalogo> buscarTodos();
    public Catalogo buscarPorId(Integer id);
    public Catalogo guardar (Catalogo catalogo);
    public void eliminar(Integer id);
    public boolean existe(Integer id);
}
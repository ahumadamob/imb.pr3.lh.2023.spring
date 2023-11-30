package imb.pr3.lh.service;
import java.util.List;

import imb.pr3.lh.entity.Pago;

public interface PagoService {
    List<Pago> buscarTodos();
    public Pago buscarPorId(Integer id);
    public Pago guardar(Pago pago);
    public void eliminar(Integer id);
    public boolean existe(Integer id);
    List<Pago> confirmado(boolean confirmado);

}

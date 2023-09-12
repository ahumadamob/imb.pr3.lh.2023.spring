package imb.pr3.lh.service;
import java.util.List;

import imb.pr3.lh.entity.Pago;

public interface PagoService {
    List<Pago> mostrarTodos();
    Pago mostrarPorId(Integer id);
    Pago crearPago(Pago pago);
    Pago modificarPago(Integer id, Pago pago);
    void eliminarPago(Integer id);
}

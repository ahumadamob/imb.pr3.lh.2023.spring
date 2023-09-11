package imb.pr3.lh.service;
import org.springframework.stereotype.Service;

import imb.pr3.lh.entity.Pago;
import imb.pr3.lh.repository.PagoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public List<Pago> mostrarTodos() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago mostrarPorId(Integer id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @Override
    public Pago crearPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago modificarPago(Integer id, Pago pago) {
        if (pagoRepository.existsById(id)) {
            pago.setId(id);
            return pagoRepository.save(pago);
        } else {
            return null; // Manejo de error si el pago no existe
        }
    }

	@Override
	public void eliminarPago(Integer id) {
		
	}}

    
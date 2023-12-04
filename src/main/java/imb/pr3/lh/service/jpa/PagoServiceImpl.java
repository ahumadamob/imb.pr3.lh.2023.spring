package imb.pr3.lh.service.jpa;

import org.springframework.stereotype.Service;
import imb.pr3.lh.entity.Pago;
import imb.pr3.lh.repository.PagoRepository;
import imb.pr3.lh.service.PagoService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Override
    public List<Pago> buscarTodos() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago buscarPorId(Integer id) {
        return pagoRepository.findById(id).orElse(null);
    }

    @Override
    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public void eliminar(Integer id) {
        pagoRepository.deleteById(id);
    }

    @Override
    public boolean existe(Integer id) {
        if (id == null) {
            return false;
        } else {
            return pagoRepository.existsById(id);
        }
    }

    @Override
    public List<Pago> confirmado(boolean confirmado) {
        return pagoRepository.findAllByConfirmado(confirmado);
    }


}


    
package imb.pr3.lh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import imb.pr3.lh.entity.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findAllByConfirmado(boolean confirmado);
}

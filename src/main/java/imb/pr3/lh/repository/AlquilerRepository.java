package imb.pr3.lh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.pr3.lh.entity.Alquiler;

import java.util.List;

public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {
	// Método personalizado para buscar alquileres por ID de cliente
    List<Alquiler> findAllByClienteId(Integer clienteId);
}

package imb.pr3.lh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.pr3.lh.entity.Inventario;


public interface InventarioRepository extends JpaRepository<Inventario, Integer>  {
	public List<Inventario>findByDisponibilidad(boolean disponibilidad);
}

package imb.pr3.lh.repository;
import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;

import imb.pr3.lh.entity.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer> {
	  List<Pais> findByIdiomaOficial(String idiomaOficial);
}

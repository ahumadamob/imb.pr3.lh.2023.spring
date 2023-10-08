package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Estacion;

public interface EstacionRepository extends JpaRepository<Estacion, Integer>{
	
}

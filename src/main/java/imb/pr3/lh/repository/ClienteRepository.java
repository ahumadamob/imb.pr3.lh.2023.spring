package imb.pr3.lh.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import imb.pr3.lh.entity.Cliente;

public interface ClienteRepository extends  JpaRepository<Cliente, Integer>{
	List<Cliente> findByPreferencial(boolean preferencial);
}
	

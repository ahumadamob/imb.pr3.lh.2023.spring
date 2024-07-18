package imb.pr3.lh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import imb.pr3.lh.entity.MedioDePago;

/* este código define una interfaz llamada MedioDePagoRepository que hereda los métodos necesarios 
 *  para realizar operaciones de persistencia en la entidad MedioDePago.
 *  JPA se encargará de generar la implementación concreta de estos métodos basándose 
 *  en el tipo de entidad y clave primaria especificados en la declaración.
 *   Esto permite a los desarrolladores interactuar con la entidad MedioDePago de manera
 *  más sencilla a través de este repositorio sin tener que escribir manualmente 
 *  consultas SQL o código de acceso a la base de datos.
 */

public interface MedioDePagoRepository extends JpaRepository<MedioDePago, Integer> {

}
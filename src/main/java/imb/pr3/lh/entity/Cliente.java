package imb.pr3.lh.entity;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String Apellido;
	private String Nombre;
	private Date FechaNacimiento;
	private String Domicilio;
	private String Email;
	private String Telefono;
	private Integer ProvinciaId;
	
	 public Integer getId() {
		  return id;
	  }
	  public void setId(Integer id) {
		  this.id = id;
	  }
	  public String getApellido() {
		  return Apellido;
	  }
	  public void setApelliodo(String apellido) {
		  this.Apellido = apellido;
	  }
	  public String getNombre() {
		  return Nombre;
	  }
	  public void setNombre(String nombre) {
		  this.Nombre = nombre;
	  }
	  public Date getFechaNacimiento() {
		  return FechaNacimiento;
	  }
	  public void setFechaNacimiento(Date fechanacimiento) {
		  this.FechaNacimiento = fechanacimiento;
	  }
	  public String getDomicilio() {
		  return Domicilio;
	  }
	  public void setDomicilio (String domicilio) {
		  this.Domicilio = domicilio;
	  }
	  public String getEmail() {
		  return Email;
	  }
	  public void setEmail(String email) {
		  this.Email = email;
	  }
	  public String getTelefono() {
		  return Telefono;
	  }
	  public void setTelefono(String telefono) {
		  this.Telefono = telefono;
	  } 
	  public Integer getProvinciaId() {
		  return ProvinciaId;
	  }
	  public void ProvinciaId(Integer provinciaid) {
		  this.ProvinciaId = provinciaid;
	  }  
	  

}

package imb.pr3.lh.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Provincia {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	 private String nombre;
	 @ManyToOne
	 private Pais PaisId;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public Pais getPaisId() {
		return PaisId;
	}
	public void setPaisId(Pais paisId) {
		PaisId = paisId;
	}
	
}

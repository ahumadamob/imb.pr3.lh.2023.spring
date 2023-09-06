package imb.pr3.lh.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Inventario {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String numeroSerie;
	private boolean disponibilidad;
	private String observaciones;
	private Integer catalogoId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public boolean isDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Integer getCatalogoId() {
		return catalogoId;
	}
	public void setCatalogoId(Integer catalogoId) {
		this.catalogoId = catalogoId;
	}

}
/*
Se requiere la creación de los siguientes elementos que representen a la entidad Inventario

Entity
Repository
Service
Service (JPA)
Controller (con los métodos mostrarTodos, mostrarPorId, crear, modificar y eliminar)
Los atributos sugeridos para la entidad son:

id (Integer)
numeroSerie (String)
disponible (boolean)
observaciones (String)
catalogoId (Integer)
 */
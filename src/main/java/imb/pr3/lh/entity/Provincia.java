package imb.pr3.lh.entity;

//Creo esta entidad de Provincia ya que tengo que hacer una relacion @ManyToOne con la clase Estacion.
public class Provincia {
	private Integer id;
	private String nombre;
	
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
	
	
}

package imb.pr3.lh.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	
	@ManyToOne
    private Pais pais_id_id;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id=id;
	}
	
    public String getNombre() {
    	return nombre;
    }
    
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Pais getPaisId() {
		return pais_id_id;
	}
	
	
	public void setPaisId(Pais paisId) {
		pais_id_id = paisId;
	}


}

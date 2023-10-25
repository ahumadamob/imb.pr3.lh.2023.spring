package imb.pr3.lh.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

/* descripcion informal de las Notation
 * Notation Entity: se entiende que transforma, mejor dicho indica que la clase "Inventario" sea tratada como una entidad,es decir 
 * como un individuo que guarda atributos que tienen sentido para la entidad y para que puedan ser procesados por las otras clases
 * 
 * Notation GeneratedValue: indica que llenara un atributo/campo de manera automatica con el valor que desees.
 * GenerationType es un enum con los tipos de datos que se pueden generar con GeneratedValue 
 * 
 * Notation Id: indica que el atributo es unico e inrrepetible
 * 
 * Notation ManyToOne: indica que el atributo es prestado de otra entidad, esto para poder vincular la relacion entre entidades
 * 
 * Notation JoinColumn: indica el nombre de la columna de union entre entidades donde guardara los datos de la otra columna
 * en un atributo del mismo tipo
 * 
 *  Notation Notblank: indica que si el atributo en cuestion resulta no ser cargado y por lo tanto se queda vacio
 *   se emitira un mensaje que podes editar 
 * */
@Entity
public class Inventario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;//este es el atributo primarykey que no se puede repetir y es basico en cuanquier entity
	
	@NotBlank(message="te falto ingresar el numero de serie")
	private String numeroSerie;//este atributo almacena el numero de serie del inventario
	
	private boolean disponibilidad;//este sirve a modo de indicar si hay inventario con ese numero de serie o si no hay; un dato boolenao
	private String observaciones;//este atriibuto guarda las observaciones(opcional) del inventario 
	
	@ManyToOne
	@JoinColumn(name= "catalogo_id")
	private Catalogo catalogo; //este atributo se le pide prestado a la entidad catalogo para mostrar el id del catalogo 
	
	/*todos los atributos  obedecen la sintaxis [scope+type+name+value] y por lo general el scope siempre es privado 
	 * y los metodos publicos para que solo se edite lo predeterminado en los metodos
	*/
	public Integer getId() {
		return id;
	}//este metodo sirve para obtener el contenido del atributo 'id'
	
	public void setId(Integer id) {
		this.id = id;
	}/*este metodo sirve para cargar el contenido del atributo 'id' para lo que java necesecita utilizar 'this' para hacer
	  *referencia de que el id se esta guardando en si mismo 
	 */
	
	public String getNumeroSerie() {
		return numeroSerie;
	}//este metodo sirve para obtener el contenido del atributo 'numeroSerie'
	
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}//este metodo sirve para cargar el contenido del atributo 'numeroSerie'
	
	public boolean isDisponibilidad() {
		return disponibilidad;
	}//este metodo sirve para obtener el contenido del atributo 'disponibilidad',el nombre cambia a conveninencia del dato de retorno
	
	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}//este metodo sirve para cargar el contenido del atributo 'disponibilidad'
	
	public String getObservaciones() {
		return observaciones;
	}//este metodo sirve para obtener el contenido del atributo 'observaciones'
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}//este metodo sirve para cargar el contenido del atributo 'observaciones'
	
	public Catalogo getCatalogo() {
		return catalogo;
	}//este metodo sirve para obtener el contenido del atributo 'catalogo'
	
	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}//este metodo sirve para cargar el contenido del atributo 'catalogo'

	
	/*la sintaxis de un metodo es [scope+retorno+nombre+args+cuerpo]
	 * 
	 * el scope es el permiso para ver quien puede acceder a tu metodo 
	 * publico:todas las clases de todos los paquetes
	 * privado:solo la misma clase que lo contiene
	 * protected:solo el paquete que lo contiene
	 * static:este va despues del primer scope y indica que las implementaciones que se hagan con el no requieren de instanciamiento
	 * 
	 * el retorno es el type de dato que procesa el metodo y que te devulve despues del proceso 
	 * *type:cuando le pones un type tenes que poner la palabra 'return' y dentro un resultado que sea del mismo type
	 * void:no hay type por lo tanto no es necesario el return es un metodo que retorna un vacio
	 * 
	 * el/los argumentos son las variables que necesita el metodo para poder operar y se colocan [type+name] de la variables
	 * 
	 * el cuerpo se encierra en'{}'y contiene el algoritmo de resolucion 
	 * */
}

package gc._4.pr2.grupo2.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Propietario")
//Ejemplo de encapsulamiento: los atributos de esta clase son privados
//y se acceden a través de métodos públicos (getters y setters).
public class Propietario {
	// Los atributos están encapsulados
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre", nullable = false, unique = true)
	private String nombre;
	@Column(name = "apellido", nullable = false, unique = true)
	private String apellido;
	@Column(name = "dni", nullable = false, unique = true)
	private String dni;
	@Column(name = "telefono", nullable = false, unique = true)
	private String telefono;
	@Column(name = "correo", nullable = false, unique = true)
	private String correo;
	@Column(name = "direccion", nullable = false, unique = true)
	private String direccion;
	// Los métodos get y set permiten acceder y modificar estos atributos de forma controlada
	 public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public String getDni() {
	        return dni;
	    }

	    public void setDni(String dni) {
	        this.dni = dni;
	    }

	    public String getTelefono() {
	        return telefono;
	    }

	    public void setTelefono(String telefono) {
	        this.telefono = telefono;
	    }

	    public String getCorreo() {
	        return correo;
	    }

	    public void setCorreo(String correo) {
	        this.correo = correo;
	    }

	    public String getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(String turno) {
	        this.direccion = turno;
	    }
  
}


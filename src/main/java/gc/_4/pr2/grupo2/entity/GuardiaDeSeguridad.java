package gc._4.pr2.grupo2.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GuardiaDeSeguridad")
public class GuardiaDeSeguridad {
	//creacion de la tabla
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre", nullable = false, unique = false)
	private String nombre;
	@Column(name = "apellido", nullable = false, unique = false)
	private String apellido;
	@Column(name = "dni", nullable = false, unique = true)
	private String dni;
	@Column(name = "telefono", nullable = false, unique = false)
	private String telefono;
	@Column(name = "correo", nullable = false, unique = false)
	private String correo;
	@Column(name = "turno", nullable = false, unique = false)
	private String turno;
	// Getters y Setters
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

	    public String getTurno() {
	        return turno;
	    }

	    public void setTurno(String turno) {
	        this.turno = turno;
	    }
  
}


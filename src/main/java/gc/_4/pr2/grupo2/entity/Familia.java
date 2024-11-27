package gc._4.pr2.grupo2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="familia")

public class Familia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String apellido;
	private String dni;
    private String relacion; //  "Padre", "Madre", "Hijo", "Hija"
    private String propiedad;
    private boolean viveEnPropiedad;
    
    // Los métodos getId() y setId() encapsulan el atributo id, permitiendo controlar el acceso y realizar validaciones si es necesario.
    
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
	public String getRelacion() {
		return relacion;
	}
	public void setRelacion(String relacion) {
		this.relacion = relacion;
	}
	public String getPropiedad() {
		return propiedad;
	}
	public void setPropiedad(String propiedad) {
		this.propiedad = propiedad;
	}
	
	// Getter y Setter de viveEnPropiedad
	public boolean getViveEnPropiedad() {
		return viveEnPropiedad;
	}
	public void setViveEnPropiedad(boolean viveEnPropiedad) {
		this.viveEnPropiedad = viveEnPropiedad;
	}
    
    
}
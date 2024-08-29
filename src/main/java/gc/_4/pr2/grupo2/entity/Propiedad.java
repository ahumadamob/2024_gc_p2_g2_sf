package gc._4.pr2.grupo2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Propiedad")
public class Propiedad {
	//creacion de la tabla
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "direccion", nullable = false, unique = true)
	private String direccion;
	@Column(name = "tipo", nullable = false, unique = true)
	private String tipo;
	@Column(name = "propietario", nullable = false, unique = true)
	private String propietario;
	@Column(name = "mascotas", nullable = false, unique = true)
	private List<String> mascotas;
	@Column(name = "grupoFamiliar", nullable = false, unique = true)
	private List<String> grupoFamiliar;
	// Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public List<String> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<String> mascotas) {
        this.mascotas = mascotas;
    }

    public List<String> getGrupoFamiliar() {
        return grupoFamiliar;
    }

    public void setGrupoFamiliar(List<String> grupoFamiliar) {
        this.grupoFamiliar = grupoFamiliar;
    }
}

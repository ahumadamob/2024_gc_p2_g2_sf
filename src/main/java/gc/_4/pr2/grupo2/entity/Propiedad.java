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
}

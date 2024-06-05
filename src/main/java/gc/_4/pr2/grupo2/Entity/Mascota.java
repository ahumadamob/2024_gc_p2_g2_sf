package gc._4.pr2.grupo2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascota {

  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    

	@Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

	@Column(name = "especie", nullable = false, length = 50)
    private String especie;

	@Column(name = "raza", length = 50)
    private String raza;

	@Column(name = "edad")
    private int edad;

	@Column(name = "propiedad", length = 100)
    private String propiedad;

    
}
package com.platzi.ereservation.modelo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Clase que representa la tabla Cliente
 * @author cristhiandgz
 *
 */

@Data
@Entity
@Table(name= "cliente")
@NamedQuery(name="Cliente.findByIdentificacion", query = "Select c from Cliente c where c.identificacionCli=?1")
public class Cliente {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;
	@OneToMany(mappedBy = "cliente")
	private Set<Reserva> reservas;
	
	public Cliente() {
		
	}

}

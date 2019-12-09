package com.platzi.ereservation.vista.resources.vo;

import lombok.Data;

/**
 * Clase que representa la tabla Cliente
 * @author cristhiandgz
 *
 */

@Data
public class ClienteVO {

	private String idCli;
	private String nombreCli;
	private String apellidoCli;
	private String identificacionCli;
	private String direccionCli;
	private String telefonoCli;
	private String emailCli;


}

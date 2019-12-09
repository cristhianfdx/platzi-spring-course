/**
 * 
 */
package com.platzi.ereservation.negocio.repository;

import com.platzi.ereservation.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaz para definir operaciones relaciondas con el cliente
 * @author cristhiandgz
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    /**
     * Definición de método para buscar los clientes por su apellido
     * @param apellidoCli
     * @return
     * */
    public List<Cliente> findByApellidoCli(String apellidoCli);

    public Cliente findByIdentificacion(String identificacionCli);


}

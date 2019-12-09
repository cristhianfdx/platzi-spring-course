package com.platzi.ereservation.negocio.services;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Clase para definir los servicios de cliente
 * @author caforero
 * */

@Service
@Transactional(readOnly = true)
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    /**
     * Metodo para guardar un cliente
     * @param cliente
     * @return
     * */
    @Transactional
    public Cliente create(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    /**
     * Metodo para actualizar un cliente
     * @param cliente
     * @return
     * */
    @Transactional
    public Cliente update(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    /**
     * Metodo para eliminar un cliente
     * @param cliente
     * */
    @Transactional
    public void delete(Cliente cliente){
        this.clienteRepository.delete(cliente);
    }

    /**
     * Metodo para consultar un cliente por su identificacion
     * @param identificacionCli
     * @return
     * */
    public Cliente findByIdentificacion(String identificacionCli){
        return this.clienteRepository.findByIdentificacion(identificacionCli);
    }

    public List<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }
}

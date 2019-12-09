package com.platzi.ereservation.vista.resources;

import com.platzi.ereservation.modelo.Cliente;
import com.platzi.ereservation.negocio.services.ClienteService;
import com.platzi.ereservation.vista.resources.vo.ClienteVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que representa el servicio web de cleinte
 * */

@RestController
@RequestMapping("/api/cliente")
@Api(tags = "cliente")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @ApiOperation(value = "Crear cliente", notes = "Servicio para crear un nuevo cliente")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "cliente creado correctamente") , @ApiResponse(code = 404, message = "Solicitud inválida")})
    public ResponseEntity <Cliente> createCliente(@RequestBody ClienteVO clienteVO){
        Cliente cliente = new Cliente();
        cliente.setNombreCli(clienteVO.getNombreCli());
        cliente.setApellidoCli(clienteVO.getApellidoCli());
        cliente.setDireccionCli(clienteVO.getDireccionCli());
        cliente.setEmailCli(clienteVO.getEmailCli());
        cliente.setTelefonoCli(clienteVO.getTelefonoCli());

        return new ResponseEntity<>(this.clienteService.create(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{identificacion}")
    @ApiOperation(value = "Actualizar cliente", notes = "Servicio para actualizar un cliente")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "cliente actualizado correctamente") , @ApiResponse(code = 404, message = "Solicitud inválida")})
    public ResponseEntity <Cliente> updateCliente(@PathVariable("identificacion") String identificacion, ClienteVO clienteVO){
        Cliente cliente = this.clienteService.findByIdentificacion(identificacion);

        if(cliente == null){
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }else{
            cliente.setNombreCli(clienteVO.getNombreCli());
            cliente.setApellidoCli(clienteVO.getApellidoCli());
            cliente.setDireccionCli(clienteVO.getDireccionCli());
            cliente.setEmailCli(clienteVO.getEmailCli());
            cliente.setTelefonoCli(clienteVO.getTelefonoCli());
        }

        return new ResponseEntity<>(this.clienteService.update(cliente), HttpStatus.OK);
    }

    @DeleteMapping("/{identificacion}")
    @ApiOperation(value = "Eliminar cliente", notes = "Servicio para eliminar cliente")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "cliente eliminado correctamente") , @ApiResponse(code = 404, message = "Solicitud inválida")})
    public void removeCliente(@PathVariable("identificacion") String identificacion){
        Cliente cliente = this.clienteService.findByIdentificacion(identificacion);

        if(cliente != null) this.clienteService.delete(cliente);
    }

    @GetMapping
    @ApiOperation(value = "Listar cliente", notes = "Servicio para listar todos los clientes")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "clientes encontrados") , @ApiResponse(code = 404, message = "Solicitud inválida")})
    public ResponseEntity<List<Cliente>> findAll(){
        return ResponseEntity.ok(this.clienteService.findAll());
    }
}

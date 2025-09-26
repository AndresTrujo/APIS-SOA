package carlos.trujo.rentas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carlos.trujo.rentas.models.Clientes;
import carlos.trujo.rentas.repositories.IClientesRepository;

@Service
public class ClienteService {
    @Autowired
    IClientesRepository clienteRepository;

    public ArrayList<Clientes> getClientes(){
        return (ArrayList<Clientes>) clienteRepository.findAll();
    }

    public Clientes saveCliente(Clientes cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Clientes> getById(Long id){
        return clienteRepository.findById(id);
    }

    public Clientes updateById(Clientes request, Long id){
        Clientes cliente = clienteRepository.findById(id).get();

        cliente.setNombre(request.getNombre());
        cliente.setRFC(request.getRFC());
        cliente.setDireccion(request.getDireccion());
        cliente.setTelefono(request.getTelefono());
        cliente.setEmail(request.getEmail());
        cliente.setTipoCliente(request.getTipoCliente());
        clienteRepository.save(cliente);

        return cliente;
    }
    
}

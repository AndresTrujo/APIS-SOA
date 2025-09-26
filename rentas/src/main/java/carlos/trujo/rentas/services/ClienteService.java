package carlos.trujo.rentas.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carlos.trujo.rentas.models.Cliente;
import carlos.trujo.rentas.repositories.IClientesRepository;

@Service
public class ClienteService {
    @Autowired
    IClientesRepository clienteRepository;

    public ArrayList<Cliente> getClientes(){
        return (ArrayList<Cliente>) clienteRepository.findAll();
    }

    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getById(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente updateById(Cliente request, Long id){
        Cliente cliente = clienteRepository.findById(id).get();

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

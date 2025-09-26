package carlos.trujo.rentas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import carlos.trujo.rentas.models.Clientes;

@Repository
public interface IClientesRepository extends JpaRepository<Clientes, Long>{
    
}

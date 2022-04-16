package tads.eaj.ufrn.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tads.eaj.ufrn.backend.model.Carga;
import tads.eaj.ufrn.backend.model.Transportadora;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora, Long> {
    List<Transportadora> findAllByDeletedIsNull();
    Optional<Transportadora> findByIdAndDeletedIsNull(Long id);
    Transportadora getTransportadoraByIdAndDeletedIsNull(Long id);
}

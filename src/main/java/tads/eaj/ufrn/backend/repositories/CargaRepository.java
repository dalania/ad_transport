package tads.eaj.ufrn.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tads.eaj.ufrn.backend.model.Carga;

import java.util.Optional;
import java.util.List;
@Repository
public interface CargaRepository extends JpaRepository<tads.eaj.ufrn.backend.model.Carga, Long> {
    Optional<tads.eaj.ufrn.backend.model.Carga> findCargaByIdAndDeletedIsNull(Long id);
    List <tads.eaj.ufrn.backend.model.Carga> findAllByDeletedIsNull();
}

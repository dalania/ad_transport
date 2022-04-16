package tads.eaj.ufrn.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tads.eaj.ufrn.backend.model.Estado;

import java.util.List;
import java.util.Optional;
@Repository

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findAllByDeletedIsNull();
    Optional<Estado> findByIdAndDeletedIsNull(Long id);
    Estado getByIdAndDeletedIsNull(Long id);
}

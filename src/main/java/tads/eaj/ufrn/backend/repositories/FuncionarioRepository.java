package tads.eaj.ufrn.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tads.eaj.ufrn.backend.model.Funcionario;
import java.util.List;
import java.util.Optional;
@Repository

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findAllByDeletedIsNull();

    Optional<Funcionario> findByDeletedIsNullAndId(Long id);
}

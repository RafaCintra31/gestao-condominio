package online.codemize.gestaocondominio.repository;

import online.codemize.gestaocondominio.domain.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

    Optional<Unidade> findFirstByRegistro(String registro);

}

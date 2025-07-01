package online.codemize.gestaocondominio.repository;

import online.codemize.gestaocondominio.domain.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// SpringData
@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}

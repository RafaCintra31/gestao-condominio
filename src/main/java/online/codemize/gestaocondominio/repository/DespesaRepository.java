package online.codemize.gestaocondominio.repository;

import online.codemize.gestaocondominio.domain.Despesa;
import online.codemize.gestaocondominio.domain.enums.StatusDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// SpringData
@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query(value = "SELECT * FROM despesas d WHERE d.status = :banana", nativeQuery = true)
    List<Despesa> listar(@Param("banana") String status);

    @Query(value = "SELECT d FROM Despesa d WHERE d.status = :banana")
    List<Despesa> listarv2(@Param("banana")StatusDespesa status);

    List<Despesa> findAllByStatus(StatusDespesa status);

}

package online.codemize.gestaocondominio.repository;

import online.codemize.gestaocondominio.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}

package online.codemize.gestaocondominio.service;

import online.codemize.gestaocondominio.domain.Despesa;
import online.codemize.gestaocondominio.dto.DespesaRequest;

import java.util.List;

public interface DespesaService {

    void cadastrar (DespesaRequest request);

    List<Despesa> listar();

    Despesa buscarPorId(Long id);
}

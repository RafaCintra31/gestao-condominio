package online.codemize.gestaocondominio.service;

import online.codemize.gestaocondominio.domain.Unidade;
import online.codemize.gestaocondominio.dto.UnidadeRequest;

public interface UnidadeService {

    void criar(UnidadeRequest request);

    Unidade buscarPorId(Long id);
}

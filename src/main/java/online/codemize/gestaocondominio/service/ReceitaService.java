package online.codemize.gestaocondominio.service;

import online.codemize.gestaocondominio.domain.Receita;
import online.codemize.gestaocondominio.dto.ReceitaRequest;

import java.util.List;

public interface ReceitaService {

    void cadastrar(ReceitaRequest request);

    Receita buscarPorId(Long id);

    List<Receita> listarTodoas();

}

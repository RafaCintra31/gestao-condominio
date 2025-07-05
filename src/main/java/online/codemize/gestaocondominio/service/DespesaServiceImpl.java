package online.codemize.gestaocondominio.service;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.converter.DespesaConverter;
import online.codemize.gestaocondominio.domain.Despesa;
import online.codemize.gestaocondominio.domain.enums.StatusDespesa;
import online.codemize.gestaocondominio.dto.DespesaRequest;
import online.codemize.gestaocondominio.repository.DespesaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DespesaServiceImpl implements DespesaService {

    private final DespesaConverter converter;
    private final DespesaRepository repository;

    @Override
    public void cadastrar(DespesaRequest request) {
       var despesa = converter.convert(request);
       repository.save(despesa);
    }

    @Override
    public List<Despesa> listar() {
        return repository.findAll();
    }

    @Override
    public Despesa buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Despesa> listar(String status) {
        if(StringUtils.isBlank(status))
            return listar();

        var statusDesp = StatusDespesa.valueOf(status);

        return repository.findAllByStatus(statusDesp);
    }
}

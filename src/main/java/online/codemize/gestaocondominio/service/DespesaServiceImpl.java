package online.codemize.gestaocondominio.service;

import online.codemize.gestaocondominio.converter.DespesaConverter;
import online.codemize.gestaocondominio.dto.DespesaRequest;
import online.codemize.gestaocondominio.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DespesaServiceImpl implements DespesaService {

    @Autowired
    private DespesaConverter converter;

    @Autowired
    private DespesaRepository repository;

    @Override
    public void cadastrar(DespesaRequest request) {
       var despesa = converter.convert(request);
       repository.save(despesa);
    }
}

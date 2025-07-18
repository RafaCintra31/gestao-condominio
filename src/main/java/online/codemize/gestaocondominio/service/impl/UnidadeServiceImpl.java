package online.codemize.gestaocondominio.service.impl;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.domain.Unidade;
import online.codemize.gestaocondominio.dto.UnidadeRequest;
import online.codemize.gestaocondominio.exception.AssociacaoUsuarioUnidadeException;
import online.codemize.gestaocondominio.repository.UnidadeRepository;
import online.codemize.gestaocondominio.repository.UsuarioRepository;
import online.codemize.gestaocondominio.service.UnidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnidadeServiceImpl implements UnidadeService {

    private final UnidadeRepository unidadeRepository;

    @Override
    public void criar(UnidadeRequest request) {
        var unidade = new Unidade();
        BeanUtils.copyProperties(request, unidade);
        unidadeRepository.save(unidade);
    }

}

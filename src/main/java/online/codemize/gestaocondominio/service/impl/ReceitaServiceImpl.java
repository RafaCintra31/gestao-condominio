package online.codemize.gestaocondominio.service.impl;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.domain.Receita;
import online.codemize.gestaocondominio.domain.Unidade;
import online.codemize.gestaocondominio.dto.ReceitaRequest;
import online.codemize.gestaocondominio.exception.ReceitaNotFoundException;
import online.codemize.gestaocondominio.oauth.UsuarioAppContext;
import online.codemize.gestaocondominio.repository.ReceitaRepository;
import online.codemize.gestaocondominio.service.ReceitaService;
import online.codemize.gestaocondominio.service.UnidadeService;
import online.codemize.gestaocondominio.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

import static online.codemize.gestaocondominio.utils.DateUtils.stringToLocalDate;

@Service
@RequiredArgsConstructor
public class ReceitaServiceImpl implements ReceitaService {

    private final ReceitaRepository repository;
    private final UnidadeService unidadeService;
    private final UsuarioAppContext usuarioAppContext;

    @Override
    public void cadastrar(ReceitaRequest request) {
        Unidade unidade = null;
        if(request.idUnidade() != null){
            unidade = unidadeService.buscarPorId(request.idUnidade());
        }

        var receita = new Receita();
        receita.setDataPagamento(stringToLocalDate(request.dataPagamento()));
        receita.setDescricao(request.descricao());
        receita.setValor(request.valor());
        receita.setCategoria(request.categoria());
        receita.setDataVencimento(stringToLocalDate(request.dataVencimento()));
        receita.setUnidade(unidade);
        receita.setUsuario(usuarioAppContext.getUsuario());

        repository.save(receita);
    }

    @Override
    public Receita buscarPorId(Long id) {
        return repository
                .findById(id)
                .orElseThrow(ReceitaNotFoundException::new);
    }

    @Override
    public List<Receita> listarTodoas() {
        return repository.findAll();
    }
}

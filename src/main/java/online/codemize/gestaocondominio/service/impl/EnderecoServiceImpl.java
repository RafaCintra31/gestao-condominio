package online.codemize.gestaocondominio.service.impl;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.client.BrazilAPIClient;
import online.codemize.gestaocondominio.domain.Endereco;
import online.codemize.gestaocondominio.domain.Unidade;
import online.codemize.gestaocondominio.dto.UnidadeEnderecoRequest;
import online.codemize.gestaocondominio.oauth.UsuarioAppContext;
import online.codemize.gestaocondominio.repository.EnderecoRepository;
import online.codemize.gestaocondominio.service.EnderecoService;
import online.codemize.gestaocondominio.service.UnidadeService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;
    private final UnidadeService unidadeService;
    private final BrazilAPIClient brazilAPIClient;
    private final UsuarioAppContext usuarioAppContext;

    @Override
    public void cadastrarEnderecoUnidade(UnidadeEnderecoRequest request) {
        var endereco = brazilAPIClient.getEnderecoPorCep(request.cep());
        var unidade = unidadeService.buscarPorId(request.unidadeId());
        var enderecoDomain = new Endereco();
        enderecoDomain.setUsuario(usuarioAppContext.getUsuario());
        enderecoDomain.setUnidade(unidade);
        enderecoDomain.setLogradouro(endereco.getStreet());
        enderecoDomain.setCep(request.cep());
        enderecoDomain.setUf(endereco.getState());
        enderecoDomain.setBairro(endereco.getNeighborhood());
        enderecoDomain.setCidade(endereco.getCity());
        enderecoDomain.setNumero(request.numero());
        enderecoDomain.setComplemento(request.complemento());
        repository.save(enderecoDomain);
    }
}

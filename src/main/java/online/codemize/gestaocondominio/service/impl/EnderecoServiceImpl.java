package online.codemize.gestaocondominio.service.impl;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.client.BrazilAPIClient;
import online.codemize.gestaocondominio.domain.Unidade;
import online.codemize.gestaocondominio.service.EnderecoService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoServiceImpl implements EnderecoService {

    private final BrazilAPIClient brazilAPIClient;

    @Override
    public void cadastrarEndereco(Unidade unidade, String cep, String numero, String complemento) {
        var endereco = brazilAPIClient.getEnderecoPorCep(cep);
    }
}

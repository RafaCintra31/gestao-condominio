package online.codemize.gestaocondominio.service;

import online.codemize.gestaocondominio.dto.AutenticacaoRequest;

public interface AutenticacaoService {

    String gerarToken(AutenticacaoRequest request);

}

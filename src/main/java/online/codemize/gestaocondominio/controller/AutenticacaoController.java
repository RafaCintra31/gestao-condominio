package online.codemize.gestaocondominio.controller;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.dto.AutenticacaoRequest;
import online.codemize.gestaocondominio.service.AutenticacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/autenticacao")
public class AutenticacaoController {

    private  final AutenticacaoService service;

    @PostMapping("gerar-token")
    @ResponseStatus(HttpStatus.OK)
    public String logarSistema(@RequestBody AutenticacaoRequest request){
        return service.gerarToken(request);
    }
}

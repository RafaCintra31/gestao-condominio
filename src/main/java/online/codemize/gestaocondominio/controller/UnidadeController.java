package online.codemize.gestaocondominio.controller;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.dto.UnidadeEnderecoRequest;
import online.codemize.gestaocondominio.dto.UnidadeRequest;
import online.codemize.gestaocondominio.oauth.PreAutorizado;
import online.codemize.gestaocondominio.service.EnderecoService;
import online.codemize.gestaocondominio.service.UnidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/unidades")
public class UnidadeController {

    private final UnidadeService service;
    private final EnderecoService enderecoService;

    @PreAutorizado
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void criar(@RequestBody UnidadeRequest request){
        service.criar((request));
    }

    @PreAutorizado
    @PostMapping("endereco")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarEnderecoUnidade(@RequestBody UnidadeEnderecoRequest request){
        enderecoService.cadastrarEnderecoUnidade(request);
    }

}

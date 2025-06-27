package online.codemize.gestaocondominio.controller;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.dto.DespesaRequest;
import online.codemize.gestaocondominio.service.DespesaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/despesa")
public class DespesaContoller {

    private final DespesaService service;

    @PostMapping
    public void cadastrarDespesa(@RequestBody DespesaRequest request){
        service.cadastrar(request);
    }

}

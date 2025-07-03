package online.codemize.gestaocondominio.controller;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.domain.Despesa;
import online.codemize.gestaocondominio.dto.DespesaRequest;
import online.codemize.gestaocondominio.service.DespesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/despesa")
public class DespesaContoller {

    private final DespesaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDespesa(@RequestBody DespesaRequest request) {
        service.cadastrar(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> listarDespesas(){
        return service.listar();
    }

    @GetMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Despesa getDespesaPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

}

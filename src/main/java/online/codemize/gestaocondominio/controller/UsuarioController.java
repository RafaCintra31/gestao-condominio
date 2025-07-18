package online.codemize.gestaocondominio.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.domain.Usuario;
import online.codemize.gestaocondominio.dto.UsuarioRequest;
import online.codemize.gestaocondominio.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void criar(@RequestBody @Valid UsuarioRequest request){
        service.criar(request);
    }

    @GetMapping("{email}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario getUsuario(@PathVariable String email){
        return  service.obterUsuario(email);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarSenha(@RequestParam String senha,
                               @RequestParam String email){
       service.atualizarSenha(email, senha);
    }

    @PutMapping("associar-unidade")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void associarUnidade(@RequestParam String email,
                                @RequestParam String registro){
        service.associarUnidade(email, registro);
    }
}

package tech.ada.pokeada.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.ada.pokeada.dto.NovoUsuarioDTO;
import tech.ada.pokeada.dto.UsuarioListaDTO;
import tech.ada.pokeada.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UserService service;

    public UsuarioController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioListaDTO>> listarUsuarios() {
        return ResponseEntity.ok(service.listarUsuarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioListaDTO> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findByIdUsuario(id));
    }


    @PostMapping
    public ResponseEntity<UsuarioListaDTO> salvarNovoUsuario(@RequestBody @Valid NovoUsuarioDTO novoUsuarioDTO) {
        UsuarioListaDTO retorno = service.salvar(novoUsuarioDTO);

        // Constrói a URI do novo recurso criado
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(retorno.getId())
                .toUri();

        return ResponseEntity.created(uri).body(retorno);
    }


}

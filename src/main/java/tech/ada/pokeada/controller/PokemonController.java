package tech.ada.pokeada.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.ada.pokeada.dto.PokemonDTO;
import tech.ada.pokeada.dto.PokemonHomeDTO;
import tech.ada.pokeada.service.PokemonService;

@RestController
@Validated
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public ResponseEntity<Page<PokemonHomeDTO>> findAllPokemons(
            @RequestParam(value = "numeroPagina", required = false)
            @Min(value = 0, message = "Valor da página deve ser maior que 0") Integer  numeroPagina,
            @RequestParam(value = "numeroDeRegistros", required = false)
            @Min(value = 0, message = "Valor do numero de registros deve ser maior que 0") Integer numeroDeRegistros,
            @RequestParam(value = "campoOrdenacao", required = false, defaultValue = "name")
            String campoOrdenacao,
            @RequestParam(value = "ordemOrdenacao", required = false, defaultValue = "ASC")
            @Size(min = 3, message = "Os campos de ordenação devem ser 'ASC' ou 'DESC' independente do case") String ordem
    ) {

        return ResponseEntity.ok(pokemonService.findAll(numeroPagina, numeroDeRegistros, campoOrdenacao, ordem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(pokemonService.findById(id));
    }


}

package tech.ada.pokeada.service;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.ada.pokeada.dto.PokemonDTO;
import tech.ada.pokeada.dto.PokemonHomeDTO;
import tech.ada.pokeada.dto.parser.PokemonDTOParser;
import tech.ada.pokeada.dto.parser.PokemonHomeParser;
import tech.ada.pokeada.exceptions.PokemonNaoEncontradoException;
import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.repository.PokemonRepository;
import tech.ada.pokeada.repository.PokemonSpecification;
import tech.ada.pokeada.repository.filter.PokemonFilter;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<PokemonHomeDTO> findAll() {
        PokemonSpecification specification = new PokemonSpecification(new PokemonFilter(1, "bulba", 3));

//        pokemonRepository.findAll(specification.byPokemonFilter());

        return pokemonRepository.findAll()
                .stream()
                .map(PokemonHomeParser::toPokemonDTO)
                .collect(Collectors.toList());
    }


    public PokemonDTO findById(Long id) {
        Optional<Pokemon> pokemonOptional  = pokemonRepository.findById(id);

        return PokemonDTOParser.toPokemonDTO(pokemonOptional
                .orElseThrow(() ->
                        new PokemonNaoEncontradoException("Não encontrado pokemon de ID " + id)));
    }


    public Page<PokemonHomeDTO> findAll(Integer numeroPagina, Integer numeroDeRegistros, String campoOrdenacao, String ordem) {
        Pageable pageable = getPageable(numeroPagina, numeroDeRegistros, campoOrdenacao, ordem);
        Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);

        return pokemons.map(PokemonHomeParser::toPokemonDTO);
    }

    private Pageable getPageable(Integer numeroPagina, Integer numeroDeRegistros, String campoOrdenacao, String ordem) {
        if (Objects.nonNull(numeroPagina) && Objects.nonNull(numeroDeRegistros)) {
            return PageRequest.of(numeroPagina, numeroDeRegistros, getSort(campoOrdenacao, ordem));
        }
        return Pageable.unpaged();
    }

    private Sort getSort(String campoOrdenacao, String ordem) {
        if (Objects.nonNull(campoOrdenacao) && Objects.nonNull(ordem)) {
            return Sort.by(Sort.Direction.fromString(ordem), campoOrdenacao);
        }
        return Sort.unsorted();
    }
}

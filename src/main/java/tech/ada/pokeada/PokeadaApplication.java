package tech.ada.pokeada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.repository.PokemonRepository;
import tech.ada.pokeada.repository.PokemonSpecification;
import tech.ada.pokeada.repository.filter.PokemonFilter;

import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class PokeadaApplication implements CommandLineRunner {

	@Autowired
	private PokemonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PokeadaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		PokemonSpecification specification = new PokemonSpecification(new PokemonFilter(1, "bulba", 3));
//
//		List<Pokemon> all = repository.findAll(specification.byPokemonFilter());

	}
}

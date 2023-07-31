package tech.ada.pokeada;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.repository.PokemonRepository;

import java.util.Optional;

@SpringBootApplication
public class PokeadaApplication implements CommandLineRunner {

	private final PokemonRepository repository;

	public PokeadaApplication(PokemonRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PokeadaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		/* Teste seu método aqui
			repository.find... */
		repository.findAll();
	}
}

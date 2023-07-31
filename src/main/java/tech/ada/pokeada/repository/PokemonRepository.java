package tech.ada.pokeada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.ada.pokeada.model.Pokemon;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

 /*
 * Escreva as seguintes buscas utilizando query methods na interface PokemonRepository:

        * Listar Pokémons que a defense maior que o valor informado.
        * Listar Pokémons que o firstType entre uma lista de tipos informados.
        * Listar Pokémons que o specialAttack está entre dois valores informados.
        * Listar Pokémons que o specialAttack é maior ou igual que o valor informado.

    * Escreva também buscas utilizando query nativa na interface PokemonRepository:

    * Obter Pokémon pelo nome.
 * */

    List<Pokemon> findByName(String name);


    @Query(value = "SUA QUERY", nativeQuery = true)
    Optional<Pokemon> findBySpeedGrea(Integer speed);


}

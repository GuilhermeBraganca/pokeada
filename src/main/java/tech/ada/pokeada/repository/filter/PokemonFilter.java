package tech.ada.pokeada.repository.filter;

public class PokemonFilter {

    private Integer attack;

    private String name;

    private Integer defense;



    public PokemonFilter(Integer attack, String name, Integer defense) {
        this.attack = attack;
        this.name = name;
        this.defense = defense;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }
}

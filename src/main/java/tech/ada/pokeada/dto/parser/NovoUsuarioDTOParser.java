package tech.ada.pokeada.dto.parser;

import tech.ada.pokeada.dto.NovoUsuarioDTO;
import tech.ada.pokeada.model.User;

public class NovoUsuarioDTOParser {

    public static NovoUsuarioDTO toNovoUsuarioDTO(User entity) {
        NovoUsuarioDTO novoUsuarioDTO = new NovoUsuarioDTO();
        novoUsuarioDTO.setAge(entity.getAge());
        novoUsuarioDTO.setCpf(entity.getCpf());
        novoUsuarioDTO.setEmail(entity.getEmail());
        novoUsuarioDTO.setPassword(entity.getPassword());
        novoUsuarioDTO.setName(entity.getName());
        return novoUsuarioDTO;
    }

    public static User toUser(NovoUsuarioDTO dto) {
        User user = new User();
        user.setAge(dto.getAge());
        user.setCpf(dto.getCpf());
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        return user;
    }
}

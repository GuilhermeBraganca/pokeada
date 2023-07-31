package tech.ada.pokeada.dto.parser;

import tech.ada.pokeada.dto.UsuarioListaDTO;
import tech.ada.pokeada.model.User;

public class UsuarioListaDTOParser {

    public static UsuarioListaDTO toUserListaDTO(User user) {
        UsuarioListaDTO usuarioListaDTO = new UsuarioListaDTO();
        usuarioListaDTO.setId(user.getId());
        usuarioListaDTO.setCpf(user.getCpf());
        usuarioListaDTO.setEmail(user.getEmail());
        usuarioListaDTO.setIdade(user.getAge());
        usuarioListaDTO.setName(user.getName());
        return usuarioListaDTO;
    }
}

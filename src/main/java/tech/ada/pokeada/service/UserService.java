package tech.ada.pokeada.service;

import org.springframework.stereotype.Service;
import tech.ada.pokeada.dto.NovoUsuarioDTO;
import tech.ada.pokeada.dto.UsuarioByIdDTO;
import tech.ada.pokeada.dto.UsuarioListaDTO;
import tech.ada.pokeada.dto.parser.NovoUsuarioDTOParser;
import tech.ada.pokeada.dto.parser.UsuarioListaDTOParser;
import tech.ada.pokeada.exceptions.UsuarioNaoEncontradoException;
import tech.ada.pokeada.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UsuarioRepository usuarioRepository;

    public UserService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioListaDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioListaDTOParser::toUserListaDTO)
                .collect(Collectors.toList());
    }


    public UsuarioListaDTO findByIdUsuario(Long id) {
        return UsuarioListaDTOParser
                .toUserListaDTO(usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado")));
    }

    public UsuarioListaDTO salvar(NovoUsuarioDTO user) {
        return UsuarioListaDTOParser.toUserListaDTO(usuarioRepository.save(NovoUsuarioDTOParser.toUser(user)));
    }


}

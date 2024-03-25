package br.com.edison.servicex.usuario.service;

import br.com.edison.servicex.usuario.domain.Usuario;
import br.com.edison.servicex.usuario.repositores.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuario(Integer idUsuario){
        return usuarioRepository.findById(idUsuario); }

    public Usuario atualizarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Integer idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }
}

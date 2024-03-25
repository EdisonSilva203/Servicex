package br.com.edison.servicex.usuario.resources;


import br.com.edison.servicex.usuario.domain.Usuario;
import br.com.edison.servicex.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        List<Usuario> Usuario = usuarioService.listarUsuarios();
        return new ResponseEntity<>(Usuario, HttpStatus.OK);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer idUsuario) {
        return usuarioService.buscarUsuario(idUsuario)
                .map(Usuario -> new ResponseEntity<>(Usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Integer idUsuario){
        usuarioService.deletarUsuario(idUsuario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario usuario){
        /* Quando adicionamos uma "!" quer dizer que está pasando uma negação então em vez de ser isPresent se tornou isNotPresent */
        if (!usuarioService.buscarUsuario(idUsuario).isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usuario.setIdUsuario(idUsuario);
        Usuario novoUsuario = usuarioService.atualizarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.OK);
    }
}

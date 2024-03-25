package br.com.edison.servicex.endereco.resources;

import br.com.edison.servicex.endereco.domain.Endereco;
import br.com.edison.servicex.endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco){
        Endereco novoEndereco = enderecoService.criarEndereco(endereco);
        return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEnderecos(){
        List<Endereco> Endereco = enderecoService.listarEnderecos();
        return new ResponseEntity<>(Endereco, HttpStatus.OK);
    }

    @GetMapping("/{idEndereco}")
    public ResponseEntity<Endereco> buscarEndereco(@PathVariable Integer idEndereco) {
        return enderecoService.buscarEndereco(idEndereco)
                .map(Endereco -> new ResponseEntity<>(Endereco, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Integer idEndereco){
        enderecoService.deletarEndereco(idEndereco);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> atualizarEndereco(@PathVariable Integer idEndereco, @RequestBody Endereco endereco){
        /* Quando adicionamos uma "!" quer dizer que está pasando uma negação então em vez de ser isPresent se tornou isNotPresent */
        if (!enderecoService.buscarEndereco(idEndereco).isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        endereco.setIdEndereco(idEndereco);
        Endereco novoEndereco = enderecoService.atualizarEndereco(endereco);
        return new ResponseEntity<>(novoEndereco, HttpStatus.OK);
    }
}

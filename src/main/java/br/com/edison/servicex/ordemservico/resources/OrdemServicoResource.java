package br.com.edison.servicex.ordemservico.resources;

import br.com.edison.servicex.ordemservico.domain.OrdemServico;
import br.com.edison.servicex.ordemservico.service.OrdemServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ordemservicos")
public class OrdemServicoResource {
    @Autowired
    private OrdemServicoService ordemServicoService;

    @PostMapping
    public ResponseEntity<OrdemServico> criarOrdemServico(@RequestBody OrdemServico ordemServico){
        OrdemServico novaOrdemServico = ordemServicoService.criarOrdemServico(ordemServico);
        return new ResponseEntity<>(novaOrdemServico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<OrdemServico>> listarOrdemServicos(){
        List<OrdemServico> ordemServicos = ordemServicoService.listarOrdemServico();
        return new ResponseEntity<>(ordemServicos, HttpStatus.OK);
    }

    @GetMapping("/{idOrdemServico}")
    public ResponseEntity<OrdemServico> buscarOrdemServico(@PathVariable Integer idOrdemServico) {
        return ordemServicoService.buscarOrdemServico(idOrdemServico)
                .map(ordemServico -> new ResponseEntity<>(ordemServico, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idOrdemServico}")
    public ResponseEntity<Void> deletarOrdemServico(@PathVariable Integer idOrdemServico){
        ordemServicoService.deletarOrdemServico(idOrdemServico);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idOrdemServico}")
    public ResponseEntity<OrdemServico> atualizarORdemServico(@PathVariable Integer idOrdemServico, @RequestBody OrdemServico ordemServico){
        /* Quando adicionamos uma "!" quer dizer que está pasando uma negação então em vez de ser isPresent se tornou isNotPresent */
        if (!ordemServicoService.buscarOrdemServico(idOrdemServico).isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ordemServico.setIdOrdemServico(idOrdemServico);
        OrdemServico novaOrdemServico = ordemServicoService.atualizarOrdemServico(ordemServico);
        return new ResponseEntity<>(novaOrdemServico, HttpStatus.OK);
    }
}

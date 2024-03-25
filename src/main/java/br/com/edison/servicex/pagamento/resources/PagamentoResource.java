package br.com.edison.servicex.pagamento.resources;

import br.com.edison.servicex.pagamento.domain.Pagamento;
import br.com.edison.servicex.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamentos")
public class PagamentoResource {
    @Autowired
    private PagamentoService pagamentoService;
    @PostMapping
    public ResponseEntity<Pagamento> criarPagamento(@RequestBody Pagamento pagamento){
        Pagamento novoPagamento = pagamentoService.criarPagamento(pagamento);
        return new ResponseEntity<>(novoPagamento, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> listarPagamentos(){
        List<Pagamento> pagamentos = pagamentoService.listarPagamentos();
        return new ResponseEntity<>(pagamentos, HttpStatus.OK);
    }

    @GetMapping("/{idPagamento}")
    public ResponseEntity<Pagamento> buscarPagamento(@PathVariable Integer idPagamento) {
        return pagamentoService.buscarPagamento(idPagamento)
                .map(pagamento -> new ResponseEntity<>(pagamento, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{idPagamento}")
    public ResponseEntity<Void> deletarPagamento(@PathVariable Integer idPagamento){
        pagamentoService.deletarPagamento(idPagamento);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idPagamento}")
    public ResponseEntity<Pagamento> atualizarPagamento(@PathVariable Integer idPagamento, @RequestBody Pagamento pagamento){
        /* Quando adicionamos uma "!" quer dizer que está pasando uma negação então em vez de ser isPresent se tornou isNotPresent */
        if (!pagamentoService.buscarPagamento(idPagamento).isPresent()){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pagamento.setIdPagamento(idPagamento);
        Pagamento novoPagamento = pagamentoService.atualizarPagamento(pagamento);
        return new ResponseEntity<>(novoPagamento, HttpStatus.OK);
    }
}

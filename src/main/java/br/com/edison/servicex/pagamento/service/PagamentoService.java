package br.com.edison.servicex.pagamento.service;

import br.com.edison.servicex.pagamento.domain.Pagamento;
import br.com.edison.servicex.pagamento.repositores.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public Pagamento criarPagamento(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public List<Pagamento> listarPagamentos(){
        return pagamentoRepository.findAll();
    }

    public Optional<Pagamento> buscarPagamento(Integer idPagamento){
        return pagamentoRepository.findById(idPagamento);
    }

    public Pagamento atualizarPagamento(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }

    public void deletarPagamento(Integer idPagamento){
        pagamentoRepository.deleteById(idPagamento);
    }
}

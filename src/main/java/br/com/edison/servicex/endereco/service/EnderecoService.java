package br.com.edison.servicex.endereco.service;

import br.com.edison.servicex.endereco.domain.Endereco;
import br.com.edison.servicex.endereco.repositores.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listarEnderecos(){
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> buscarEndereco(Integer idEndereco){
        return enderecoRepository.findById(idEndereco); }

    public Endereco atualizarEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public void deletarEndereco(Integer idEndereco){
        enderecoRepository.deleteById(idEndereco);
    }
}

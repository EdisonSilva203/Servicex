package br.com.edison.servicex.endereco.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ENDEREÇO")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID.ENDERECO")
    private Integer idEndereco;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "NUMERO")
    private String numero;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "COMPLEMENTO")
    private String complemento;
}

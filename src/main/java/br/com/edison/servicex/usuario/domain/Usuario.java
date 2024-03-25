package br.com.edison.servicex.usuario.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID.USUARIO")
    private Integer idUsuario;

    @Column(name = "NOME_USUARIO")
    private String nomeUsuario;

    @Column(name = "EMAIL_USUARIO")
    private String emailUsuario;

    @Column(name = "CPF_CNPJ")
    private String cpfCNPJ;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "TELEFONE")
    private String Telefone;

    @Column(name = "SENHA")
    private String senha;

    @Column(name = "PERFIL")
    private Integer perfil;
    }

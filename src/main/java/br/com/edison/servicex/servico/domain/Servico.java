package br.com.edison.servicex.servico.domain;

import br.com.edison.servicex.categoria.domain.Categoria;
import br.com.edison.servicex.ordemservico.domain.OrdemServico;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="SERVICO")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID.SERVICO")
    private Integer idServico;

    @Column(name = "NOME_SERVICO")
    private String nomeServico;

    @Column(name = "VALOR")
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

    @JsonIgnore
    @OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
    private List<OrdemServico> ordemServicos;
}

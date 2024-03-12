package br.com.edison.servicex.ordemservico.domain;



import br.com.edison.servicex.servico.domain.Servico;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name = "ORDEM_SERVIÇO")
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID.ORDEM_SERVICO")
    private Integer idOrdemServico;

    @Column(name = "VALOR_ORDEM_SERVICO")
    private Double valorOrdemServico;

    @Column(name = "DATA_SOLICITAÇÃO")
    private Date dataSolicitacao;

    @ManyToOne
    @JoinColumn(name = "idServico")
    private Servico servico;
}

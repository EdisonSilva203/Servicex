package br.com.edison.servicex.pagamento.domain;

import br.com.edison.servicex.enums.StatusPagamento;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PAGAMENTO")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID.PAGAMENTO")
    private Integer idPagamento;

    @Column(name = "STATUS_PAGAMENTO")
    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;
}

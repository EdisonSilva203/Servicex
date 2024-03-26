package br.com.edison.servicex.pagamento.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("PAGAMENTO_CARTÃO")
public class PagamentoCartao extends Pagamento{

    @Column(name = "NUMERO_PARCELAS")
    private Integer numeroParcelas;
}

package br.com.edison.servicex.pagamento.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("PAGAMENTO_BOLETO")
public class PagamentoBoleto extends Pagamento {

    @Column(name = "DATA_VENCIMENTO")
    private Date dataVencimento;

    @Column(name = "dataPagamento")
    private Date dataPagamento;
}

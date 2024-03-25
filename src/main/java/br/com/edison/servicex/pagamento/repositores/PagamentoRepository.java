package br.com.edison.servicex.pagamento.repositores;

import br.com.edison.servicex.pagamento.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}

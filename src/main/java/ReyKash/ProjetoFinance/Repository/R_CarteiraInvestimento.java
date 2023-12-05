package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_CarteiraInvestimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface R_CarteiraInvestimento extends JpaRepository<M_CarteiraInvestimento, Long> {

    Optional<M_CarteiraInvestimento> findByIdCliente(Long idCliente);


}
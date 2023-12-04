package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Investimento extends JpaRepository<M_Investimento, Long> {

}
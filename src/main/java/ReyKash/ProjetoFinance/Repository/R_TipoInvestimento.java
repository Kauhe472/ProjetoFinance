package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_TipoInvestimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_TipoInvestimento extends JpaRepository<M_TipoInvestimento, Long> {

    @Query(value="select * from tipo_investimento", nativeQuery = true)
    ArrayList<M_TipoInvestimento> listInvestimentos();

}
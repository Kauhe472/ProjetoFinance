/*package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_CarteiraVirtual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface R_CarteiraVirtual extends JpaRepository<M_CarteiraVirtual, Long> {

    @Query(value = "SELECT * FROM carteira_virtual WHERE id_cliente = :idCliente", nativeQuery = true)
    List<M_CarteiraVirtual> obterDetalhesCarteiraPorCliente(@Param("idCliente") Long idCliente);


}*/
package ReyKash.ProjetoFinance.Repository;



import ReyKash.ProjetoFinance.Model.M_Consultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Consultor extends JpaRepository<M_Consultor, Long> {
    @Query(value = "SELECT * FROM PESSOA WHERE nome = :nome", nativeQuery = true)
    M_Consultor findByNome(@Param("nome") String nome);
}

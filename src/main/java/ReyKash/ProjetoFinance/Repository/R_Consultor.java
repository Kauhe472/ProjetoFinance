package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Consultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_Consultor extends JpaRepository<M_Consultor, Long> {

    @Query(value="select * from consultor", nativeQuery = true)
    ArrayList<M_Consultor> listConsultores();

    @Query(value = "SELECT * FROM PESSOA WHERE nome = :nome", nativeQuery = true)
    M_Consultor findByNome(@Param("nome") String nome);

    @Query(value = "SELECT email, senha FROM consultores", nativeQuery = true)
    M_Consultor buscarEmailSenha (@Param("email") String email,
                                @Param("senha") String senha);

}

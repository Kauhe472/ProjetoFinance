package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Consultor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface R_Consultor extends JpaRepository<M_Consultor, Long> {

    @Query(value="select * from consultores", nativeQuery = true)
    List<M_Consultor> listConsultores();

    /*@Query(value =
            "SELECT consultores.nome as consultor, clientes.* " +
                    "FROM consultores " +
                    "INNER JOIN clientes ON consultores.id_consultor = clientes.id_consultor " +
                    "WHERE consultores.id_consultor = :id",
                    nativeQuery = true)
    List<M_Cliente> buscarClientesPorConsultor(@Param("id_consultor") Long id_consultor);

     */



    @Query(value = "SELECT * FROM consultores WHERE email = :email AND senha = :senha", nativeQuery = true)
    M_Consultor buscarEmailSenha (@Param("email") String email,
                                @Param("senha") String senha);



}

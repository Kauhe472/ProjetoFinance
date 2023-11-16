package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_Cliente extends JpaRepository<M_Cliente, Long> {
    @Query(value="select * from clientes", nativeQuery = true)
    ArrayList<M_Cliente> listClientes();

    @Query(value="select * from investimentoCliente", nativeQuery = true)
    ArrayList<Object> listInvestimento();

    @Query(value = "SELECT * FROM PESSOA WHERE nome = :nome", nativeQuery = true)
    M_Cliente findByNome(@Param("nome") String nome);

    @Query(value = "SELECT email, senha FROM clientes", nativeQuery = true)
    M_Cliente buscarEmailSenha (@Param("email") String email,
                                @Param("senha") String senha);

}
package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface R_Cliente extends JpaRepository<M_Cliente, Long> {

    @Query(value="select * from clientes", nativeQuery = true)
    List<M_Cliente> listClientes();

    @Query(value ="SELECT * FROM clientes WHERE id_consultor = :id_consultor",nativeQuery = true)
    List<M_Cliente> buscaClientesPorConsultor(@Param("id_consultor") Long id_consultor);


    @Query(value="select * from investimentoCliente", nativeQuery = true)
    List<Object> listInvestimento();

    @Query(value = "SELECT * FROM clientes WHERE nome = :nome", nativeQuery = true)
    M_Cliente findByNome(@Param("nome") String nome);

    @Query(value = "SELECT * FROM clientes WHERE email = :email AND senha = :senha", nativeQuery = true)
    M_Cliente buscarEmailSenha (@Param("email") String email,
                                @Param("senha") String senha);


}
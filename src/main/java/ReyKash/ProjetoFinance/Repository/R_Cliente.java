package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_Cliente extends JpaRepository<M_Cliente, Long> {
    @Query(value="select * from clientes", nativeQuery = true)
    ArrayList<M_Cliente> listClientes();

    @Query(value="select * from investimentoCliente where id_cliente = :id_cliente", nativeQuery = true)
    ArrayList<Object> listInvestimento(@Param("id_cliente") int id_cliente);
}
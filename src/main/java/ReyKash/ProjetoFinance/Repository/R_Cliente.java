package ReyKash.ProjetoFinance.Repository;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface R_Cliente extends JpaRepository<M_Cliente, Long> {
    @Query(value="select * from clientes", nativeQuery = true)
    ArrayList<M_Cliente> listClientes();
}
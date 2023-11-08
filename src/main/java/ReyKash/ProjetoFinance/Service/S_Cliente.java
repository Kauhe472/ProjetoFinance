package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Repository.R_Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Cliente {

    @Autowired
    private static R_Cliente r_cliente;

    public S_Cliente(R_Cliente r_cliente) {
        this.r_cliente = r_cliente;
    }

    public static List<M_Cliente> listarClientes() {
        return r_cliente.listClientes();
    }

    public M_Cliente adicionarCliente(M_Cliente cliente) {
        return r_cliente.save(cliente);
    }

    public M_Cliente editarCliente(Long id, M_Cliente cliente) {
        // Implemente a lógica de edição conforme necessário
        // ...
        return r_cliente.save(cliente);
    }

    public void excluirCliente(Long id) {
        r_cliente.deleteById(id);
    }
}
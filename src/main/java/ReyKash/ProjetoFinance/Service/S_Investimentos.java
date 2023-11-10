package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_InvestimentoCliente;
import ReyKash.ProjetoFinance.Repository.R_Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Investimentos {

    @Autowired
    private static R_Cliente r_investimentoCliente;

    public S_Investimentos(R_Cliente r_investimentoCliente) {
        this.r_investimentoCliente = r_investimentoCliente;
    }

    public static List<Object> listarInvestimentoCliente() {
        return r_investimentoCliente.listInvestimento();
    }

}
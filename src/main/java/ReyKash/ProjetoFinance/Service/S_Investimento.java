package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_Investimento;
import ReyKash.ProjetoFinance.Repository.R_Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Investimento {

    @Autowired
    private static R_Cliente r_investimento;

    public S_Investimento(R_Cliente r_investimento) {
        this.r_investimento = r_investimento;
    }

    public static List<Object> listarInvestimentos() {
        return r_investimento.listInvestimento(1);
    }
}

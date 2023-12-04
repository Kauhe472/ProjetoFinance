package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_Investimento;
import ReyKash.ProjetoFinance.Repository.R_Investimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Investimento {

    @Autowired
    private static R_Investimento r_investimento;


    @Autowired
    public S_Investimento(R_Investimento r_investimento) {
        this.r_investimento = r_investimento;
    }

    public List<M_Investimento> getAllInvestimentos() {
        return r_investimento.findAll();
    }

    public M_Investimento saveInvestimento(M_Investimento investimento) {
        return r_investimento.save(investimento);
    }

}
package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_CarteiraInvestimento;
import ReyKash.ProjetoFinance.Repository.R_CarteiraInvestimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class S_CarteiraInvestimento {

    @Autowired
    private R_CarteiraInvestimento r_Carteira_investimento;


    @Autowired
    public S_CarteiraInvestimento(R_CarteiraInvestimento r_Carteira_investimento) {
        this.r_Carteira_investimento = r_Carteira_investimento;
    }

    public List<M_CarteiraInvestimento> getAllInvestimentos() {
        return r_Carteira_investimento.findAll();
    }

    public M_CarteiraInvestimento saveInvestimento(M_CarteiraInvestimento investimento) {
        return r_Carteira_investimento.save(investimento);
    }


}
package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_TipoInvestimento;
import ReyKash.ProjetoFinance.Repository.R_TipoInvestimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class S_TipoInvestimento {

    public static R_TipoInvestimento r_tipoInvestimento;

    @Autowired
    public S_TipoInvestimento(R_TipoInvestimento r_tipoInvestimento) {
        this.r_tipoInvestimento = r_tipoInvestimento;
    }

    public static List<M_TipoInvestimento> listarTiposInvestimentos() {
        return r_tipoInvestimento.listInvestimentos();
    }

    public M_TipoInvestimento saveTipoInvestimento(M_TipoInvestimento tipo_investimento) {
        return r_tipoInvestimento.save(tipo_investimento);
    }

}

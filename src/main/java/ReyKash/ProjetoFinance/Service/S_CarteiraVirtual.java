/*package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_CarteiraVirtual;
import ReyKash.ProjetoFinance.Repository.R_CarteiraVirtual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class S_CarteiraVirtual {

    @Autowired
    private R_CarteiraVirtual r_carteiraVirtual;

    public List<M_CarteiraVirtual> obterDetalhesCarteiraPorCliente(Long idCliente) {
        return r_carteiraVirtual.obterDetalhesCarteiraPorCliente(idCliente);
    }

    public void adicionarDetalheCarteira(M_CarteiraVirtual detalheCarteira) {
        r_carteiraVirtual.save(detalheCarteira);
    }

}*/

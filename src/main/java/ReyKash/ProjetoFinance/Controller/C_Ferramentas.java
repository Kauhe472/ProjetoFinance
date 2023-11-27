package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Investimento;
import ReyKash.ProjetoFinance.Repository.R_Investimentos;
import ReyKash.ProjetoFinance.Service.S_TipoInvestimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class C_Ferramentas {

    private S_TipoInvestimento s_tipoInvestimento;

    @Autowired
    public C_Ferramentas(S_TipoInvestimento s_tipoInvestimento) {
        this.s_tipoInvestimento = s_tipoInvestimento;
    }

    @GetMapping("/carteiraInvestimento")
    public String getCarteiraInvestimento(Model model){
        model.addAttribute("tiposInvestimento", s_tipoInvestimento.listarTiposInvestimentos());
        return "Ferramentas/carteiraInvestimento";
    }

    @GetMapping("/tabelaClientes")
    public String getTabelaClientes(){
        return "Cliente/tabelaClientes";
    }

    @GetMapping("/tabelaClientes/carteiraInvestimentos")
    public String getCarteiraInvestimentos(){
        return "Ferramentas/carteiraInvestimentos";
    }


}

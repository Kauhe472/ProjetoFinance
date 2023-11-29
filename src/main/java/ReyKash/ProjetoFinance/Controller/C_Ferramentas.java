package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Service.S_TipoInvestimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/carteiraVirtual")
    public String getCarteiraVirtual(){
        return "Ferramentas/carteiraVirtual";
    }

    @GetMapping("/calculadora")
    public String getCalculadora(){
        return "Ferramentas/calculadora";
    }

    @GetMapping("/chat")
    public String getChat(){
        return "Ferramentas/chat";
    }


}

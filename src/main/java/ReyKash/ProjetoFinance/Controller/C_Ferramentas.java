package ReyKash.ProjetoFinance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Ferramentas {


    @GetMapping("/tabelaClientes")
    public String getTabelaClientes(){
        return "Cliente/tabelaClientes";
    }

    @GetMapping("/tabelaClientes/carteiraInvestimentos")
    public String getCarteiraInvestimentos(){
        return "Cliente/carteiraInvestimentos";
    }


}

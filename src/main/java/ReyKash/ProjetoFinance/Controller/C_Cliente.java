package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Service.S_Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class C_Cliente {

    @GetMapping("/tabelaClientes")
    public String getTabelaClientes(Model model) {
        model.addAttribute("clientes", S_Cliente.listarClientes());
        return "tabelaClientes";
    }

    @GetMapping("/CarteiraInvestimentos")
    public String getCarteiraInvestimentos(){
        return "carteiraInvestimentos";
    }

    @GetMapping("/edit/{id}")
    public String getCarteiraCliente(@PathVariable Long id){
        return "carteiraInvestimentos";
    }
}

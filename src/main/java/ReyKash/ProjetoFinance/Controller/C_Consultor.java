package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Service.S_Cadastro;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import ReyKash.ProjetoFinance.Service.S_Investimentos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Consultor {

    @GetMapping("/cadastroConsultor")
    public String getCadastroConsultor() {
        return "Cadastro/cadastroConsultor";
    }

    @PostMapping("/cadastroConsultor")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("email") String email,
                               @RequestParam("idade") String idade,
                               @RequestParam("senha") String senha,
                               @RequestParam("confsenha") String conf_senha) {
        String mensagem = S_Cadastro.validaCadastroConsultor(nome, email, idade, senha, conf_senha);

        return "redirect:Home/home";
    }

    @GetMapping("/TabelaClientes")
    public String getTabelaClientes(Model model) {
        model.addAttribute("clientes", S_Cliente.listarClientes());
        return "tabelaClientes";
    }

    @GetMapping("/CarteiraInvestimentos")
    public String getCarteiraInvestimentos(Model model){
        model.addAttribute("investimentoCliente", S_Investimentos.listarInvestimentoCliente());
        return "carteiraInvestimentos";
    }


}

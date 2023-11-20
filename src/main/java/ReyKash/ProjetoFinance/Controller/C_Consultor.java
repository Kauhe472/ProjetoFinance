package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Resposta;
import ReyKash.ProjetoFinance.Service.S_Cadastro;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import ReyKash.ProjetoFinance.Service.S_Investimentos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Consultor {

    @GetMapping("/cadastroConsultor")
    public String getCadastroConsultor() {
        return "Cadastro/cadastroConsultor";
    }

    @PostMapping("/cadastroConsultor")
    @ResponseBody
    public M_Resposta postCadastroConsultor(@RequestParam("nome") String nome,
                                            @RequestParam("email") String email,
                                            @RequestParam("cpf") String cpf,
                                            @RequestParam("idade") String idade,
                                            @RequestParam("senha") String senha,
                                            @RequestParam("confSenha") String confSenha) {
        return S_Cliente.cadastrarCliente(nome, email, cpf, idade, senha, confSenha);
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

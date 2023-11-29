package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Resposta;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import ReyKash.ProjetoFinance.Service.S_Consultor;
import ReyKash.ProjetoFinance.Service.S_Investimentos;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
                                            @RequestParam("data_nasc") String data_nasc,
                                            @RequestParam("senha") String senha,
                                            @RequestParam("confSenha") String confSenha) {
        return S_Consultor.salvarCadastro(nome, email, cpf, data_nasc, senha, confSenha);
    }


    @GetMapping("/tabelaClientes")
    public String getTabelaClientes(Model model,
                                    HttpSession session) {
        Long idConsultor = (Long) session.getAttribute("id_consultor");

        if (idConsultor != null) {
            List<M_Cliente> clientesDoConsultor = S_Cliente.listarClientesDoConsultor(idConsultor);

            model.addAttribute("clientes", clientesDoConsultor);

            return "Consultor/tabelaClientes";
        }
        else {
            return "redirect:/login";
        }
    }
    @GetMapping("/carteiraInvestimentos")
    public String getCarteiraInvestimentos(Model model){
        model.addAttribute("investimentoCliente", S_Investimentos.listarInvestimentoCliente());
        return "carteiraInvestimentos";
    }


}

package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Consultor;
import ReyKash.ProjetoFinance.Model.M_Resposta;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import ReyKash.ProjetoFinance.Service.S_Consultor;
import ReyKash.ProjetoFinance.Service.S_Generico;
import ReyKash.ProjetoFinance.Service.S_Investimentos;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/loginConsultor")
    public String getLogin(){
        return "Login/login";
    }

    @PostMapping("/loginConsultor")
    @ResponseBody
    public String postLoginConsultor(@RequestParam("email") String email,
                                     @RequestParam("senha") String senha,
                                     HttpSession session) {
        // Realize as verificações de validação antes de prosseguir
        email = S_Generico.limparNumero(email);
        if (S_Generico.textoEstaVazio(email) || S_Generico.textoEstaVazio(senha)) {
            return "redirect:/login?error=true";
        }

        M_Consultor consultor = S_Consultor.verificaLogin(email, senha);

        if (consultor != null) {
            // Login bem-sucedido
            session.setAttribute("consultores", true);
            return "redirect:/homeLogado";
        } else {
            // Login falhou
            session.setAttribute("consultores", false);
            return "redirect:/login?error=true";
        }
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

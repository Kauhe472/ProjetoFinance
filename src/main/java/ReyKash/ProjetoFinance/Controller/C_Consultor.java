package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Resposta;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import ReyKash.ProjetoFinance.Service.S_Consultor;
import ReyKash.ProjetoFinance.Service.S_Investimento;
import ReyKash.ProjetoFinance.Service.S_Investimento;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class C_Consultor {

    @GetMapping("/cadastro")
    public String getCadastroConsultor() {
        return "Cadastro/cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastroConsultor(@RequestParam("nome") String nome,
                                        @RequestParam("email") String email,
                                        @RequestParam("cpf") String cpf,
                                        @RequestParam("data_nasc") String data_nasc,
                                        @RequestParam("senha") String senha,
                                        @RequestParam("confSenha") String confSenha,
                                        @RequestParam("tipo_consultor") String tipo_consultor,
                                        HttpSession session,
                                        Model model) {
        M_Resposta resposta = S_Consultor.salvarCadastro(nome, email, cpf, data_nasc, senha, confSenha, tipo_consultor);

        // Se chegou aqui, houve algum erro no cadastro
        model.addAttribute("resposta", resposta);
        return "Cadastro/cadastro";
    }



}

package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Resposta;
import ReyKash.ProjetoFinance.Service.S_Consultor;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

        model.addAttribute("resposta", resposta);
        return "Cadastro/cadastro";
    }

    @Autowired
    private S_Consultor s_consultor;

    /*@GetMapping("/perfilConsultor")
    public String getPerfilConsultor(Model model, HttpSession session) {
        Long id_consultor = (Long) session.getAttribute("id_consultor");
        List<M_Consultor> consultores = s_consultor.findAllConsultores(session);
        model.addAttribute("consultores", consultores);
        return "Consultor/perfilConsultor";
    }*/

    @GetMapping("/perfilConsultor")
    public String getPeRFIL(){
        return "Consultor/perfilConsultor";
    }

}

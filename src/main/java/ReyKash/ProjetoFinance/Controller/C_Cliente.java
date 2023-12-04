    package ReyKash.ProjetoFinance.Controller;

    import ReyKash.ProjetoFinance.Model.M_Cliente;
    import ReyKash.ProjetoFinance.Model.M_Consultor;
    import ReyKash.ProjetoFinance.Model.M_Resposta;
    import ReyKash.ProjetoFinance.Service.S_Cliente;
    import ReyKash.ProjetoFinance.Service.S_Consultor;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.ResponseBody;
    import org.springframework.web.servlet.mvc.support.RedirectAttributes;

    import java.util.List;


    @Controller
    public class C_Cliente {

        @GetMapping("/cadastroCliente")
        public String getCadastroCliente(Model model) {
            model.addAttribute("consultores", S_Consultor.listarConsultores());
            return "Cadastro/cadastro";
        }

        @PostMapping("/cadastroCliente")
        @ResponseBody
        public M_Resposta postCadastro(@RequestParam("nome") String nome,
                                       @RequestParam("email") String email,
                                       @RequestParam("cpf") String cpf,
                                       @RequestParam("data_nasc") String data_nasc,
                                       @RequestParam("senha") String senha,
                                       @RequestParam("confSenha") String confSenha) {
            return S_Cliente.salvarCadastro(nome, email, cpf, data_nasc, senha, confSenha);
        }



    }

package ReyKash.ProjetoFinance.Controller;


import ReyKash.ProjetoFinance.Service.S_Cadastro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Cadastro {
    @GetMapping("/cadastro")
    public String getCadastro(){
        return "Cadastro/cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("email") String email,
                               @RequestParam("usuario") String usuario,
                               @RequestParam("senha") String senha,
                               @RequestParam("confsenha") String conf_senha){
        String mensagem = S_Cadastro.validaCadastro(nome, email, usuario, senha, conf_senha);
        return "redirect:Home/home";
    }
    @PostMapping("/cadastroConsultor")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("email") String email,
                               @RequestParam("telefone") String telefone,
                               @RequestParam("idade") String idade,
                               @RequestParam("senha") String senha,
                               @RequestParam("confsenha") String conf_senha) {
        String mensagem = S_Cadastro.validaCadastroConsultor(nome, email, telefone, idade, senha, conf_senha);

        return "redirect:Home/home";
    }
    @GetMapping("/")
    public String inicioPage() {
        return "inicio";
    }
    @GetMapping("/about")
    public String getAbout(){
        return "About/about";
    }

    @GetMapping("/cadastroConsultor")
    public String TestePage() {
        return "Cadastro/cadastro";
    }

    @GetMapping("/home")
    public String HomePage() {
        return "Home/home";
    }
}
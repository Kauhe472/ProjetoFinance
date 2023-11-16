package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Service.S_Cadastro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Cliente {


    @GetMapping("/cadastroCliente")
    public String getCadastro(){
        return "Cadastro/cadastroCliente";
    }

    @PostMapping("/cadastroCliente")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("email") String email,
                               @RequestParam("senha") String senha,
                               @RequestParam("confsenha") String conf_senha){
        String mensagem = S_Cadastro.validaCadastro(nome, email, senha, conf_senha);
        return "redirect:Home/home";
    }

}

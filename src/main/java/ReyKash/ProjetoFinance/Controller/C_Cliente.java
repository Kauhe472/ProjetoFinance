package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Service.S_Cadastro;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Cliente {


    @GetMapping("/cadastro")
    public String getCadastro(){
        return "Cadastro/cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("nome") String nome,
                               @RequestParam("email") String email,
                               @RequestParam("cpf") String cpf,
                               @RequestParam("idade") String idade,
                               @RequestParam("senha") String senha,
                               @RequestParam("confsenha") String conf_senha) {
        String mensagem = S_Cadastro.validaCadastro(nome, email, cpf, idade, senha, conf_senha);
        return "redirect:Home/home";
    }

    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin(@RequestParam("email") String email,
                             @RequestParam("senha") String senha,
                             HttpSession session){
        session.setAttribute("usuario", S_Cliente.verificaLogin(email, senha));
        if(session.getAttribute("usuario") == null){
            return false;
        }else{
            return true;
        }
    }



}

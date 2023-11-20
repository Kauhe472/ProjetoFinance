package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Resposta;
import ReyKash.ProjetoFinance.Service.S_Cadastro;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Cliente {


    @GetMapping("/cadastro")
    public String getCadastro(HttpServletRequest request){
        if(request.getHeader("Referer") != null){
            return "Cadastro/cadastro";
        }else{
            return "redirect:/";
        }
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public M_Resposta postCadastro(@RequestParam("nome") String nome,
                                   @RequestParam("email") String email,
                                   @RequestParam("cpf") String cpf,
                                   @RequestParam("idade") String idade,
                                   @RequestParam("senha") String senha,
                                   @RequestParam("confSenha") String confSenha) {
        return S_Cliente.cadastrarCliente(nome, email, cpf, idade, senha, confSenha);
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

    package ReyKash.ProjetoFinance.Controller;

    import ReyKash.ProjetoFinance.Model.M_Cliente;
    import ReyKash.ProjetoFinance.Model.M_Resposta;
    import ReyKash.ProjetoFinance.Repository.R_Cliente;
    import ReyKash.ProjetoFinance.Service.S_Cadastro;
    import ReyKash.ProjetoFinance.Service.S_Cliente;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpSession;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.format.annotation.DateTimeFormat;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.ResponseBody;

    import java.time.LocalDate;

    @Controller
    public class C_Cliente {

        @GetMapping("/cadastro")
        public String getCadCliente(){
            return "Cadastro/cadastro";
        }

        @PostMapping("/cadastro")
        @ResponseBody
        public M_Resposta postCadastro(@RequestParam("nome") String nome,
                                       @RequestParam("email") String email,
                                       @RequestParam("cpf") String cpf,
                                       @RequestParam("data_nasc") String data_nasc,
                                       @RequestParam("senha") String senha,
                                       @RequestParam("confSenha") String confSenha) {
            return S_Cliente.salvarCadastro(nome, email, cpf, data_nasc, senha, confSenha);
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

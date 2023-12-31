package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Consultor;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import ReyKash.ProjetoFinance.Service.S_Consultor;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class C_Login {

    @Autowired
    private S_Consultor s_consultor;

    @Autowired
    private S_Cliente s_cliente;

    @GetMapping("/login")
    public String getLogin(){
        return "Login/login";
    }


        @PostMapping("/login")
        @ResponseBody
        public ResponseEntity<String> postLogin(@RequestParam("email") String email,
                                                @RequestParam("senha") String senha,
                                                HttpSession session) {
            M_Consultor consultor = S_Consultor.verificaLogin(email, senha, session);
            M_Cliente cliente = S_Cliente.verificaLogin(email, senha, session);

            if (consultor != null) {
                session.setAttribute("consultor", consultor.getId_consultor());
                return ResponseEntity.ok("consultor");
            } else if (cliente != null) {
                session.setAttribute("cliente", cliente.getId_cliente());
                return ResponseEntity.ok("cliente");
            } else {
                return ResponseEntity.ok("erro");
            }

        }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }



}

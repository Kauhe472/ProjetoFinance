package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Consultor;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import ReyKash.ProjetoFinance.Service.S_Consultor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeParseException;

@Controller
public class C_Login {

    @GetMapping("/login")
    public String getLogin(){
        return "Login/login";
    }

    @PostMapping("/login")
    public ResponseEntity<String> postLogin(@RequestParam("email") String email,
                                            @RequestParam("senha") String senha,
                                            Model model) {
        M_Consultor consultor = S_Consultor.verificaLogin(email, senha);
        M_Cliente cliente = S_Cliente.verificaLogin(email, senha);

        if (consultor != null) {
            model.addAttribute("nome", "Bem Vindo(a) " + consultor.getNome());
            return ResponseEntity.ok("consultor");
        } else if (cliente != null) {
            model.addAttribute("nome", "Bem Vindo(a) " + cliente.getNome());
            return ResponseEntity.ok("cliente");
        } else {
            return ResponseEntity.ok("erro");
        }
    }


}

package ReyKash.ProjetoFinance.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Home {


    @GetMapping("/homeLogado")
    public String HomeLogado() {
        return "Home/homeLogado";
    }

    @GetMapping("/sobrenos")
    public String getSobrenos(){
        return "Home/sobrenos";
    }

}

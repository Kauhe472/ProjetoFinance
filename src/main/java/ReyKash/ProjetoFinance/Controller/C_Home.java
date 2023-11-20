package ReyKash.ProjetoFinance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Home {

    @GetMapping("/about")
    public String getAbout(){
        return "About/about";
    }

    @GetMapping("/home")
    public String HomePage() {
        return "Home/home";
    }

    @GetMapping("/sobrenos")
    public String getSobrenos(){
        return "Home/sobrenos";
    }

    @GetMapping("/ferramentas")
    public String getFeramentas(){
        return "Consultor/ferramentas";
    }

}

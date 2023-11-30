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

    @GetMapping("/homeLogado")
    public String HomeLogado() {
        return "Home/homeLogado";
    }

    @GetMapping("/sobrenos")
    public String getSobrenos(){
        return "Home/sobrenos";
    }


}

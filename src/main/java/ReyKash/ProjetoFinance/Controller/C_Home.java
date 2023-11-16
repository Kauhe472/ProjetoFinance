package ReyKash.ProjetoFinance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Home {

    @GetMapping("/about")
    public String getAbout(){
        return "About/about";
    }

    @GetMapping("/")
    public String HomePage() {
        return "Home/home";
    }
}

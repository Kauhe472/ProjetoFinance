package ReyKash.ProjetoFinance.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Login {

    @GetMapping("/login")
    public String landLogin(){
        return "Login/login";
    }

    @PostMapping("/")
    public String getLogin(@RequestParam("email") String email,
                           @RequestParam("senha") String senha){
        String validUser = "email";
        String validPassword = "senha";
        if(email.equals(validUser) && senha.equals(validPassword)){
            return "Home/home";
        }else{
            return "Login/login";
        }

    }
}

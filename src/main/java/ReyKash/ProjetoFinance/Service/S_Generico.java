package ReyKash.ProjetoFinance.Service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class S_Generico {
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean textoEstaVazio(String texto){
        return texto == null || texto.trim().equals("");
    }

    public static String limparNumero(String numero) {
        return numero.replaceAll("[^0-9]", "");
    }
}
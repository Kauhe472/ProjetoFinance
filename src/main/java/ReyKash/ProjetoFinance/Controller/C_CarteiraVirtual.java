/*package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_CarteiraVirtual;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class C_CarteiraVirtual {

    private final S_Cliente s_cliente;

    public C_CarteiraVirtual(S_Cliente s_cliente) {
        this.s_cliente = s_cliente;
    }

    @GetMapping("/carteiraVirtual/{id_cliente}")
    public String getCarteiraVirtual(@PathVariable Long idCliente, Model model, HttpSession session) {
        Long idConsultor = (Long) session.getAttribute("id_consultor");

        if (idConsultor != null) {
            // Aqui você pode ajustar conforme necessário para obter a carteira virtual específica do cliente
            M_CarteiraVirtual carteiraVirtual = s_cliente.obterCarteiraVirtualCliente(idConsultor, idCliente);

            model.addAttribute("carteiraVirtual", carteiraVirtual);
            return "carteiraVirtual";  // Ajuste o nome da sua página Thymeleaf conforme necessário
        } else {
            return "redirect:/login";  // Redireciona para a página de login se o ID do consultor não estiver na sessão
        }
    }

    // Outros métodos conforme necessário
}*/

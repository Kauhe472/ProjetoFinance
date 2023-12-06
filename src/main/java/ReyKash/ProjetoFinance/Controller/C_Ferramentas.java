package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Consultor;
import ReyKash.ProjetoFinance.Model.M_TipoInvestimento;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import ReyKash.ProjetoFinance.Service.S_Consultor;
import ReyKash.ProjetoFinance.Service.S_TipoInvestimento;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class C_Ferramentas {

    private final S_TipoInvestimento s_tipoInvestimento;
    private final S_Consultor s_consultor;
    private final S_Cliente s_cliente;

    @Autowired
    public C_Ferramentas(S_TipoInvestimento s_tipoInvestimento, S_Consultor s_consultor, S_Cliente s_cliente) {
        this.s_tipoInvestimento = s_tipoInvestimento;
        this.s_consultor = s_consultor;
        this.s_cliente = s_cliente;
    }

    @GetMapping("/ferramentas")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("consultor") != null) {
            model.addAttribute("consultor",session.getAttribute("id_consultor"));
            return "Consultor/ferramentas";
        }
        else if (session.getAttribute("cliente") != null) {
            model.addAttribute("cliente",session.getAttribute("id_cliente"));
            return "Cliente/ferramentasCliente";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/carteiraInvestimento/{id_cliente}")
    public String getCarteiraInvestimento(@PathVariable("id_cliente") Long idCliente, Model model, HttpSession session) {
        if (session.getAttribute("consultor") != null) {
            model.addAttribute("consultor",session.getAttribute("id_consultor"));
            return "Ferramentas/carteiraInvestimento";
        }
        else if (session.getAttribute("cliente") != null) {
            model.addAttribute("cliente",session.getAttribute("id_cliente"));
            return "Ferramentas/carteiraInvestimento";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/carteiraInvestimento")
    public ResponseEntity<String> adicionarInvestimento(@RequestParam String tipo,
                                                        @RequestParam String tag,
                                                        @RequestParam double valor) {
        // Lógica para adicionar investimento
        return ResponseEntity.ok("Investimento adicionado com sucesso");
    }

    @GetMapping("/tabelaClientes")
    public String getTabelaClientes(Model model, HttpSession session) {
        Long id_consultor = (Long) session.getAttribute("id_consultor");
        List<M_Cliente> clientes = s_cliente.getClientesByConsultor(id_consultor);
        model.addAttribute("clientes", clientes);
        return "Consultor/tabelaClientes";
    }

    @GetMapping("/carteiraVirtual")
    public String getCarteiraVirtual(Model model, HttpSession session) {
        if (session.getAttribute("consultor") != null) {
            model.addAttribute("consultor",session.getAttribute("id_consultor"));
            return "Ferramentas/carteiraVirtual";
        }
        else if (session.getAttribute("cliente") != null) {
            model.addAttribute("cliente",session.getAttribute("id_cliente"));
            return "Ferramentas/carteiraVirtual";
        } else {
            return "redirect:/";
        }
    }


    @GetMapping("/calculadora")
    public String getCalculadora(Model model, HttpSession session) {
        return "Ferramentas/calculadora";
    }

    @GetMapping("/chat")
    public String getChat(Model model, HttpSession session) {
        return "Ferramentas/chat";
    }


    @GetMapping("/avaliarConsultor")
    public String getPerfilCliente(Model model, HttpSession session) {
        return "Cliente/avaliarConsultor";
    }


}

package ReyKash.ProjetoFinance.Controller;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Service.S_Cliente;
import ReyKash.ProjetoFinance.Service.S_TipoInvestimento;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class C_Ferramentas {

    private final S_TipoInvestimento s_tipoInvestimento;
    private final S_Cliente s_cliente;

    @Autowired
    public C_Ferramentas(S_TipoInvestimento s_tipoInvestimento, S_Cliente s_cliente) {
        this.s_tipoInvestimento = s_tipoInvestimento;
        this.s_cliente = s_cliente;
    }

    @GetMapping("/carteiraInvestimento")
    public String getCarteiraInvestimento(Model model, HttpSession session) {
        model.addAttribute("tiposInvestimento", s_tipoInvestimento.listarTiposInvestimentos());
        return "Ferramentas/carteiraInvestimento";
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
        return "Ferramentas/carteiraVirtual";
    }

    @GetMapping("/calculadora")
    public String getCalculadora(Model model, HttpSession session) {
        return "Ferramentas/calculadora";
    }

    @GetMapping("/chat")
    public String getChat(Model model, HttpSession session) {
        return "Ferramentas/chat";
    }

    @GetMapping("/ferramentas")
    public String getFerramentas() {
        return "Consultor/ferramentas";
    }

    @GetMapping("/perfilConsultor")
    public String getPerfilConsultor() {
        return "Consultor/perfilConsultor";
    }

    @GetMapping("/perfilCliente")
    public String getPerfilCliente(Model model, HttpSession session) {
        return "Consultor/perfilCliente";
    }
}

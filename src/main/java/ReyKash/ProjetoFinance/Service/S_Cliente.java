package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Repository.R_Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Cliente {

    @Autowired
    private static R_Cliente r_cliente;

    public S_Cliente(R_Cliente r_cliente) {
        this.r_cliente = r_cliente;
    }

    public static List<M_Cliente> listarClientes() {
        return r_cliente.listClientes();
    }

    public static M_Cliente verificaLogin(String email, String senha){
        email = S_Generico.limparNumero(email);

        if(S_Generico.textoEstaVazio(email)){
            return null;
        }else if(S_Generico.textoEstaVazio(senha)){
            return null;
        }
        return r_cliente.buscarEmailSenha(email,
                senha);
    }

    public static String cadatrasCliente(String nome, String email, String cpf, String idade, String senha){
        boolean podeSalvar = true;
        String mensagem = "";

        if(S_Generico.textoEstaVazio(nome)){
            podeSalvar = false;
            mensagem += "O nome precisa ser preenchido!";
        }
        if(!S_Generico.validarEmail(email)){
            podeSalvar = false;
            mensagem += "e-Mail inválido!";
        }
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(cpf))){
            podeSalvar = false;
            mensagem += "A matricula precisa ser informada!";
        }
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(idade))){
            podeSalvar = false;
            mensagem += "O cargo deve ser selecionado!";
        }

        if(podeSalvar){
            M_Cliente m_cliente = new M_Cliente();
            m_cliente.setNome(nome);
            m_cliente.setEmail(email);
            m_cliente.setCpf(cpf);
            m_cliente.setIdade(idade);
            m_cliente.setSenha(S_GeradorSenha.gerarSenha(5,3,2));

            try{
                r_cliente.save(m_cliente);
                mensagem += "Usuário cadastrado com sucesso!";
            }catch (DataIntegrityViolationException e){
                mensagem += "Falha ao cadastrar usuário";
            }
        }
        return mensagem;
    }
}
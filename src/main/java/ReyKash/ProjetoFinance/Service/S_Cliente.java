package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Resposta;
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
        return r_cliente.buscarEmailSenha(email, senha);
    }

    public static M_Resposta salvarCadastro(String nome, String email, String cpf,
                                              String idade, String senha, String confSenha){
        boolean podeSalvar = true;
        String mensagem = "";

        if(S_Generico.textoEstaVazio(nome)){
            podeSalvar = false;
            mensagem += "O nome precisa ser preenchido!";
        }
        if(!S_Generico.validarEmail(email)){
            podeSalvar = false;
            mensagem += "e-Mail é inválido!";
        }
        if(!S_CPF.validarCPF(cpf)){
            podeSalvar = false;
            mensagem += "O CPF informado é inválido!";
        }
        if(S_Generico.textoEstaVazio(S_Generico.limparNumero(idade))){
            podeSalvar = false;
            mensagem += "A idade deve ser selecionada!";
        }

        if(senha == null || senha.equals("")){
            podeSalvar = false;
            mensagem += "É necessário informar uma senha!";
        }else if(!senha.equals(confSenha)){
            mensagem += "A senha e a confirmação de senha precisam ser iguais!";
        }

        if(podeSalvar){
            M_Cliente m_cliente = new M_Cliente();
            m_cliente.setNome(nome);
            m_cliente.setEmail(email);
            m_cliente.setCpf(cpf);
            m_cliente.setIdade(idade);
            m_cliente.setSenha(senha);

            try {
                r_cliente.save(m_cliente);
                mensagem += "Cadastro realizado com sucesso!";
            }catch (DataIntegrityViolationException e){
                podeSalvar = false;
                mensagem += "Falha ao incluir registro no banco de dados.";
            }
        }
        return new M_Resposta(podeSalvar, mensagem);
    }
}
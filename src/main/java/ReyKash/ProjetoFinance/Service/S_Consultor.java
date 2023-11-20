package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Model.M_Consultor;
import ReyKash.ProjetoFinance.Model.M_Resposta;
import ReyKash.ProjetoFinance.Repository.R_Cliente;
import ReyKash.ProjetoFinance.Repository.R_Consultor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Consultor {

    @Autowired
    private static R_Consultor r_consultor;

    public S_Consultor(R_Consultor r_consultor) {
        this.r_consultor = r_consultor;
    }

    public static List<M_Consultor> listarClientes() {
        return r_consultor.listConsultores();
    }


    public static M_Consultor verificaLogin(String email, String senha){
        email = S_Generico.limparNumero(email);

        if(S_Generico.textoEstaVazio(email)){
            return null;
        }else if(S_Generico.textoEstaVazio(senha)){
            return null;
        }
        return r_consultor.buscarEmailSenha(email, senha);
    }

    public static M_Resposta cadastrarConsultor(String nome, String email, String cpf,
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
            M_Consultor m_consultor = new M_Consultor();
            m_consultor.setNome(nome);
            m_consultor.setEmail(email);
            m_consultor.setCpf(cpf);
            m_consultor.setIdade(idade);
            m_consultor.setSenha(senha);

            try {
                r_consultor.save(m_consultor);
                mensagem += "Cadastro realizado com sucesso!";
            }catch (DataIntegrityViolationException e){
                podeSalvar = false;
                mensagem += "Falha ao incluir registro no banco de dados.";
            }
        }
        return new M_Resposta(podeSalvar, mensagem);
    }
}
package ReyKash.ProjetoFinance.Service;

import ReyKash.ProjetoFinance.Model.M_Cliente;
import ReyKash.ProjetoFinance.Repository.R_Cliente;
import org.springframework.stereotype.Service;

@Service
public class S_Cadastro {
    private static R_Cliente r_cliente;

    public S_Cadastro(R_Cliente r_cliente) {
        this.r_cliente = r_cliente;
    }

    public static String validaCadastro(String nome, String email,
                                        String senha, String conf_senha){
        String mensagem = "";
        boolean podeSalvar = true;
        if(!senha.equals(conf_senha) || senha == null || senha.trim().equals("")){
            mensagem += "Senha e confirmação de senha não conferem\n";
            podeSalvar = false;
        }
        if(nome == null || nome.trim().equals("")){
            mensagem += "O nome precisa ser preenchido\n";
            podeSalvar = false;
        }
        if(email == null || email.trim().equals("")){
            mensagem += "O e-Mail precisa ser preenchido\n";
            podeSalvar = false;
        }



        return mensagem;
    }
    public static String validaCadastroConsultor(String nome, String email, String idade, String senha, String confSenha) {
        // Verifique se todos os campos são preenchidos
        if (nome.isEmpty() || email.isEmpty() || idade.isEmpty() || senha.isEmpty() || confSenha.isEmpty()) {
            return "Todos os campos são obrigatórios";
        }

        // Verifique se as senhas coincidem
        if (!senha.equals(confSenha)) {
            return "As senhas não coincidem";
        }

        return "Cadastro realizado com sucesso!";
    }
}


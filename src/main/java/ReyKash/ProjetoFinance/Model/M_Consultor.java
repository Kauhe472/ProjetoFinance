package ReyKash.ProjetoFinance.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "consultores")
public class M_Consultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_consultor;
    private String nome;
    private String email;
    private String cpf;
    private String idade;
    private String senha;


    public Long getId_consultor() {
        return id_consultor;
    }

    public void setId_consultor(Long id_consultor) {
        this.id_consultor = id_consultor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}



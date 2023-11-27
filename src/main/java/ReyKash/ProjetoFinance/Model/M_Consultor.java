package ReyKash.ProjetoFinance.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "consultores")
public class M_Consultor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consultor")
    private Long id_consultor;
    private String nome;
    private String email;
    private Long cpf;
    private LocalDate data_nasc;
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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}



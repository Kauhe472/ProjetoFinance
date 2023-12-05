package ReyKash.ProjetoFinance.Model;

import jakarta.persistence.*;
import java.util.List;

import java.time.LocalDate;

@Entity
@Table(name="clientes")
public class M_Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nome;
    private String email;
    private Long cpf;
    private LocalDate data_nasc;
    private String senha;
    private Long id_consultor;


    public Long getId_consultor() {
        return id_consultor;
    }

    public void setId_consultor(Long id_consultor) {
        this.id_consultor = id_consultor;
    }

    public Long getIdConsultor() {
        return id_consultor;
    }

    public void setIdConsultor(Long id_consultor) {
        this.id_consultor = id_consultor;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
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
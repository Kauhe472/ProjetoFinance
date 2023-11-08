package ReyKash.ProjetoFinance.Model;

import jakarta.persistence.*;

@Entity
@Table(name="clientes")
public class M_Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String nome;
    private String email;
    private String perfilInvestidor;


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

    public String getPerfilInvestidor() {
        return perfilInvestidor;
    }

    public void setPerfilInvestidor(String perfilInvestidor) {
        this.perfilInvestidor = perfilInvestidor;
    }
}
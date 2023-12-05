package ReyKash.ProjetoFinance.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_investimento")
public class M_TipoInvestimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_investimento;

    private String nome_investimento;


    public Long getId_tipo_investimento() {
        return id_tipo_investimento;
    }

    public void setId_tipo_investimento(Long id_tipo_investimento) {
        this.id_tipo_investimento = id_tipo_investimento;
    }

    public String getNome_investimento() {
        return nome_investimento;
    }

    public void setNome_investimento(String nome_investimento) {
        this.nome_investimento = nome_investimento;
    }


}

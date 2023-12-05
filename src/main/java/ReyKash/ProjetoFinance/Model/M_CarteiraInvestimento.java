package ReyKash.ProjetoFinance.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "carteira_investimentos")
public class M_CarteiraInvestimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carteira_investimento;

    private Long id_tipo_investimento;
    private Long  id_cliente;
    private String tag;
    private Long valor;


    public Long getId_carteira_investimento() {
        return id_carteira_investimento;
    }

    public void setId_carteira_investimento(Long id_carteira_investimento) {
        this.id_carteira_investimento = id_carteira_investimento;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_tipo_investimento() {
        return id_tipo_investimento;
    }

    public void setId_tipo_investimento(Long id_tipo_investimento) {
        this.id_tipo_investimento = id_tipo_investimento;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

}

package ReyKash.ProjetoFinance.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "carteira_investimentos")
public class M_Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carteiraInvestimento;

    private M_Cliente cliente;
    private M_TipoInvestimento tipo_investimento;
    private String tagInvestimento;
    private Double valorInvestimento;


    public Long getId_carteiraInvestimento() {
        return id_carteiraInvestimento;
    }

    public void setId_carteiraInvestimento(Long id_carteiraInvestimento) {
        this.id_carteiraInvestimento = id_carteiraInvestimento;
    }

    public M_TipoInvestimento getTipo_investimento() {
        return tipo_investimento;
    }

    public void setTipo_investimento(M_TipoInvestimento tipo_investimento) {
        this.tipo_investimento = tipo_investimento;
    }

    public M_Cliente getCliente() {
        return cliente;
    }

    public void setCliente(M_Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTagInvestimento() {
        return tagInvestimento;
    }

    public void setTagInvestimento(String tagInvestimento) {
        this.tagInvestimento = tagInvestimento;
    }

    public Double getValorInvestimento() {
        return valorInvestimento;
    }

    public void setValorInvestimento(Double valorInvestimento) {
        this.valorInvestimento = valorInvestimento;
    }
}

package ReyKash.ProjetoFinance.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "investimento")
public class M_Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_investimento")
    private Long idInvestimento;

    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "id_tipo_investimento")
    private Long idTipoInvestimento;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    private M_Cliente m_cliente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_investimento", referencedColumnName = "id_tipo_investimento", insertable = false, updatable = false)
    private M_TipoInvestimento m_tipoInvestimento;



    public Long getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(Long idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdTipoInvestimento() {
        return idTipoInvestimento;
    }

    public void setIdTipoInvestimento(Long idTipoInvestimento) {
        this.idTipoInvestimento = idTipoInvestimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public M_Cliente getM_cliente() {
        return m_cliente;
    }

    public void setM_cliente(M_Cliente m_cliente) {
        this.m_cliente = m_cliente;
    }

    public M_TipoInvestimento getM_tipoInvestimento() {
        return m_tipoInvestimento;
    }

    public void setM_tipoInvestimento(M_TipoInvestimento m_tipoInvestimento) {
        this.m_tipoInvestimento = m_tipoInvestimento;
    }
}

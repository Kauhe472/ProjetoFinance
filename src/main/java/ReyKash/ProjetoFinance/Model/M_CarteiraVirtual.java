/*package ReyKash.ProjetoFinance.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "carteiraVirtual")
public class M_CarteiraVirtual {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carteira;

    // outras colunas

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private M_Cliente cliente;

    public Long getId_carteira() {
        return id_carteira;
    }

    public void setId_carteira(Long id_carteira) {
        this.id_carteira = id_carteira;
    }

    public M_Cliente getCliente() {
        return cliente;
    }

    public void setCliente(M_Cliente cliente) {
        this.cliente = cliente;
    }
}*/

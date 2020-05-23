package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM_FEIRA")
public class ItemFeira {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(generator = "S_ITEM_FEIRA")
	@SequenceGenerator(name = "S_ITEM_FEIRA", sequenceName = "S_ITEM_FEIRA", allocationSize = 1)
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "QUANTIDADE", nullable = false)
	private double quantidade;

	@Column(name = "UNIDADE", nullable = false)
	private String unidade;

	@ManyToOne
	@JoinColumn(name = "ID_FEIRA", referencedColumnName = "ID", nullable = false)
	private Feira feira;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Feira getFeira() {
		return feira;
	}

	public void setFeira(Feira feira) {
		this.feira = feira;
	}

}

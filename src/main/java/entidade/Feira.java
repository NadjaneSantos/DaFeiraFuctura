package entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FEIRA")
public class Feira {

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(generator = "S_FEIRA")
	@SequenceGenerator(name = "S_FEIRA", sequenceName = "S_FEIRA", allocationSize = 1)
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "DATA", nullable = false)
	private Date data;

	@Column(name = "OBSERVACAO", nullable = false)
	private String observacao;

	@OneToMany(mappedBy = "feira", cascade = CascadeType.ALL)
	private List<ItemFeira> itens;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<ItemFeira> getItens() {
		return itens;
	}

	public void setItens(List<ItemFeira> itens) {
		this.itens = itens;
	}

}

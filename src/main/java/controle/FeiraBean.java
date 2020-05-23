package controle;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.FeiraDAO;
import dao.FeiraDAOImpl;
import entidade.Feira;
import entidade.ItemFeira;

@ManagedBean(name = "FeiraBean")
@SessionScoped
public class FeiraBean {

	private Feira feira;
	private ItemFeira itemFeiraAdicionar;

	private FeiraDAO feiraDAO;
	
	private String nomeItemSelecionado;
	
	private static final String LISTAR="ListarFeira.xhtml";
	private static final String MANTER="ManterFeira.xhtml";

	public FeiraBean() {
		
		this.feira = new Feira();
		this.feira.setItens(new ArrayList<ItemFeira>());
		
		this.itemFeiraAdicionar = new ItemFeira();
		
		this.feiraDAO = new FeiraDAOImpl();
		
	}

	public void salvarFeira() throws IOException {
		this.feiraDAO.inserir(this.feira);
		abrirListarFeira();
		//adicionar mensagem de sucesso.
	}
	
	public void abrirListarFeira() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(LISTAR);
	}
	
	public void abrirManterFeira() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect(MANTER);
	}
	
	public void adicionarItem() {
		
		ItemFeira novo = new ItemFeira();
		
		novo.setFeira(this.feira);
		novo.setNome(this.itemFeiraAdicionar.getNome());
		novo.setQuantidade(this.itemFeiraAdicionar.getQuantidade());
		novo.setUnidade(this.itemFeiraAdicionar.getUnidade());
		
		boolean achou = false;
		for (ItemFeira item : this.feira.getItens()) {
			if(item.getNome().equalsIgnoreCase(this.itemFeiraAdicionar.getNome())) {
				achou = true;
			}
		}
		
		if(achou) {
			//mensagem item já existe na lista
		}else {
			this.feira.getItens().add(novo);			
		}
				
		//adicionar mensagem de sucesso.
		
	}
	
	public void removerItem() {
		
		ItemFeira itemAchado = null;
		
		for (ItemFeira item : this.feira.getItens()) {
			if(item.getNome().equalsIgnoreCase(this.nomeItemSelecionado)) {
				itemAchado = item;
			}
		}
		
		if(itemAchado != null) {
			this.feira.getItens().remove(itemAchado);
			if(itemAchado.getId() != null) {
				this.feiraDAO.removerItem(itemAchado);
			}
		}
	}
	
	
	public Feira getFeira() {
		return feira;
	}

	public void setFeira(Feira feira) {
		this.feira = feira;
	}

	public ItemFeira getItemFeiraAdicionar() {
		return itemFeiraAdicionar;
	}

	public void setItemFeiraAdicionar(ItemFeira itemFeiraAdicionar) {
		this.itemFeiraAdicionar = itemFeiraAdicionar;
	}

	public String getNomeItemSelecionado() {
		return nomeItemSelecionado;
	}

	public void setNomeItemSelecionado(String nomeItemSelecionado) {
		this.nomeItemSelecionado = nomeItemSelecionado;
	}

}

package dao;

import java.util.List;

import entidade.Feira;
import entidade.ItemFeira;

/**
 * 
 * @author Cleiton
 *
 *  UsuarioDAO é uma interface, onde compartilha a chamada dos metodos, mas não os implementam.
 */

public interface FeiraDAO {
	
	public void inserir(Feira feira);
	
	public void alterar(Feira feira);

	public void remover(Feira feira);

	public Feira pesquisar(Long id);

	public List<Feira> listarTodos();
	
	public void removerItem(ItemFeira itemFeira);

}

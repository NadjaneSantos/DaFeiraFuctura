package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Feira;
import entidade.ItemFeira;
import util.JpaUtil;

/**
 * 
 * @author Cleiton
 *
 *	Essa classe implementa a interface, todos os metodos mostrados na interface.
 *  Lembrando de uma coisa, a implementação ela recebe no construtor o entityManager,
 *  a conexão com o banco de dados, deixando assim essa classe totalemnte independente 
 *
 */

public class FeiraDAOImpl implements FeiraDAO {

	/**
	 * Metodo inserir, recebe o usuario todo preenchido, cria uma transição, inicia e 
	 * executar a ação de persistir, tudo dando certo realiza o commit no final
	 */
	public void inserir(Feira feira) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.persist(feira);
		
		tx.commit();
		ent.close();

	}

/**
 * Metodo alterar, recebe o usuario, criar uma transição, inicia e executa a ação de merger
 */
	public void alterar(Feira feira) {

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.merge(feira);
		
		tx.commit();
		ent.close();

	}


	public void remover(Feira feira) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(feira);
		
		tx.commit();
		ent.close();
		
	}

/**
 * Pesquisar, pesquisar pela chave primaria que seria o cpf
 */
	public Feira pesquisar(Long id) {
		
		EntityManager ent = JpaUtil.getEntityManager();
		Feira feira = ent.find(Feira.class, id);
		
		return feira;
		
	}

/**
 * O metodo listar todos, faz um select * from, porém com o JPA, vc faz a consulta pelo objeto direto
 * assim from Usuario, que isso é o objeto usuario e não a tabela
 */
	public List<Feira> listarTodos() {

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Feira f");
		
		List<Feira> feiras = query.getResultList();
	
		return feiras;
		
	}

	
	public void removerItem(ItemFeira itemFeira) {
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction tx = ent.getTransaction();
		tx.begin();
		
		ent.remove(itemFeira);
		
		tx.commit();
		ent.close();
	}
	
	
	
	
	
	
	
	
	
}

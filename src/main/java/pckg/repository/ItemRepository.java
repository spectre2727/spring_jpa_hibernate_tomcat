package pckg.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pckg.entity.Item;

@Repository
@Transactional
public class ItemRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Item> selectAllItems() {
		String query = "select i from Item i order by i.value";
		return entityManager.createQuery(query, Item.class).getResultList();
	}

}

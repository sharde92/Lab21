package co.grandcircus.coffeeshop.dao;

	import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.grandcircus.coffeeshop.Coffee;



@Repository
@Transactional
	public class CoffeeDaoHibernate {
	@PersistenceContext
	private EntityManager em;
		
		
		
		public List<Coffee> findAll(){
			return em.createQuery("FROM Coffee", Coffee.class).getResultList();
		}

	
	public void update(Coffee coffee) {
		em.merge(coffee);
	}
	
	public void delete(Long id) {
		// Deleting with Hibernate entity manager requires fetching a reference first.
		Coffee coffee = em.getReference(Coffee.class, id);
		em.remove(coffee);
	}

	}
	


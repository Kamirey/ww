package tracker.dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tracker.entity.AbstractEntity;
import tracker.entity.PersonEntity;

@Service @Primary
@Transactional
@Repository
public class TrackerDao {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void persist(AbstractEntity entity) {
		entityManager.persist(entity);
	}
	
	public void remove(AbstractEntity entity) {
		entityManager.remove(entity);
	}
	
	public void update(AbstractEntity entity) {
		entityManager.merge(entity);
	}

	public PersonEntity deletePerson(UUID personId) {
		PersonEntity person = getPersonById(personId);
		entityManager.remove(person);
		return person;
	}
	
	public PersonEntity getPersonById(UUID personId) {
		TypedQuery<PersonEntity> query = entityManager.createQuery("SELECT p FROM PersonEntity p WHERE p.id=:personId", PersonEntity.class);
		query.setParameter("personId", personId);
		return query.getSingleResult();
	}
	
	public List<PersonEntity> getPersons() {
		TypedQuery<PersonEntity> query = entityManager.createQuery("SELECT p FROM PersonEntity p", PersonEntity.class);
		return query.getResultList();
	}
}

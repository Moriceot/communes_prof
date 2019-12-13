package com.formation.communes.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.formation.communes.entity.Commune;

@Singleton
public class CommuneDao {
	private static final Logger LOG = Logger.getLogger("communes");
	@PersistenceContext(name="communes") private EntityManager em;
	
	public Commune getCommuneById(long id) {
		LOG.info("id : "+id);
		return em.find(Commune.class, id);
	}
	
	public List<Commune> getCommunesByCodePostal(String cp){
		LOG.info("cp : "+cp);
		return em.createNamedQuery("Commune.findByCodePostal",Commune.class)
					.setParameter("cp", cp+"%")
					.getResultList();
	}
	
	public List<String> getAllRegions(){
		return em.createNamedQuery("Commune.regions",String.class).getResultList();
	}
	
	// Attention ne fonctionne pas en l'état
	// car nous travaillons sur une vue reliée
	// à plusieurs tables
	public void save(Commune commune) {
		em.persist(commune);
	}

}

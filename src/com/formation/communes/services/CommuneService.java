package com.formation.communes.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import com.formation.communes.dao.CommuneDao;
import com.formation.communes.entity.Commune;

@Singleton
public class CommuneService {
	@EJB private CommuneDao dao;
	
	public Commune getCommune(long id) {
		return dao.getCommuneById(id);
	}
	
	public List<Commune> getCommuneByCodePostal(String cp){
		return dao.getCommunesByCodePostal(cp);
	}
	
	public List<String> getRegions(){
		return dao.getAllRegions();
	}
	
	public long save(Commune commune) {
		dao.save(commune);
		return commune.getId();
	}

}

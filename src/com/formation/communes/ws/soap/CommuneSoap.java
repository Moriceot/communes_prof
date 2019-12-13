package com.formation.communes.ws.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.formation.communes.entity.Commune;
import com.formation.communes.services.CommuneService;

@WebService
public class CommuneSoap {
	@EJB private CommuneService service;
	
	public Commune findById(@WebParam(name = "id") long id) {
		return service.getCommune(id);
	}
	
	public Commune[] getCommunesByCodepostal(@WebParam(name = "cp") String cp) {
		List<Commune> communes = service.getCommuneByCodePostal(cp);
		return communes.toArray(new Commune[communes.size()]);
	}

	
	public String[] getRegions() {
		return service.getRegions().toArray(new String[0]);
	}


}

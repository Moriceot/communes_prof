package com.formation.communes.ws.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.formation.communes.entity.Commune;
import com.formation.communes.services.CommuneService;

@Path("/commune")
public class CommuneRest {
	
	@EJB private CommuneService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/id/{id}")
	public Commune getCommuneById(@PathParam("id") long id) {
		return service.getCommune(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/cp/{cp}")
	public List<Commune> getCommunesByCodePostal(@PathParam("cp") String cp){
		return service.getCommuneByCodePostal(cp);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/save")
	public long saveCommune(Commune commune) {
		return service.save(commune);
	}

}

package dev.ilotte.code.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ilotte.code.dao.AdminDAO;
import dev.ilotte.code.model.Admin;

@Path("/admin")
public class AdminResource {

	AdminDAO dao = new AdminDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Admin> findAll() {
		return dao.findAll();
	}

	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Admin findById(@PathParam("id") String id) {
		return dao.findById(Integer.parseInt(id));
	}
	
	
}

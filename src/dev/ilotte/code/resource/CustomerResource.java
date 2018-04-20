package dev.ilotte.code.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ilotte.code.dao.CustomerDAO;
import dev.ilotte.code.model.Customer;

@Path("/customer")
public class CustomerResource {


	CustomerDAO dao = new CustomerDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Customer> findAll() {
		return dao.findAll();
	}

	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Customer findById(@PathParam("id") String id) {
		return dao.findById(Integer.parseInt(id));
	}
	
	


}

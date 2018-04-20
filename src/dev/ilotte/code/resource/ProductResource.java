package dev.ilotte.code.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ilotte.code.dao.ProductDAO;
import dev.ilotte.code.model.Product;

@Path("/products")
public class ProductResource {

	ProductDAO dao = new ProductDAO();
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Product> findAll() {
		return dao.findAll();
	}

	@GET @Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Product findById(@PathParam("id") String id) {
		return dao.findById(Integer.parseInt(id));
	}
	
	
	@GET @Path("/validate/{idproduct}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Boolean checkStock(@PathParam("idproduct") String idproduct) {
		
		Boolean status = false;
        
         Product prod = (Product) dao.checkStock(Integer.parseInt(idproduct));
         if(prod != null){
        	 status = true;
         }
         
        return status;
 
	}
	
	
}

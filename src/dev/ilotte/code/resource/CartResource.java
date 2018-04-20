package dev.ilotte.code.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dev.ilotte.code.dao.OrderDAO;
import dev.ilotte.code.model.Cart;
import dev.ilotte.code.model.Checkout;
import dev.ilotte.code.model.Order;
import dev.ilotte.code.model.PaymentMethod;

@Path("/cart")
public class CartResource{
	OrderDAO dao = new OrderDAO();
	
	@GET
	@Path("/status")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Cart findAll() {
		return dao.cartStatus();
	}
	
	@GET @Path("/add/{idcust}/{idproduct}/{quantity}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Order addOrder(@PathParam("idcust") String idCust, @PathParam("idproduct") String idProduct,@PathParam("quantity") String quantity) {
		Order order=  dao.addOrder(Integer.parseInt(idCust),Integer.parseInt(idProduct),Integer.parseInt(quantity));
		return order;
	}
	
	@GET @Path("/remove/{idcust}/{idproduct}/{quantity}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Order removeOrder(@PathParam("idcust") String idCust, @PathParam("idproduct") String idProduct,@PathParam("quantity") String quantity) {
		Order order=  dao.removeOrder(Integer.parseInt(idCust),Integer.parseInt(idProduct),Integer.parseInt(quantity));
		return order;
	}
	
	@GET
	@Path("/checkout")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<PaymentMethod> paymentMethod() {
		return dao.getPaymentMethod();
	}
	
	@GET @Path("/checkout/{paymentmethod}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Checkout checkout(@PathParam("paymentmethod") String paymentmethod) {
		return dao.cartCheckOut(paymentmethod);
	}
	
	
	
}

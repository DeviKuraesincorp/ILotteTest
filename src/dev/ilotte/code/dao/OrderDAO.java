package dev.ilotte.code.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.jersey.api.client.Client;

import dev.ilotte.code.model.Cart;
import dev.ilotte.code.model.Checkout;
import dev.ilotte.code.model.Customer;
import dev.ilotte.code.model.Order;
import dev.ilotte.code.model.PaymentMethod;
import dev.ilotte.code.model.Product;

/**
 * @author Devi Yanti K
 */
public class OrderDAO {
	ProductDAO productDao = new ProductDAO();
	CustomerDAO customerDao =  new CustomerDAO();
	
	public Cart cartStatus() {
		
		Cart cart = new Cart();
		cart = (Cart) checkCart();
		if(cart == null){
			cart = new Cart();
			cart.setOrderList(new ArrayList());
			cart.setTotalAmount(new BigDecimal(0));
		}
		return cart;
	}
	
	public Order addOrder(int idCust,int idProd, int quantity) {
		// TODO Auto-generated method stub		
		Order order = new Order();
		order.setId((int) (System.currentTimeMillis() & 0xfffffff));
		Product prod = new Product();
		prod = productDao.findById(idProd);
		Customer cust = new Customer();
		cust = customerDao.findById(idCust);
		order.setCustomer(cust);
		Date today = new Date();
		order.setOrderDate(today);
		
		//cek cart status
		Order lastOrder = (Order) searchList(idCust, idProd);
		if(lastOrder != null){
			int quantityLastOrder = lastOrder.getOrderQuantity();
			order.setOrderQuantity(quantity+quantityLastOrder);
		}else{
			order.setOrderQuantity(quantity);
		}
		int currentQuantity = order.getOrderQuantity();
		
		BigDecimal price = prod.getPrice();
		BigDecimal quanty = new BigDecimal(currentQuantity);
		BigDecimal resultPrice = price.multiply(quanty);
		order.setPrice(resultPrice);
		
		//Add to Cart
		addCart(order);
		
		return order;
	}
	
	public Order removeOrder(int idCust,int idProd, int quantity) {
		// TODO Auto-generated method stub		
		Order order = new Order();
		order.setId((int) (System.currentTimeMillis() & 0xfffffff));
		Product prod = new Product();
		prod = productDao.findById(idProd);
		Customer cust = new Customer();
		cust.setId(idCust);
		order.setCustomer(cust);
		Date today = new Date();
		order.setOrderDate(today);
		
		//cek cart status
		Order lastOrder = (Order) searchList(idCust, idProd);
		if(lastOrder != null){
			int quantityLastOrder = lastOrder.getOrderQuantity();
			order.setOrderQuantity(quantityLastOrder-quantity);
		}
		
		int currentQuantity = order.getOrderQuantity();
		
		BigDecimal price = prod.getPrice();
		BigDecimal quanty = new BigDecimal(currentQuantity);
		BigDecimal resultPrice = price.multiply(quanty);
		order.setPrice(resultPrice);
		
		return order;
	}
	
	public Order searchList(int idCust, int idProduct){
		Order myOrder = new Order();
    	Cart cart = cartStatus();
    	if(cart !=null){
	    	List<Order> list = cart.getOrderList();
	    	for(int i=0; i<list.size(); i++){
	    		Order order = (Order) list.get(i);
	    		int myid = (int) order.getProduct().getId();
	    		int myidProduct = (int) order.getCustomer().getId();
	    		if(myid == idCust && myidProduct == idProduct){
		    		myOrder = (Order) list.get(i);
	    		}
	    	}
    	}
        return myOrder;
	}

	public void addCart(Order order) {
		//Order myOrder = searchList(order.getCustomer().getId(), order.getProduct().getId());
		List myOrderList = new ArrayList();
		myOrderList.add(order);
		Cart cart = new Cart();
		cart.setId((int) (System.currentTimeMillis() & 0xfffffff));
		cart.setOrderList(myOrderList);
		cart.setTotalAmount(order.getPrice());
		
		Client c = Client.create();
		c.getProperties().put("Cart", cart);
		
	}
	
	public Cart checkCart() {
		Cart cart = new Cart();
		cart.setId(12345678);
		
		List<Order> orderList = new ArrayList<Order>();
		Order order = new Order();
		order.setId((int) (System.currentTimeMillis() & 0xfffffff));
		Customer customer = new Customer(); 
		customer.setId(432167);
		order.setCustomer(customer);
		Date today = new Date();
		order.setOrderDate(today);
		Product prod = new Product();
		prod = productDao.findById(12345);
		order.setProduct(prod);
		order.setOrderQuantity(2);
		BigDecimal price = prod.getPrice();
		BigDecimal quanty = new BigDecimal(order.getOrderQuantity());
		BigDecimal resultPrice = price.multiply(quanty);
		order.setPrice(resultPrice);
		
		orderList.add(order);
		cart.setOrderList(orderList);
		
		cart.setTotalAmount(resultPrice);
		return cart;
	}

	public Checkout cartCheckOut(String paymentMethod) {
		// TODO Auto-generated method stub
		//getPaymentMethod
		List paymentMethodList= getPaymentMethod();
		PaymentMethod paymentMethod2 = new PaymentMethod();
		for(int i=0;i<paymentMethodList.size();i++){
			paymentMethod2 = (PaymentMethod) paymentMethodList.get(i);
			if(paymentMethod2.getId().equals(paymentMethod)){
				
			}
		}
		//cek
		Checkout checkout = new Checkout();
		checkout.setPaymentMethod(paymentMethod2);
		return null;
	}

	public List<PaymentMethod> getPaymentMethod() {
		// TODO Auto-generated method stub
		List<PaymentMethod> list =new ArrayList<PaymentMethod>();
		PaymentMethod paymeth = new PaymentMethod();
		paymeth.setId("cc");
		paymeth.setMethod("Credit Card");
		list.add(paymeth);
		
		PaymentMethod paymeth2 = new PaymentMethod();
		paymeth2.setId("tf");
		paymeth2.setMethod("Transfer");
		list.add(paymeth2);
		
		return list;
	}
	
	
}

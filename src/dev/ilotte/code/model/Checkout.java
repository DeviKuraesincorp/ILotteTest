package dev.ilotte.code.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Devi YK
 */
@XmlRootElement
public class Checkout {	
	private PaymentMethod paymentMethod;
	
	private String address;


	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}

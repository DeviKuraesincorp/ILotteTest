package dev.ilotte.code.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Devi YK
 */
@XmlRootElement
public class PaymentMethod {
	
	private String id;
	
	private String method;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	
	
	

}

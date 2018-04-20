package dev.ilotte.code.model;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author Devi YK
 */
@XmlRootElement
public class Categories {
	private int id;
	
	private String categoryName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Categories(int id) {
		super();
		this.id = id;
	}

	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

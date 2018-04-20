package dev.ilotte.code.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import dev.ilotte.code.model.Categories;
import dev.ilotte.code.model.Product;

/**
 * @author Devi Yanti K
 */
public class ProductDAO {

    public List<Product> findAll() {
    	List<Product> list = new ArrayList<Product>();
        Product prod= new Product();
        prod.setId(12345);
        prod.setProductName("Sony a6000");
        prod.setBrand("Sony");
        prod.setCurrency("IDR");
        prod.setPrice(new BigDecimal(7450000));
        prod.setQuantity(20);
        prod.setDescription("Camera mirrorless with high performance");
        prod.setCategories(new Categories(1));
        list.add(prod);
        
        Product prod2= new Product();
        prod2.setId(12345);
        prod2.setProductName("Canon M10");
        prod2.setBrand("Canon");
        prod2.setCurrency("IDR");
        prod2.setPrice(new BigDecimal(4320000));
        prod2.setQuantity(20);
        prod2.setDescription("Camera mirrorless with high performance an high quality");
        prod2.setCategories(new Categories(1));
        list.add(prod2);
        
        Product prod3= new Product();
        prod3.setId(12345);
        prod3.setProductName("iPhone X - 256Gb");
        prod3.setBrand("iphone");
        prod3.setCurrency("IDR");
        prod3.setPrice(new BigDecimal(16700000));
        prod3.setQuantity(20);
        prod3.setDescription("iphone 256 Gb storage. You can save anything in this phone");
        prod3.setCategories(new Categories(2));
        list.add(prod3);
        
        return list;
    }

        
    public Product findById(int id) {
    	Product myProduct = new Product();
    	List<Product> list = findAll();
    	for(int i=0; i<list.size(); i++){
    		Product prod = (Product) list.get(i);
    		int myid = (int) prod.getId();
    		if(myid == id){
	    		myProduct.setId(prod.getId());
	    		myProduct.setProductName(prod.getProductName());
	    		myProduct.setBrand(prod.getBrand());
	    		myProduct.setCurrency(prod.getCurrency());
	    		myProduct.setPrice(prod.getPrice());
	    		myProduct.setQuantity(prod.getQuantity());
	    		myProduct.setDescription(prod.getDescription());
    		}
    	}
    	
        return myProduct;
    }


	public Product checkStock(int idProduct) {
		// TODO Auto-generated method stub
		Product myProduct = new Product();
		Product prod = (Product) findById(idProduct);
		if(prod != null){
			if(prod.getQuantity() != 0){
				myProduct =  prod;
			}else{
				myProduct = null;
			}
		}
		return myProduct;
	}

   

   

   
    
}

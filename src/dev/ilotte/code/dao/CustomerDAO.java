package dev.ilotte.code.dao;

import java.util.ArrayList;
import java.util.List;

import dev.ilotte.code.model.Customer;


/**
 * @author Devi Yanti K
 */
public class CustomerDAO {

    public List<Customer> findAll() {
    	List<Customer> list = new ArrayList<Customer>();
    	Customer cust= new Customer();
        cust.setId(432167);
        cust.setFirstName("Jenifer");
        cust.setLastName("Lawrance");
        cust.setGender("Female");
        cust.setPhoneNumber("0657564765876");
        cust.setEmailAddress("jenifer.lawrance@gmail.com");
        cust.setAddress("Great tower 2 floor Kuningan street North Jakarta");
        list.add(cust);
       
    	Customer cust2= new Customer();
        cust2.setId(876568);
        cust2.setFirstName("Mark");
        cust2.setLastName("Tomson");
        cust2.setGender("Male");
        cust2.setPhoneNumber("065756477865");
        cust2.setEmailAddress("mark.t@gmail.com");
        cust2.setAddress("Green Apartement 5 floor Menteng South Jakarta");
        list.add(cust2);
        
        Customer cust3= new Customer();
        cust3.setId(234654);
        cust3.setFirstName("Sidney");
        cust3.setLastName("Kim");
        cust3.setGender("Female");
        cust3.setPhoneNumber("087656477865");
        cust3.setEmailAddress("sidney.kim@gmail.com");
        cust3.setAddress("Green Apartement 7 floor Menteng South Jakarta");
        list.add(cust3);
        
        return list;
    }   

    public Customer findById(int id) {
    	Customer myCustomer = new Customer();
    	List<Customer> list = findAll();
    	for(int i=0; i<list.size(); i++){
    		Customer cust = (Customer) list.get(i);
    		int myid = (int) cust.getId();
    		if(myid == id){
    			myCustomer.setId(cust.getId());
    			myCustomer.setFirstName(cust.getFirstName());
    			myCustomer.setLastName(cust.getLastName());
    			myCustomer.setGender(cust.getGender());
    			myCustomer.setPhoneNumber(cust.getPhoneNumber());
    			myCustomer.setEmailAddress(cust.getEmailAddress());
    			myCustomer.setAddress(cust.getAddress());
    		}
    	}
    	
        return myCustomer;
    }
}

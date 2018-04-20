package dev.ilotte.code.dao;

import java.util.ArrayList;
import java.util.List;

import dev.ilotte.code.model.Admin;
/**
 * @author Devi Yanti K
 */
public class AdminDAO {
	 public List<Admin> findAll() {
	    	List<Admin> list = new ArrayList<Admin>();
	    	Admin adm= new Admin();
	        adm.setId(432167);
	        adm.setFirstName("Jessica");
	        adm.setGender("Female");
	        adm.setPhoneNumber("0657564765876");
	        adm.setEmailAddress("jessica@gmail.com");
	        adm.setAddress("Great tower 2 floor Kuningan street North Jakarta");
	        adm.setRole("superAdmin");
	        list.add(adm);
	       
	        Admin adm2= new Admin();
	        adm2.setId(876568);
	        adm2.setFirstName("Robin");
	        adm2.setGender("Male");
	        adm2.setPhoneNumber("065756477865");
	        adm2.setEmailAddress("robin@gmail.com");
	        adm2.setAddress("Green Apartement 5 floor Menteng South Jakarta");
	        adm.setRole("superAdmin");
	        list.add(adm2);
	        
	        Admin adm3= new Admin();
	        adm3.setId(234654);
	        adm3.setFirstName("Song man se");
	        adm3.setGender("Male");
	        adm3.setPhoneNumber("087656477865");
	        adm3.setEmailAddress("manse.song@gmail.com");
	        adm3.setAddress("Green Apartement 7 floor Menteng South Jakarta");
	        adm.setRole("superAdmin");
	        list.add(adm3);
	        
	        return list;
	    }   
	 
	 public Admin findById(int id) {
	    	Admin myAdmin = new Admin();
	    	List<Admin> list = findAll();
	    	for(int i=0; i<list.size(); i++){
	    		Admin adm = (Admin) list.get(i);
	    		int myid = (int) adm.getId();
	    		if(myid == id){
	    			myAdmin.setId(adm.getId());
	    			myAdmin.setFirstName(adm.getFirstName());
	    			myAdmin.setGender(adm.getGender());
	    			myAdmin.setPhoneNumber(adm.getPhoneNumber());
	    			myAdmin.setEmailAddress(adm.getEmailAddress());
	    			myAdmin.setAddress(adm.getAddress());
	    			myAdmin.setRole(adm.getRole());
	    		}
	    	}
	    	
	        return myAdmin;
	    }
}

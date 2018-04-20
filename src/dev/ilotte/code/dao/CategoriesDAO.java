package dev.ilotte.code.dao;

import java.util.ArrayList;
import java.util.List;

import dev.ilotte.code.model.Categories;

/**
 * @author Devi Yanti K
 */
public class CategoriesDAO {

    public List<Categories> findAll() {
    	List<Categories> list = new ArrayList<Categories>();
    	Categories cat= new Categories();
        cat.setId(1);
        cat.setCategoryName("Camera");
        list.add(cat);
        
        Categories cat2= new Categories();
        cat2.setId(2);
        cat2.setCategoryName("Handphone");
        list.add(cat2);
        
        Categories cat3= new Categories();
        cat3.setId(3);
        cat3.setCategoryName("Television");
        list.add(cat3);
        
        Categories cat4= new Categories();
        cat4.setId(4);
        cat4.setCategoryName("AC");
        list.add(cat4);
        
        return list;
    }  
}

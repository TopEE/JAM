/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 *
 * @author mads
 */
@Entity
public class Jam implements Serializable {
    
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    private String type;
    
    private JAM_SIZE size;

    public Jam() {
    }
    
   
    
    

    public Jam(String type, JAM_SIZE size) {
        this.type = type;
        this.size = size;
    }
    
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JAM_SIZE getSize() {
        return size;
    }

    public void setSize(JAM_SIZE size) {
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}

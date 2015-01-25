/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam.common;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.sql.Timestamp;

/**
 *
 * @author 
 */
@Named
@RequestScoped
public class RequestCache {

    private Timestamp timeStamp;

    public Timestamp getTimeStamp() {
        if (timeStamp == null) {
            timeStamp = new Timestamp(System.currentTimeMillis());
        }
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam.common;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author 
 */
@Named
@RequestScoped
public class RequestCache {
    
    private Date timeStamp;

    public Date getTimeStamp() {
        if(timeStamp == null) timeStamp = new Date();
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    

    
}

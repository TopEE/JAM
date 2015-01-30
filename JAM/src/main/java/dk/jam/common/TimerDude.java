/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam.common;

import java.text.DateFormat;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author mads
 */
@Singleton
public class TimerDude {
    
    
    @Schedule(hour = "*", minute = "*", second = "0", persistent = true)
    public void doStuff() {
        System.out.println("Hello! Time is " + DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis())));
    }
    
    
}

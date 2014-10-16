/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author mads
 */
@Path("/jam")
public class JamResource {
    
    
    
    @GET
    public Jam getBestJam() {
        return new Jam("Strawberry", JAM_SIZE.Large);
    }
    
}

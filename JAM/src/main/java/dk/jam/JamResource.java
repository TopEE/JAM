/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author mads
 */
@Path("/jam")
@Stateless
public class JamResource {

    @Inject
    JamService JamService;
    
    @GET
    public Jam getBestJam() {
        return new Jam("Strawberry", JAM_SIZE.Large);
    }
    
}

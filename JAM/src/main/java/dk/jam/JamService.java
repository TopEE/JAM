/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mads
 */
@Stateless
public class JamService {

    @PersistenceContext(name = "prod")
    private EntityManager em;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    public Jam createJam(Jam jam) {
        em.persist(jam);
        
        return jam;
    }
    
    
    public List<Jam> getAllJam() {
        Query createQuery = em.createQuery("From Jam j", Jam.class);
        List resultList = createQuery.getResultList();
        return resultList;
    }
    
}

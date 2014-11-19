/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam.members.boundary;

import dk.jam.common.RequestCache;
import dk.jam.members.entity.ClubMember;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author mads
 */
@Stateless
public class MemberService {

    
    Logger tracer = Logger.getLogger(MemberService.class.getName());

    
    @Inject
    RequestCache rc;
    
    @PersistenceContext
    EntityManager em;
    
    
    public void addMember(ClubMember member) {
        tracer.log(Level.INFO, "Persisting member {0}", member);
        member.setLastUpdateTimestamp(rc.getTimeStamp());
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(MemberService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ClubMember m2 = new ClubMember("Copy of " + member.getName(), new Date());
        m2.setLastUpdateTimestamp(rc.getTimeStamp());
        em.persist(member);
        em.persist(m2);
    }
    
    public List<ClubMember> getAllMembers() {
        Query query = em.createQuery("Select m From ClubMember m");
        List resultList = query.getResultList();
        return resultList;
    }
}

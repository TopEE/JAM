/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam.members.boundary;

import dk.jam.members.entity.ClubMember;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mads
 */
@Path("members")
@Stateless
public class MemberResource {

    Logger log = Logger.getLogger(MemberResource.class.getName());

    @Inject
    MemberService memberService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClubMember> getAllMembers() {
        System.out.println("pling!");
        log.info("Pling pling!");
        return memberService.getAllMembers();
    }

}

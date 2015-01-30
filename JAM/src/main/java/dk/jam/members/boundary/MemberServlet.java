/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.jam.members.boundary;

import dk.jam.members.entity.ClubMember;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mads
 */
@WebServlet(name = "MemberServlet", urlPatterns = {"/MemberServlet", "/MS"})
public class MemberServlet extends HttpServlet {
    
    @Inject
    MemberService memberService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            ClubMember member = new ClubMember("Knud den store " + System.currentTimeMillis(), new Date());
            memberService.addMember(member);
            List<ClubMember> allMembers = memberService.getAllMembers();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MemberServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MemberServlet at " + request.getContextPath() + "</h1>");
            DateFormat dtf = DateFormat.getDateTimeInstance();
            out.println("<table><tr><th>Id</th><th>Name</th><th>Member Since</th><th>LastUpdateTimeStamp</th></tr>");
            for (ClubMember aMember : allMembers) {
                out.println("<tr><td>" + aMember.getId() + " </td><td>" + aMember.getName() + "</td><td>" + aMember.getMemberSince().getTime() + "</td><td>" + aMember.getLastUpdateTimestamp().getTime() + "</td></tr>");
            }
            
            out.println("</table><br>Antal Mambers = " + allMembers.size());
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

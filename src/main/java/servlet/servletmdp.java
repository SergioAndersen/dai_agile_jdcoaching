/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bd.bd;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.Utilisateur;

/**
 *
 * @author 21104333
 */
@WebServlet(name = "servletmdp", urlPatterns = {"/servletmdp"})
public class servletmdp extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd = null;
        HttpSession session = request.getSession(true);

        String ida = (String) session.getAttribute("id");

        out.println(ida);

        String mdpancien = request.getParameter("mdpancien");
        String mdpnouveau = request.getParameter("mdpnouveau");

        bd newbd = new bd();

        int x = newbd.ModifierMDP(ida, mdpnouveau);

        if (x == 0) {
            out.print("<script LANGAGE = 'JavaScript'>");
            out.print("alert('erreur de modification mot de passe');window.location='modifiermdptoclient.jsp'");
            out.println("</script>");

            rd = request.getRequestDispatcher("modifiermdptoclient.jsp");
            rd.forward(request, response);
        } else {

            out.print("<script LANGAGE = 'JavaScript'>");
            out.print("alert('Mot de passe bien modifier ! Votre nouveau mot de passe est : " + mdpnouveau + "');window.location='pageClient.jsp'");
            out.println("</script>");

            rd = request.getRequestDispatcher("pageClient.jsp");
            rd.forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletmdp.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletmdp.class.getName()).log(Level.SEVERE, null, ex);
        }
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

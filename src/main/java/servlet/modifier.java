/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bd.bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
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
 * @author evaba
 */
@WebServlet(name = "modifier", urlPatterns = {"/modifier"})
public class modifier extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        RequestDispatcher rd = null;
        HttpSession session = request.getSession(true);
        String mailmodif = (String) session.getAttribute("Utimodifff");

        /*Conexion à la base de données*/
        bd newbd = new bd();

        String statut = request.getParameter("select");
        String tel = request.getParameter("tel");
        Utilisateur u = newbd.userInfo(mailmodif);

        String statu = u.getStatutu();
        String tele = u.getTelu();
        if (!statu.equals(statut) || !tele.equals(tel)) {
            newbd.ModifierMessage(mailmodif, statut, tel);

            /*ouvrir la session*/
            session.setAttribute("mailmodif", mailmodif);
            session.setAttribute("statut", statut);
            session.setAttribute("tel", tel);

            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Réussir de modifier!!!');");
            out.println("</script>");

            rd = request.getRequestDispatcher("ResultModif.jsp");
            rd.forward(request, response);
        } else {

            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Vous n\\'avez rien modifier!!!');window.location='adminmodifstatutclient.jsp?email=" + mailmodif + "&submit=Modifier'");
            out.println("</script>");

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
            Logger.getLogger(modifier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(modifier.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(modifier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(modifier.class.getName()).log(Level.SEVERE, null, ex);
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

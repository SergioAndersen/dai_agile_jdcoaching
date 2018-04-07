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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.ProfilSportif;

/**
 *
 * @author 21104333
 */
@WebServlet(name = "ServletProfilSportif", urlPatterns = {"/ServletProfilSportif"})
public class ServletProfilSportif extends HttpServlet {

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

        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */
        RequestDispatcher rd = null;
        HttpSession session = request.getSession(true);
        String idu = (String) session.getAttribute("id");
        int codeu = Integer.parseInt(idu);

        /*Conexion à la base de données*/
        bd newbd = new bd();

        ProfilSportif psa = newbd.voirProfilSportif(codeu);
        String ta = psa.getTaille();
        String pa = psa.getPoids();
        String ha = psa.getHanche();
        String ca = psa.getCuisse();
        String ba = psa.getBras();
        String poia = psa.getPoitrine();

        String poitrine = request.getParameter("poitrine");

        String taille = request.getParameter("taille");

        String poids = request.getParameter("poids");

        String hanche = request.getParameter("hanche");

        String cuisse = request.getParameter("cuisse");

        String bras = request.getParameter("bras");

        if (!ta.equals(taille) || !pa.equals(poids) || !ca.equals(cuisse) || !ba.equals(bras) || !ha.equals(hanche) || !poia.equals(poitrine)) {

            ProfilSportif ps = new ProfilSportif(taille, poids, hanche, cuisse, bras, poitrine);

            newbd.saisirProfilSportif(ps, codeu);
            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Réussir à modifier!!!');window.location='pageClient.jsp'");
            out.println("</script>");

        } else {

            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Vous n\\'avez rien modifier!!!');window.location='profilSportif.jsp'");
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
            Logger.getLogger(ServletProfilSportif.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletProfilSportif.class.getName()).log(Level.SEVERE, null, ex);
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

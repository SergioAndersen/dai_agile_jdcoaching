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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import metier.Profil;
import metier.Programme;

/**
 *
 * @author wangziqi
 */
@WebServlet(name = "ServletCreerProgramme", urlPatterns = {"/ServletCreerProgramme"})
public class ServletCreerProgramme extends HttpServlet {

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
        RequestDispatcher rd = null;

        String titre = request.getParameter("titre");

        String description = request.getParameter("description");

        int codeProfilProgramme = Integer.parseInt(request.getParameter("ProfilProgramme"));

        int nbSeance = Integer.parseInt(request.getParameter("nbSeance"));

        bd newbd = new bd();
        int i = 0;

        out.println("test1");

        Programme pro = new Programme(-1, titre, description);
        i = newbd.SaisirProgramme(pro, codeProfilProgramme);

        out.println("test2");

        //recuperation du code du programme pour le metre en session ne marche pas  
        Programme progra;
        progra = newbd.recupProgramme(titre);

        HttpSession session = request.getSession(true);
        session.setAttribute("programme", progra);
        session.setAttribute("profilProgramme", request.getParameter("ProfilProgramme"));
        session.setAttribute("nbSeance", nbSeance);

        if (i == 0) {

            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Votre programme n'as pas été creer !!!');window.location='creationProgramme.jsp'");
            out.println("</script>");

            rd = request.getRequestDispatcher("creationProgramme.jsp");
            rd.forward(request, response);

        } else {

            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Votre programme as bien été creer !!!');window.location='creationProgramme.jsp'");
            out.println("</script>");

            rd = request.getRequestDispatcher("creationProgramme.jsp");
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
            Logger.getLogger(ServletCreerProgramme.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletCreerProgramme.class.getName()).log(Level.SEVERE, null, ex);
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

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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Profil;

/**
 *
 * @author evaba
 */
@WebServlet(name = "ajouterPro", urlPatterns = {"/ajouterPro"})
public class ajouterPro extends HttpServlet {

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

        //connexion à la bd
        bd unebd = new bd();
        ArrayList<Profil> lstPro = unebd.recuperationProfil();

        String nomp = request.getParameter("txtprof");
        Profil p = new Profil(nomp);
        if (!nomp.isEmpty() && !nomp.equals(" ")) {
            if (!lstPro.contains(p)) {
                //insérer un nouveau message dans bd
                unebd.ajouterProfil(nomp);
                //envoie vers confirmation.jsp
                out.println("<script LANGUAGE='JavaScript'>");
                out.println("alert('Vous avez bien ajouter le profil !!!');window.location='ajoutProf.jsp'");
                out.println("</script>");
            } else {
                out.println("<script LANGUAGE='JavaScript'>");
                out.println("alert('Vous avez déjà ajouté ce profil !!!');window.location='ajoutProf.jsp'");
                out.println("</script>");
            }
        } else {
            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Vous n\\'avez rien ajouter le profil !!!');window.location='ajoutProf.jsp'");
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
            Logger.getLogger(ajouterPro.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ajouterPro.class.getName()).log(Level.SEVERE, null, ex);
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

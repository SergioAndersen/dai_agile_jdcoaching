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
import metier.Utilisateur;

/**
 *
 * @author eunicerigo
 */
@WebServlet(name = "ServletInscriptionUtilisation", urlPatterns = {"/ServletInscriptionUtilisation"})
public class ServletInscriptionUtilisation extends HttpServlet {

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
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");

        String genre = request.getParameter("genre");

        String nom = request.getParameter("nom");

        String prenom = request.getParameter("prenom");

        Date dateinscri = null;

        try {
            dateinscri = formatDate.parse(request.getParameter("date"));
        } catch (ParseException ex) {
            Logger.getLogger(ServletInscriptionUtilisation.class.getName()).log(Level.SEVERE, null, ex);
        }

        String dateN = request.getParameter("date");

        String tel = request.getParameter("tel");

        String mail1 = request.getParameter("mail1");

        String mdp = request.getParameter("mdp");

        int obj = Integer.parseInt(request.getParameter("obj"));

        String type = request.getParameter("type");

        //création d'un objet messageDor msgDor
        Utilisateur ut1 = new Utilisateur(nom, prenom, mail1, mdp, genre, dateN, tel, "CLIENT", dateinscri, "POTENTIEL");

        //connexion à la bd
        bd newbd = new bd();

        int i;

        //insérer un nouveau message dans bd si admin ou si client
        if (type == null) {
            i = newbd.inscrirebaseutilisateur(ut1);

        } else {
            i = newbd.inscrirebaseutilisateurAdmin(ut1);
        }

        String url;

        if (i == 0) {

            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Vous etes deja inscrit !!!');window.location='inscription.jsp'");
            out.println("</script>");

        } else {

            if (type == null) {

                out.println("<script LANGUAGE='JavaScript'>");
                out.println("alert('BIEN INSCRIT ! Vous allez etre rediriger vers la page de connection ');window.location='connection.jsp'");
                out.println("</script>");

                rd = request.getRequestDispatcher("connection.jsp");
                rd.forward(request, response);

            } else {

                out.println("<script LANGUAGE='JavaScript'>");
                out.println("alert('Vous avez bien inscrit le client !!!');window.location='pageadmin.jsp'");
                out.println("</script>");

                rd = request.getRequestDispatcher("pageadmin.jsp");
                rd.forward(request, response);

            }

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

////        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
////
////        
////        String genre = request.getParameter("genre");
////        String nom = request.getParameter("nom");
////        String prenom = request.getParameter("prenom");
////        Date datenaissance = null;    
////        try {
////            datenaissance = formatDate.parse(request.getParameter("datenaissance"));
////        } catch (ParseException ex) {
////            Logger.getLogger(ServletInscriptionUtilisation.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        String tel = request.getParameter("tel");
////        String mail1 = request.getParameter("mail1");
////        String mdp = request.getParameter("mdp");
////        String obj = request.getParameter("obj");
////
////        
////       Utilisateur ut1  = new Utilisateur(nom,prenom,mail1,mdp,genre,datenaissance,tel,"CLIENT",datenaissance,"Potentiel");
////
////       bd newbd = new bd();
////       
////        int i = newbd.inscrirebaseutilisateur(ut1) ;
////       
////        RequestDispatcher rd;
////
////
////     String url ;
////            if (i == 0) {
////                
////                rd = request.getRequestDispatcher("testEunice.html");// il faut changer adresse
////                 rd.forward(request, response);
////              
////            }
////             
////            else
////            {
////               rd = request.getRequestDispatcher("testEunice2.html");// il faut changer adresse
////                 rd.forward(request, response);
////            }
////
////
////
////
////       
////
////
////
////
////        
        } catch (SQLException ex) {
            Logger.getLogger(ServletInscriptionUtilisation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletInscriptionUtilisation.class.getName()).log(Level.SEVERE, null, ex);
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

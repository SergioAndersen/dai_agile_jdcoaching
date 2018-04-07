/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bd.bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Utilisateur;

/**
 *
 * @author Sergio
 */
public class ServletListerClientStatut extends HttpServlet {

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
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter out = response.getWriter();
            bd bd = new bd();
            Date max = null;
            String statut = request.getParameter("statut");
            ArrayList<Utilisateur> listUser = bd.obtenirClientSelonStatut(statut);
            //Recherche de la dernière date à laquelle un utilisateur s'est inscrit
            for(Utilisateur user : listUser) {
                if (max == null) {
                    max = user.getDateinscri();
                } else {
                    if (max.before(user.getDateinscri())) {
                        max = user.getDateinscri();
                    }
                }
            }
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<donnees>");
            for (Utilisateur user : listUser) {
                if(max.equals(user.getDateinscri())) {
                    out.println("<utilisateur>" + user.getNomu() + "|"
                        + user.getPrenomu() + "|" + user.getStatutu() + "|"
                        + user.getStringDate(user.getDateinscri()) + "|" 
                        + user.getMailu() + "|last" + "</utilisateur>");
                } else {
                    out.println("<utilisateur>" + user.getNomu() + "|"
                        + user.getPrenomu() + "|" + user.getStatutu() + "|"
                        + user.getStringDate(user.getDateinscri()) + "|" 
                        + user.getMailu() + "|not" + "</utilisateur>");
                }
            }
            out.println("</donnees>");
        } catch (IOException ex) {
            System.out.println(" Erreur" + ex.getMessage());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bd.bd;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eunicerigo
 */
public class ServletCreaEx extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */

        RequestDispatcher rd = null;
        String lib = request.getParameter("lib");
        String objEx = request.getParameter("objEx");
        String vid = request.getParameter("vid");
        String dureeEx = request.getParameter("dureeEx");
        String dureeRecup = request.getParameter("dureeRecup");
        String repetMax = request.getParameter("repetMax");
        String image = request.getParameter("image");
        String descEx = request.getParameter("descEx");
        int dureeExo = Integer.parseInt(request.getParameter("dureeEx"));
        int dureeRecuper = Integer.parseInt(request.getParameter("dureeRecup"));
        int nbrepe = Integer.parseInt(request.getParameter("nbrepe"));

        bd newbd = new bd();

        int i = 0;

        i = newbd.creerExercice(lib, descEx, vid, objEx, dureeExo, dureeRecuper, nbrepe);

        String url;

        if (i == 0) {

            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Votre exercice n'as pas été creer !!!');window.location='creationExercice.jsp'");
            out.println("</script>");

            rd = request.getRequestDispatcher("creationExercice.jsp");
            rd.forward(request, response);

        } else {

            out.println("<script LANGUAGE='JavaScript'>");
            out.println("alert('Votre exercice as bien été creer !!!');window.location='pageCoach.jsp'");
            out.println("</script>");

            rd = request.getRequestDispatcher("pageCoach.jsp");
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

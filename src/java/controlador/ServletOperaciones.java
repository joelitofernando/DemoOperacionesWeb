/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Datos;
import modelo.Procesos;

/**
 *
 * @author Rolando
 */
@WebServlet(name = "ServletOperaciones", urlPatterns = {"/ServletOperaciones"})
public class ServletOperaciones extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Datos datos = new Datos();
            Procesos p = new Procesos();
            
            datos.setCantidad(Double.parseDouble(request.getParameter("txtCantidad")));
            datos.setPrecio(Double.parseDouble(request.getParameter("txtPrecio")));

            int tipo = Integer.parseInt(request.getParameter("cmbTipoPago"));
            double resultado = 0.0;

            if (tipo == 1) {
                resultado = p.Contado(datos);
            } else if (tipo == 2) {
                resultado = p.Tarjeta(datos);
            } 

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletOperaciones</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>RESULTADO</h1>");
            out.println("El resultado es: " + resultado);
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

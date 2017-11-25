/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Dell
 */
@WebServlet(name = "addMoney", urlPatterns = {"/addMoney"})
public class addMoney extends HttpServlet {

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
	    /* TODO output your page here. You may use following sample code. */
//	    Getting input
	    String money = request.getParameter("money");
	    Cookie[] cookies = request.getCookies();
//	    Security check
	    if (!money.contains("<") && !money.contains(">") && !money.contains("-") && !money.isEmpty()) {
		try {

		    for (int i = 0; i < (cookies.length - 1); i++) {
			if (cookies[i].getName().equals("matrixNumber")) {
			    String id = cookies[i].getValue();
			    Session session = HibernateUtil.createSessionFactory().openSession();
			    String sqlQuery = "update user set money=" + money + " where id=" + id;
			    session.createSQLQuery(sqlQuery).executeUpdate();
			    if (session.isOpen()) {
				session.close();
			    }
			    response.sendRedirect("Homepage");
			}
		    }
		} catch (Exception e) {
		    response.sendRedirect("databaseFail.jsp");
		}
	    } else {
		response.sendRedirect("badInsert.jsp");
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

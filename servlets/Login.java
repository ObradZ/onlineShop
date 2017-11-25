/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HibernateUtil;
import model.User;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Dell
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
	    try {
//	    Creating session
		HttpSession sesija = request.getSession();
		sesija.setAttribute("user", "false");

//	    Getting parameters from Login.jsp
		String username = request.getParameter("username");
		String password = request.getParameter("password");

//	    Security check for username and password,opening HBM session
		Session session = HibernateUtil.createSessionFactory().openSession();
		if (!username.contains("<") && !username.contains(">") && !username.contains("-") && !username.isEmpty() && !password.isEmpty() && !password.contains("<") && !password.contains(">") && !password.contains("-")) {

//	    Insert is ok, Authentication check!
		    try {

			SQLQuery query = session.createSQLQuery("select * from user where name='" + username + "' and password=password('" + password + "')");
			query.addEntity(User.class);
			List<User> users = query.list();
			if (!users.isEmpty()) {
//	    Authentication is ok! Homepage CHAAARGEEE!		
			    User user = users.get(0);
			    sesija.setAttribute("user", "1_true");
			    Cookie cookie = new Cookie("name", user.getName());
			    String id = String.valueOf(user.getId());
			    Cookie cookie2 = new Cookie("matrixNumber", id);
			    response.addCookie(cookie);
			    response.addCookie(cookie2);
			    response.sendRedirect("Homepage");

			} //		    Invalid username or password
			else {
			    response.sendRedirect("invalidUOP.jsp");
			}
		    } catch (Exception e) {
			response.sendRedirect("databaseFail.jsp");
		    }

//	    Message for failed security check.
		} else {
		    response.sendRedirect("badInsert.jsp");
		}
		if (session.isOpen()) {
		    session.close();
		}
	    } catch (Exception ex) {
		response.sendRedirect("databaseFail.jsp");
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

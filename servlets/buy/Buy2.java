/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.buy;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ActionFigure;
import model.HibernateUtil;
import model.User;
import org.hibernate.Session;

/**
 *
 * @author Dell
 */
@WebServlet(name = "Buy2", urlPatterns = {"/Buy2"})
public class Buy2 extends HttpServlet {

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
//	    Taking paremeters
	    String priceS = request.getParameter("price");
	    String stackS = request.getParameter("stack");
	    String aId = request.getParameter("id");
	    Cookie[] cookies = request.getCookies();
//	    Security check
	    if (!stackS.contains("<") && !stackS.contains(">") && !stackS.contains("-") && !stackS.isEmpty()) {
		try {
		    short afid = Short.parseShort(aId);
		    Session session = HibernateUtil.createSessionFactory().openSession();
		    ActionFigure af = (ActionFigure) session.get(ActionFigure.class, afid);
		    for (int i = 0; i < cookies.length - 1; i++) {
			if (cookies[i].getName().equals("matrixNumber")) {
			    String idU = cookies[i].getValue();
			    int id = Integer.parseInt(idU);
			    short stack = Short.parseShort(stackS);
			    int price = Integer.parseInt(priceS);
			    
			    User user = (User) session.get(User.class, id);
			    int cost = price * stack;
			    int moneyUpdate = user.getMoney() - cost;
			    short stackUpdate = (short) (af.getStack() - stack);
			    if ((af.getStack() - stack) >= 0 && moneyUpdate >= 0) {
				user.setMoney(moneyUpdate);
				af.setStack(stackUpdate);
				session.update(user);
				session.update(af);
				session.flush();
				if (session.isOpen()) {
				    session.close();
				}
				response.sendRedirect("congratulations.jsp");
			    } else {
				response.sendRedirect("noMoney.jsp");
			    }
			}
			
		    }
		    if (session.isOpen()) {
			session.close();
		    }
		} catch (Exception e) {
		    response.sendRedirect("badInsert.jsp");
//		    out.print(e.getMessage());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.products;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.ActionFigure;
import model.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Dell
 */
@WebServlet(name = "Products", urlPatterns = {"/Products"})
@MultipartConfig
public class Products extends HttpServlet {

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

//	    Getting parameters from products.jsp
	    String name = request.getParameter("name");
	    String widthS = request.getParameter("width");
	    String heightS = request.getParameter("height");
	    String category = request.getParameter("category");
	    String priceS = request.getParameter("price");
	    Part picture = request.getPart("image");
	    String stackS = request.getParameter("stack");

//	    Input and Security check
	    try {
		if (!name.contains("<") && !name.contains(">") && !name.contains("-") && !name.isEmpty() && !widthS.contains(">") && !widthS.contains("<") && !heightS.contains("<") && !heightS.contains(">")) {
		    int width = Integer.parseInt(widthS);
		    int height = Integer.parseInt(heightS);
		    int price = Integer.parseInt(priceS);
		    short stack = Short.parseShort(stackS);
		    short categoryID = Short.parseShort(category);

//	    Image reading and writting
		    try {
			String folderName = "matrixShopImages";
			String pictureName = System.currentTimeMillis() + picture.getSubmittedFileName();
			InputStream iStream = picture.getInputStream();

//		Creating dir if needed		
			File file = new File(request.getServletContext().getRealPath("/") + folderName);
			if (!file.exists()) {
			    file.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + "/" + pictureName);
			int b;
			while ((b = iStream.read()) != -1) {
			    fos.write(b);
			}
			fos.flush();
			fos.close();
			iStream.close();

//	    Creating hbm session, creating product and saving it	
			Session session = HibernateUtil.createSessionFactory().openSession();
			ActionFigure actionF = new ActionFigure();
			actionF.setName(name);
			actionF.setWidth(width);
			actionF.setHeight(height);
			actionF.setImage(folderName + "/" + pictureName);
			actionF.setCategoryid(categoryID);
			actionF.setPrice(price);
			actionF.setStack(stack);
			session.save(actionF);
			if (session.isOpen()) {
			    session.close();
			}
//	    Evetything went cool , redirecting to homepage.jsp	
			response.sendRedirect("Homepage");

//	    Image read or write fail()	
		    } catch (Exception e) {
			out.print(e.getMessage());
		    }

//	    Input fail(55)
		} else {
		    response.sendRedirect("badInsert.jsp");
		}

//	    Failed input and security check(54)
	    } catch (Exception ex) {
		out.print(ex.getMessage());
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

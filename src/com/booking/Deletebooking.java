package com.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carRentalAdminResources.Addcar;

/**
 * Servlet implementation class Deletebooking
 */
@WebServlet("/Deletebooking")
public class Deletebooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deletebooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    static ArrayList<Addcar> list;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Integer id=Integer.parseInt(request.getParameter("name"));
		 
		 
	     try {
			String carname=BookingDb.cancelbooking(id);
			System.out.print(carname);
			BookingServlet.minimum();
			ManageCarAvailability.updateCarAvailability(carname,"cancel"); 
			
			 HttpSession sess=request.getSession();
			 sess.setAttribute("alert","alert");
			 response.sendRedirect("membersContent/profilepage.jsp");
		 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
	}

}

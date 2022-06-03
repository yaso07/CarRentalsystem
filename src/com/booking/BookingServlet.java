package com.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.carRentalAdminResources.Addcar;
import com.carRentalAdminResources.ViewCarDb;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String vehilce=request.getParameter("name");
	 
	 
	 
		try {
			Addcar car = ViewCarDb.getcardetails(vehilce);
			  
			   HttpSession session=request.getSession();
			   session.setAttribute("carname",car.getVehicleBrand());
			   session.setAttribute("price",car.getPrice());
			   session.setAttribute("type", car.getType());
			   response.sendRedirect("carbooking.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	bookingdetails book;
	public static void minimum()
	{
		bookingdetails.maximumbooks--;
		
		if(bookingdetails.maximumbooks<0)
		{
			bookingdetails.maximumbooks=0;
		}
	      
	}
	static ArrayList<Addcar> list;
	protected void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
		
		HttpSession session=request.getSession();
		String carname=(String)session.getAttribute("carname");
		 
		 book=new bookingdetails();
		 book.setUsername((String)session.getAttribute("name"));
		 book.setCarname((String)session.getAttribute("carname"));
		 book.setType((String)session.getAttribute("type"));
		 book.setPickdate((String)session.getAttribute("pickup"));
		 book.setDropdate((String)session.getAttribute("drop"));
		 book.setLocation((String)session.getAttribute("location")); 
		 book.setTotalcost((long)session.getAttribute("totalcost"));
		 book.setTotaldays((long)session.getAttribute("totaldays"));
		 
		  
		 
		 try {
			 if(book.maximumbooks<2)
			 {
			    BookingDb.book(book);
			    book.maximumbooks++;
			   
			    ManageCarAvailability.updateCarAvailability(carname);
				  HttpSession sess=request.getSession();
				  sess.setAttribute("alert","alert");
				 res.sendRedirect("CarRentalViewpage.jsp");
			 

			 }
			 else
			 {
				 PrintWriter out=res.getWriter();
				 out.println("<script>\r\n"
				 		+ "\r\n"
				 		+ "        alert(\"booking limits reached\");\r\n"
				 		+ "    </script>");
				  book.maximumbooks=0;
				  HttpSession sess=request.getSession();
				  sess.setAttribute("alert","alert");
				  res.sendRedirect("UserFirstpage.jsp");
			 }
			
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		res.setContentType("text/html");
		
		
	
	}

}

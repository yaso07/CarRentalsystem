package com.authentication;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDetailsServelt
 */
@WebServlet("/UserDetailsServelt")
public class UserDetailsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   
	          
	}

 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String firstname=req.getParameter("firstname");
	        String lastname=req.getParameter("lastname");
	        
	        String email=req.getParameter("email");
	        String address1=req.getParameter("address1");
	        String address2=req.getParameter("address2");
	        String country=req.getParameter("country");
	        String state=req.getParameter("state");
	        Integer pincode=Integer.parseInt(req.getParameter("pincode"));
	        String mobile=req.getParameter("mobile");
	        userdetails details=new userdetails();
	       
	      
	       details.setFirstname(firstname);
	       details.setLastname(lastname);
	       details.setMobile(mobile);
	       details.setEmail(email);
	       details.setAddress1(address1);
	       details.setAddress2(address2);
	       details.setCountry(country);
	       details.setState(state);
	       details.setPincode(pincode);
	       HttpSession session=req.getSession();
	     
	       details.setPassword((String)session.getAttribute("password"));
	       details.setUsername((String)session.getAttribute("username"));
	       
	    try {
	    	
			UserDetailsDb.adduserdetails(details);
			
		} catch (ClassNotFoundException | SQLException e) {
			 
			e.printStackTrace();
		}
	        
	     res.sendRedirect("userlogin.jsp");
	    
	}


}

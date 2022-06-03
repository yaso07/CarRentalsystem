package com.booking;
import java.util.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.http.parser.Cookie;

/**
 * Servlet implementation class GetBookingDuration
 */
@WebServlet("/GetBookingDuration")
public class GetBookingDuration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBookingDuration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String location=req.getParameter("options");
		String startdate=req.getParameter("start");
		String enddate=req.getParameter("end");
		
		
        
		LocalDate dateBefore = LocalDate.parse(startdate);
		LocalDate dateAfter = LocalDate.parse(enddate);
		
        long noOfDays = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		HttpSession session=req.getSession();
		 
	    System.out.println(noOfDays);
		
		session.setAttribute("pickupdate",startdate);
		session.setAttribute("dropdate",enddate);
		session.setAttribute("location",location);
		session.setAttribute("totaldays",noOfDays);
	     
        res.sendRedirect("CarRentalViewpage.jsp");
        
		
	}

}

package com.carRentalAdminResources;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCarServlet
 */
@WebServlet("/EditCarServlet")
public class EditCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String temp_vehicle=req.getParameter("name");
		 String vehicle=req.getParameter("vehicle");
		 Long price=(long)Integer.parseInt(req.getParameter("price"));
		 String type=req.getParameter("options");
		  Integer noOfCars=Integer.parseInt(req.getParameter("available"));
		 
		 Addcar car=new Addcar();
		 car.setVehicleBrands(vehicle);
		 car.setPrice(price);
		 car.setType(type);
		  car.setNoOfCars(noOfCars);
		 
		 
		 try {
			EditDeleteView.edit(car,temp_vehicle);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 res.sendRedirect("EditDeleteCar.jsp");
		 
		 
	}
	 


}

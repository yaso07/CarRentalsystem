package com.carRentalAdminResources;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddcarServlet
 */
@WebServlet("/AddcarServlet")
public class AddcarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddcarServlet() {
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
		// TODO Auto-generated method stub

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
			AddCarDb.addCarDb(car);
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

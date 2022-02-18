package servletVehicle;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;
import service.VehicleService;

/**
 * Servlet implementation class addVehicle
 */
@WebServlet("/add-vehicle")
public class addVehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addVehicle() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        response.setContentType("text/html;charset=UTF-8");
        
        
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        Date nextReviewDate = Date.valueOf(request.getParameter("nextReviewDate")) ;
        Integer productionYear = Integer.parseInt( request.getParameter("productionYear"));
        String registrationNumber = request.getParameter("registrationNumber");
        
		// Création du customer
        VehicleService VehicleService = new VehicleService();
		//Vehicle vehicle = new Vehicle(brand, model, nextReviewDate, productionYear, registrationNumber);
		//VehicleService.addVehicle(vehicle);    

        response.sendRedirect("./vehicles");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

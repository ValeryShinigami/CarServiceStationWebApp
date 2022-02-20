package servletOrder;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import model.Employee;
import model.Order;
import model.Status;
import model.Vehicle;
import service.EmployeeService;
import service.OrderService;
import service.StatusService;
import service.VehicleService;

/**
 * Servlet implementation class addOrder
 */
@WebServlet("/add-order")
public class addOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public addOrder() {
        super();
       
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        response.setContentType("text/html;charset=UTF-8");
        
      
        
        try {
        	String acceptanceDate = request.getParameter("acceptanceDate");
            String plannedRepairStartDate = request.getParameter("plannedRepairStartDate");
            String actualRepairStartDate =request.getParameter("actualRepairStartDate");
            String costEmployeeHourlyRate = request.getParameter("costEmployeeHourlyRate");
            String costFinalToPay = request.getParameter("costFinalToPay"); 
            String  costUsedParts = request.getParameter("costUsedParts");
            String problemDescription = request.getParameter("problemDescription");  
            String repairDescription = request.getParameter("repairDescription");
            String repairTimeInHours = request.getParameter("repairTimeInHours");
            
            System.out.println(acceptanceDate);
            System.out.println(plannedRepairStartDate);
            System.out.println(actualRepairStartDate);
            System.out.println(costEmployeeHourlyRate);
            System.out.println(costFinalToPay);
            System.out.println(costUsedParts);
            
            EmployeeService employeeService = new EmployeeService();
           // Employee employee = employeeService.getEmployeeById(Integer.valueOf("assignedEmployeeId")); 
            Employee employee = employeeService.getEmployeeById(Integer.parseInt(request.getParameter("assignedEmployeeId")));  

            VehicleService vehicleService = new VehicleService();
            //Vehicle vehicle = vehicleService.getVehicleById(Integer.valueOf("repairedVehicleId"));
            Vehicle vehicle = vehicleService.getVehicleById(Integer.parseInt(request.getParameter("repairedVehicleId"))); 
            StatusService statusService = new StatusService();
           // Status status = statusService.getStatusById(Integer.valueOf("repairedStatusId"));
            Status status = statusService.getStatusById(Integer.parseInt(request.getParameter("repairedStatusId")));
    		// Création de la commande 
           
                   
            	 OrderService orderService = new OrderService();
                 Order order = new Order( Date.valueOf(acceptanceDate),
                 						  Date.valueOf(plannedRepairStartDate),
                 						  Date.valueOf(actualRepairStartDate),
                 						  new BigDecimal(costEmployeeHourlyRate),
                 						  new BigDecimal(costFinalToPay), 
                 						  new BigDecimal(costUsedParts), 
                 						  problemDescription,       						
                 						  repairDescription,
                 						  new BigDecimal(repairTimeInHours), 
                 						  employee,
                 						  vehicle,
                 						  status);
                 
                 System.out.println(acceptanceDate);
                 System.out.println(plannedRepairStartDate);
                 System.out.println(actualRepairStartDate);
                 System.out.println(costEmployeeHourlyRate);
                 System.out.println(costFinalToPay);
                 System.out.println(costUsedParts);
                 
                /* System.out.println(problemDescription);
                 System.out.println(repairDescription);
                 System.out.println(repairTimeInHours);
                 System.out.println(employee);
                 System.out.println(vehicle);
                 System.out.println(status);*/
                 						
         		orderService.addOrder(order);
         		
         		response.sendRedirect("./orders");
				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	         

           
				
            
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			StatusService statusService = new StatusService();
	        List<Status> statusList = statusService.getAllStatus();
	        request.setAttribute("statusList", statusList);
	        EmployeeService employeeService = new EmployeeService();
	        List<Employee> employeeList = employeeService.getEmployees();
	        request.setAttribute("employeeList", employeeList);
	        VehicleService vehicleService = new VehicleService();
	        List<Vehicle> vehicleList = vehicleService.getVehicles();
	        request.setAttribute("vehicleList", vehicleList);
	        
	     
	        getServletContext().getRequestDispatcher("/orders/addOrder.jsp")
	                .forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

}

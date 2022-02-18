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
        	String acceptanceDate = request.getParameter("acceptance_date");
            String plannedRepairStartDate = request.getParameter("planned_repair_start_date");
            String actualRepairStartDate =request.getParameter("actual_repair_start_date");
            String costEmployeeHourlyRate = request.getParameter("cost_employee_hourly_rate");
            String costFinalToPay = request.getParameter("cost_final_to_pay"); 
            String  costUsedParts = request.getParameter("cost_used_parts");
            String problemDescription = request.getParameter("problem_description");  
            String repairDescription = request.getParameter("repair_description");
            String repairTimeInHours = request.getParameter("repair_time_in_hours");
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
                 Order order = new Order(Date.valueOf(acceptanceDate),
                 						Date.valueOf(plannedRepairStartDate),
                 						Date.valueOf(actualRepairStartDate),
                 						BigDecimal.valueOf(Double.valueOf(costEmployeeHourlyRate)), 
                 						//Double.valueOf(costEmployeeHourlyRate),
                 						BigDecimal.valueOf(Double.valueOf(costFinalToPay)), 
                 						//Double.valueOf(costFinalToPay),
                 						BigDecimal.valueOf(Double.valueOf(costUsedParts)), 
                 						//Double.valueOf(costUsedParts),
                 						problemDescription,       						
                 						repairDescription,
                 						BigDecimal.valueOf(Double.valueOf(repairTimeInHours)), 
                 						//Double.valueOf(repairTimeInHours ),
                 						employee,
                 						vehicle,
                 						status);
                 						
         		orderService.addOrder(order);
         		
         		
				
			} catch (NumberFormatException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
    	         

           response.sendRedirect("./orders");
				
            
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

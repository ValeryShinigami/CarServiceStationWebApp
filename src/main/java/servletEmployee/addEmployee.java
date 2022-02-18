package servletEmployee;

import java.io.IOException;
import java.math.BigDecimal;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Employee;
import service.EmployeeService;


@WebServlet("/add-employee")
public class addEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public addEmployee() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        response.setContentType("text/html;charset=UTF-8");
        
        try {
        	String address = request.getParameter("address");//getParameter()retourne la variable sous forme de string
            String firstName = request.getParameter("first_name");
            String hourlyRate = request.getParameter("hourlyRate");
            //BigDecimal hourlyRate = new BigDecimal( request.getParameter("hourly_rate"));
            String lastName = request.getParameter("last_name");
            String phoneNumber = request.getParameter("phone_number");
            String remarks = request.getParameter("remarks");
            
            
            
           
            //création des employees
            //instanciation de EmployeeService pour récupérer les méthodes dans employeeDAO
            EmployeeService es = new EmployeeService();
            //instanciation de l'objet employee
           // ResultSet.getBigDecimal
            Employee employee =  new Employee(address,
            								  firstName,
            								  //BigDecimal.valueOf(Double.valueOf(hourlyRate)),
            								 new BigDecimal(hourlyRate),
            							      lastName,
            								  phoneNumber,
            								  remarks); 
            
           
            es.addEmployee(employee);
            
           
			
		} catch (NumberFormatException  e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		getServletContext().getRequestDispatcher("/employees/addEmployee.jsp")
        .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

}

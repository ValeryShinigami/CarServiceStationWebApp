package servletEmployee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class allEmployee
 */
@WebServlet("/employees")
public class allEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeService es = new EmployeeService();
		
		List<Employee>employees = es.getEmployees();
		
		if (employees == null || employees.size() == 0) {
		    request.setAttribute("noEmployeesError", "There are no employees in the database!");
		    getServletContext().getRequestDispatcher("/employees/allEmployees.jsp")
		            .forward(request, response);
		   
		}
		request.setAttribute("employees", employees);
		getServletContext().getRequestDispatcher("/employees/allEmployees.jsp")
		        .forward(request, response);
		
		
	}
	
}

package servletCustomer;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CustomerService;






/**
 * Servlet implementation class deleteCustomer
 */
@WebServlet("/delete-customer")
public class deleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public deleteCustomer() {
        super();
        
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        response.setContentType("text/html;charset=UTF-8");
        
        int customerId = Integer.parseInt(request.getParameter("id")) ;
        
		// Suppression du Client
        CustomerService customerService = new CustomerService();
		customerService.deleteCustomer(customerId);
		request.setAttribute("deleteMessage", "Customer with id " + customerId + " is deleted!");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customers");

		requestDispatcher.forward(request, response);
    }

	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

}

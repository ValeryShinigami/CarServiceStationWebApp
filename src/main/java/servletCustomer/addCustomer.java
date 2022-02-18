package servletCustomer;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;


@WebServlet("/add-customer")
public class addCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public addCustomer() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        response.setContentType("text/html;charset=UTF-8");
        
        Date birthDate = Date.valueOf(request.getParameter("birthDate")) ;
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
      
        
		// Création du customer
        CustomerService customerService = new CustomerService();
		Customer customer = new Customer(birthDate, firstName, lastName);
		customerService.addCustomer(customer);    

        response.sendRedirect("./customers");
    }
    
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/customers/addCustomer.jsp")
        .forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

}

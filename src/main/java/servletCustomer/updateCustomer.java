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


@WebServlet("/update-customer")
public class updateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public updateCustomer() {
        super();
        
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        response.setContentType("text/html;charset=UTF-8");
       
        int id = Integer.valueOf(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Date birthDate = Date.valueOf(request.getParameter("birthDate"));
        

        try {      
      
		// Mise a jour du customer
        CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomerById(id);;
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setBirthDate(birthDate);
	    customerService.addCustomer(customer);
        }
        catch (NumberFormatException e) {
    }
   
		response.sendRedirect("./customers");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		CustomerService customerService = new CustomerService();
		Customer customer = customerService.getCustomerById(id);
		request.setAttribute("customer", customer);
		getServletContext().getRequestDispatcher("/customers/updateCustomer.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
		
	}

}


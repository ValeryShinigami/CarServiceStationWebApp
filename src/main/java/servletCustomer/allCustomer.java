package servletCustomer;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import service.CustomerService;


@WebServlet("/customers")
public class allCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public allCustomer() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerService customerService = new CustomerService();
		
		List<Customer>customers = customerService.getCustomers();
		
		if (customers == null || customers.size() == 0) {
		    request.setAttribute("noCustomersError", "There are no customers in the database!");
		    getServletContext().getRequestDispatcher("/customers/allCustomers.jsp")
		            .forward(request, response);
		   
		}
		request.setAttribute("customers", customers);
		getServletContext().getRequestDispatcher("/customers/allCustomers.jsp")
		        .forward(request, response);
		
		
	}

}

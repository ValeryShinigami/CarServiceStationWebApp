package servletOrder;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import service.OrderService;


@WebServlet("/orders")
public class allOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public allOrder() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		OrderService orderService = new OrderService();
		
		List<Order>orders = orderService.getOrders();
		
		if (orders == null || orders.size() == 0) {
		    req.setAttribute("noCustomersError", "There are no orders in the database!");
		    getServletContext().getRequestDispatcher("/orders/allOrders.jsp")
		            .forward(req, resp);
		   
		}
		req.setAttribute("orders", orders);
		getServletContext().getRequestDispatcher("/orders/allOrders.jsp")
		        .forward(req, resp);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

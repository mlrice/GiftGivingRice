package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharitableGift;
import model.CharityRecipient;

/**
 * Servlet implementation class AddCharitableGiftServlet
 */
@WebServlet("/AddCharitableGiftServlet")
public class AddCharitableGiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCharitableGiftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String taxId = request.getParameter("taxId");
		
		CharityRecipient cr = new CharityRecipient(name, address, city, state, postalCode, taxId);
		CharitableRecipientHelper crecipienthelp = new CharitableRecipientHelper();		
		crecipienthelp.addRecipient(cr);
		
		String date = request.getParameter("dateGiven");
		LocalDate dbDate = LocalDate.parse(date, formatter);
		String description = request.getParameter("description");
		String value = request.getParameter("value");
		double dValue = Double.parseDouble(value);
		String [] tDeductible = request.getParameterValues("taxDeductible");
		boolean isTDeduct = false;
		if (tDeductible !=null && tDeductible.length > 0) {
			isTDeduct = true;
		}
		String [] hReceipt = request.getParameterValues("haveReceipt");
		boolean hasReceipt = false;
		if (hReceipt !=null && hReceipt.length > 0) {
			hasReceipt = true;
		}
		
		CharitableGift cg = new CharitableGift(dbDate, description, dValue, cr, isTDeduct, hasReceipt);
		CharitableGiftHelper cgifthelp = new CharitableGiftHelper();
		cgifthelp.addGift(cg);
		
		getServletContext().getRequestDispatcher("/AddCharitableGift.html").forward(request, response);
	}


	}



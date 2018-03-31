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

/**
 * Servlet implementation class EditCharitableGiftServlet
 */
@WebServlet("/EditCharitableGiftServlet")
public class EditCharitableGiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCharitableGiftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		CharitableGiftHelper cgifthelp = new CharitableGiftHelper();
		
		String date = request.getParameter("date");
		LocalDate dbDate = LocalDate.parse(date,formatter);
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
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		CharitableGift cGiftToEdit = cgifthelp.getGiftById(tempId);
		cGiftToEdit.setDateGiven(dbDate);
		cGiftToEdit.setDescription(description);
		cGiftToEdit.setValue(dValue);
		cGiftToEdit.setTaxDeductible(isTDeduct);
		cGiftToEdit.setHaveReceipt(hasReceipt);
		
		cgifthelp.editGift(cGiftToEdit);
		
		getServletContext().getRequestDispatcher("/ViewCharitableGiftsServlet").forward(request, response);
		
		doGet(request, response);
		
	}

}

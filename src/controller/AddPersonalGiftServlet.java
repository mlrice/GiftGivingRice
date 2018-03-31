package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonRecipient;
import model.PersonalGift;
import model.Recipient;

/**
 * Servlet implementation class AddPersonalGiftServlet
 */
@WebServlet("/AddPersonalGiftServlet")
public class AddPersonalGiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonalGiftServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String birthDate = request.getParameter("birthDate");
		LocalDate bDate = LocalDate.parse(birthDate, formatter);
		String relationship = request.getParameter("relationship");
		
		
		
		PersonRecipient pr = new PersonRecipient(name, address, city, state, postalCode, bDate, relationship);
		PersonRecipientHelper prh = new PersonRecipientHelper();
		prh.addPersonRecipient(pr);
		
		String date = request.getParameter("dateGiven");
		LocalDate giftDate = LocalDate.parse(date, formatter);
		String description = request.getParameter("description");
		double value = Double.parseDouble(request.getParameter("value"));
		Recipient recipient = (Recipient) request.getAttribute("recipient");
		String occasion = request.getParameter("occasion");
		

		PersonalGift pg = new PersonalGift(giftDate, description, value, pr, occasion);
		PersonalGiftHelper pgh = new PersonalGiftHelper();
		pgh.addPersonalGift(pg);

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}

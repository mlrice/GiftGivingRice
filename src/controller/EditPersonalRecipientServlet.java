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

/**
 * Servlet implementation class EditPersonalRecipientServlet
 */
@WebServlet("/EditPersonalRecipientServlet")
public class EditPersonalRecipientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonalRecipientServlet() {
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
		PersonRecipientHelper precipienthelp = new PersonRecipientHelper();	
		
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String postalCode = request.getParameter("postalCode");
		String birthDate = request.getParameter("birthDate");
		LocalDate bDate = LocalDate.parse(birthDate, formatter);
		String relationship = request.getParameter("relationship");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		PersonRecipient pRecipientToEdit = precipienthelp.getRecipientById(tempId);
		
		pRecipientToEdit.setName(name);
		pRecipientToEdit.setStreetAddress(address);
		pRecipientToEdit.setCity(city);
		pRecipientToEdit.setState(state);
		pRecipientToEdit.setPostalCode(postalCode);
		pRecipientToEdit.setBirthDate(bDate);
		pRecipientToEdit.setRelationship(relationship);
			
		precipienthelp.editRecipient(pRecipientToEdit);
		
		getServletContext().getRequestDispatcher("/ViewPersonalRecipientsServlet").forward(request, response);
			
		doGet(request, response);
	}

}

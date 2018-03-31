package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonalGift;

/**
 * Servlet implementation class EditPersonalGiftServlet
 */
@WebServlet("/EditPersonalGiftServlet")
public class EditPersonalGiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonalGiftServlet() {
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
		PersonalGiftHelper pgifthelp = new PersonalGiftHelper();
		
		String date = request.getParameter("date");
		System.out.println("dateGiven: " + date);
		LocalDate dbDate = LocalDate.parse(date,formatter);
		String description = request.getParameter("description");
		String value = request.getParameter("value");
		double dValue = Double.parseDouble(value);
		String occasion = request.getParameter("occasion");
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		PersonalGift pGiftToEdit = pgifthelp.getGiftById(tempId);
		
		pGiftToEdit.setDateGiven(dbDate);
		pGiftToEdit.setDescription(description);
		pGiftToEdit.setValue(dValue);
		pGiftToEdit.setOccasion(occasion);
		
		pgifthelp.editGift(pGiftToEdit);
		
		getServletContext().getRequestDispatcher("/ViewPersonalGiftsServlet").forward(request, response);
		
		doGet(request, response);
	}

}

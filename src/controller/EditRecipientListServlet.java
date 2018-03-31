package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonRecipient;

/**
 * Servlet implementation class EditRecipientListServlet
 */
@WebServlet("/EditRecipientListServlet")
public class EditRecipientListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRecipientListServlet() {
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
		PersonRecipientHelper precipienthelp = new PersonRecipientHelper();	
		String act = request.getParameter("doThisToPRecipient");

		if (act == null) {
			getServletContext().getRequestDispatcher("/ViewPersonalRecipientsServlet").forward(request, response);
		} else if (act.equals("Edit Selected Recipient")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			PersonRecipient pRecipientToEdit = precipienthelp.getRecipientById(tempId);
			request.setAttribute("pRecipientToEdit", pRecipientToEdit);
			getServletContext().getRequestDispatcher("/EditPersonalRecipient.jsp").forward(request, response);
		}
	}

}

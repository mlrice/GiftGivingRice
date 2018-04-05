package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CharitableGift;
import model.CharityRecipient;


/**
 * Servlet implementation class EditCharitableGiftServlet
 */
@WebServlet("/EditCharitableGiftListServlet")
public class EditCharitableGiftListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCharitableGiftListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*CharitableGiftHelper cgifthelp = new CharitableGiftHelper();
		
		request.setAttribute("allCharitableGifts", cgifthelp.showAllCharitableGifts());
	
	if (pgifthelp.showAllPersonalGifts().isEmpty()) {
			request.setAttribute("allPersonalGifts", " ");
		}
*/
	
	getServletContext().getRequestDispatcher("/ViewCharitableGifts.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CharitableGiftHelper cgifthelp = new CharitableGiftHelper();
		CharitableRecipientHelper crecipienthelp = new CharitableRecipientHelper();
		String act = request.getParameter("doThisToGift");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/ViewCharitableGiftsServlet").forward(request, response);
		} else if (act.equals("Delete Selected Gift and Recipient")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			CharitableGift giftToDelete = cgifthelp.getGiftById(tempId);
			Integer tempRId = (Integer) giftToDelete.getRecipient().getId();
			cgifthelp.deleteGift(giftToDelete);
			
			CharityRecipient toDelete = crecipienthelp.getRecipientById(tempRId);
			crecipienthelp.deleteRecipient(toDelete);
						
			getServletContext().getRequestDispatcher("/ViewCharitableGiftsServlet").forward(request, response);
		} else if (act.equals("Edit Selected Gift")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			CharitableGift giftToEdit = cgifthelp.getGiftById(tempId);
			request.setAttribute("cGiftToEdit", giftToEdit);
			getServletContext().getRequestDispatcher("/EditCharitableGift.jsp").forward(request, response);
		} else if (act.equals("Add New Gift")) {
			getServletContext().getRequestDispatcher("/AddCharitableGift.html").forward(request, response);
		}


	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewCharitableGiftsListServlet
 */
@WebServlet("/ViewCharitableGiftsServlet")
public class ViewCharitableGiftsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCharitableGiftsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		CharitableGiftHelper cgifthelp = new CharitableGiftHelper();
		
		request.setAttribute("allCharitableGifts", cgifthelp.showAllCharitableGifts());
		
	/*	if(cgifthelp.showAllCharitableGifts().isEmpty()) {
			request.setAttribute("allCharitableGifts", " ");
		}
	*/	getServletContext().getRequestDispatcher("/ViewCharitableGifts.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

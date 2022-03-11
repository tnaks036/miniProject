package miniProject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import miniPjoject.dao.miniProjectDAO;
import miniPjoject.dao.miniProjectDAOimply;
import miniPjoject.dao.miniProjectlist;

@WebServlet(name = "Restaurantlist", urlPatterns = "/rs")
public class RestaurantServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = req.getParameter("category");
		String restaurant = req.getParameter("restaurant");
		String select = req.getParameter("select");

		if (select.equals("next")) {

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/ms.jsp");
			miniProjectDAO dao = new miniProjectDAOimply();
			List<miniProjectlist> list = dao.menu(restaurant);
			req.setAttribute("list", list);

			rd.forward(req, resp);
		} else if (select.equals("뒤로 돌아가기")) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/fs.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendError(404);
		}
	}

}

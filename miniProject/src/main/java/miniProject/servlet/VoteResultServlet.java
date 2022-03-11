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

@WebServlet(name = "VoteResultServlet", urlPatterns = "/vs")
public class VoteResultServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/selectedResult.jsp");
		miniProjectDAO dao = new miniProjectDAOimply();
		List<miniProjectlist> list = dao.getSelectedList();
		req.setAttribute("list", list);

		rd.forward(req, resp);

		
	}
	
	

}

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

@WebServlet(name = "MenuServlet", value = "/ms")
public class MenuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String category = req.getParameter("category");
		String restaurant = req.getParameter("restaurant");
		String menu = req.getParameter("menu");
		String select = req.getParameter("select");
		
		
		
		if("next".equals(select)) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/result.jsp");
			miniProjectDAO dao = new miniProjectDAOimply();		
			
			dao.update(category, restaurant, menu);
			List<miniProjectlist> list = dao.getList(restaurant);
			req.setAttribute("list", list);
			
			miniProjectlist summary = dao.getPollsCount(category, restaurant, menu);
			req.setAttribute("summary", summary);
//			List<miniProjectlist> countOfPolls = dao.getPolls(category, restaurant, menu);
//			req.setAttribute("countOfPolls", countOfPolls);
//			
//			List<miniProjectlist> specification = dao.getspecification(category,restaurant, menu);
//			req.setAttribute("specification", specification);
			
			
			

			rd.forward(req, resp);

		}else if ("뒤로 돌아가기".equals(select)){
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/rs.jsp");
			miniProjectDAO dao = new miniProjectDAOimply();
			List<miniProjectlist> list = dao.restaurant(category);
			req.setAttribute("list", list);
			rd.forward(req, resp);
		} else {
			resp.sendError(404);
		}
		}
			
		
		

	}

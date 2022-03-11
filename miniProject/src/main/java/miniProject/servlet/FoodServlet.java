package miniProject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import miniPjoject.dao.miniProjectDAO;
import miniPjoject.dao.miniProjectDAOimply;
import miniPjoject.dao.miniProjectlist;

@WebServlet(name= "FoodServlet", value="/fs")
public class FoodServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 데이터를 가져오기 위한 조치
		resp.setContentType("text/html; charset=UTF-8");
		
		String category = req.getParameter("category");	//	?
		String select = req.getParameter("select");
		
		
		if(select.equals("너로 정했다")) {
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/rs.jsp");
			miniProjectDAO dao = new miniProjectDAOimply();
			List<miniProjectlist> list = dao.restaurant(category);
//			List<miniProjectlist> list = dao.getList(food);
			req.setAttribute("list", list);
			
			rd.forward(req, resp);
			
//			if(food.equals("1")) {
//				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/korean.jsp");
//				rd.forward(req, resp);
//				
//			}else if(food.equals("2")) {
//				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/western.jsp");
//				rd.forward(req, resp);
//				
//			}else if(food.equals("4")) {
//				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/japanese.jsp");
//				rd.forward(req, resp);
//				
//			}else if(food.equals("5")) {
//				RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/chinese.jsp");
//				rd.forward(req, resp);
//			}
		
		}else if(select.equals("뒤로 돌아가기")){
			//	-> redirect to index.html
			resp.sendRedirect("./index.html");
//			resp.sendRedirect(select)
//			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.html");
//			rd.forward(req, resp);
		}else {
			resp.sendError(404);
		}
		
//		String command = req.getRequestURI().substring(req.getContextPath().length());
//		if(command.equals("/rc")) {
//			System.out.println(command);
//		}else {
//			System.out.println("실패");
//		}
	}

	
}

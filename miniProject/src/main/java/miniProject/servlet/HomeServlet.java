package miniProject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HomeServlet", value = "/hs")
public class HomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		
//		String command = req.getRequestURI().substring(req.getContextPath().length());
		
		// servlet은 컴파일되면 기본 위치는 webapp임
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/selectlist/fs.jsp");
		rd.forward(req, resp);
			
	}
	
}

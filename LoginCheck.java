

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request will hold the parameters entered in jsp page
		String uname = request.getParameter("uname");
		String password =request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		if(dao.check(uname, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username",uname);
			response.sendRedirect("Member.jsp");
		}
		else {
			response.sendRedirect("Error.jsp");
		}
	}

}

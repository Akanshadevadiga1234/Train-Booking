package Controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname=req.getParameter("fname");
		String lastname=req.getParameter("lname");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String password1=req.getParameter("password1");
		String password2=req.getParameter("password2");
		Date dob=Date.valueOf(req.getParameter("dob"));
		int age=Period.between(dob.toLocalDate(), LocalDate.now()).getYears();
				
		if(password1.equals(password2))
		{
			if(age>18)
			{
				
			}
			else{
				res.getWriter().print("<h1 style='color:red'>password not old</h1>");
				req.getRequestDispatcher("Register.html").include(req, res);
			}
		}
		else {
			res.getWriter().print("<h1 style='color:red'>password not old </h1>");
			req.getRequestDispatcher("Register.html").include(req, res);
		}
	}

}

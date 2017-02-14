import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
//Ki haal chal paaji!!
//@WebServlet(description ="kuch bhi ni" , urlPatterns = {"/xmlpath"} , initParams = {@WebInitParam(name="userName" , value = "John Doe") })
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res){
		try{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			HttpSession session=req.getSession();
			ServletContext context=req.getServletContext();
			String userName=req.getParameter("userName");
			if(userName!="" && userName!=null){
				session.setAttribute("userName", userName);
				context.setAttribute("userName", userName);
			}
			out.println("Session "+(String)session.getAttribute("userName"));
			out.println("Context "+(String)context.getAttribute("userName"));
			out.println("Default "+(String)this.getServletConfig().getInitParameter("userName"));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res){
		try{
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			String firstName=req.getParameter("first_name");
			String lastName=req.getParameter("last_name");
			String prof=req.getParameter("prof");
			String[] location = req.getParameterValues("location");
			out.println(firstName+ " " +lastName+ " !! You are a "+prof+" present at "+location.length+" places.");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}

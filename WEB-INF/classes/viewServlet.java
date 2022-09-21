import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.sql.*;

public class viewServlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String cus_name = req.getParameter("cus_name");

        try
        { 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","Paddu123@@");
            Statement stm=con.createStatement();
            ResultSet rs = stm.executeQuery("select * from customers where customer_name='"+cus_name+"'");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">"); 
            out.println("<style>");  
            out.println(".btn1 {"); 
            out.println("color:white;");
            out.println("background-color:skyblue;");
            out.println("border: none;");
            out.println("padding: 13px;");
            out.println("text-decoration:none;");
            out.println("font-size: 16px;");
            out.println("border-radius: 12px;");
            out.println("}"); 
            out.println("table {"); 
            out.println("border-collapse:collapse;");
            out.println("width:100%");
            out.println("}"); 
            out.println("th,td {"); 
            out.println("padding:8px;");
            out.println("text-align:left;");
            out.println("border-bottom: 1px solid #DDD;");
            out.println("}"); 

            out.println("a {");
            out.println("cursor:pointer;");
            out.println("text-decoration:none;");
            out.println("}");
    
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<center><table>");
            out.println("<h1>Customer Details</h1>");
            if(rs.next())
             
            { 
              out.println("<tr> <td><h3> "+"Name of the Account Holder  "+"</h3></td> ");
              out.println("<td> <h3>"+rs.getString(2)+"</h3></td> </tr>");
              out.println("<tr> <td><h3> "+"Account Number  "+"</h3></td> ");
              out.println("<td> <h3>"+rs.getString(1)+"</h3></td> </tr>");
              out.println("<tr> <td><h3> "+"Email "+"</h3></td> ");
              out.println("<td><h3> "+rs.getString(3)+"</h3></td> </tr>");
              out.println("<tr> <td><h3> "+"Current Balance "+"</h3></td> ");
              out.println("<td><h3> "+rs.getString(4)+"</h3></td> </tr>");
              out.println("</table></center><br>");
            }
            else
            {
                out.print("<h1>Please enter correct details</h1");
            }
            out.print("<br> <br> <br>");
            out.print("<div align = center><button class = btn1 ><a href = index.html>Back to home</a></button></div>");
            out.println("</body>");
            out.println("</html>");
            con.close();
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
	}
}
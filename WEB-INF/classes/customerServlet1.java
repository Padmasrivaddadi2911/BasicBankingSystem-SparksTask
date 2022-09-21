import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class customerServlet1 extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<center><h1>Customer Details</h1></center>");
try 
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb?useSSL=false","root","Paddu123@@");
Statement stm=con.createStatement();
ResultSet r=stm.executeQuery("select * from customers");
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<meta charset=\"utf-8\">"); 
out.println("<style>");    
out.println(".bt {"); 
out.println("color:white;");
out.println("background-color:violet;");
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
out.println("tr:hover {"); 
out.println("background-color: skyblue;");
out.println("}"); 
out.println("a {"); 
out.println("text-decoration:none;");
out.println("cursor:pointer;");
out.println("}"); 
out.println("</style>");
out.println("</head>");
out.println("<body>");
out.println("<center><table>");
out.println("<tr><th>Account Number</th><th>Customer Name</th><th>Email</th><th>Current Balance</th></tr>");
while(r.next())
{
out.println("<tr> <td> "+r.getString(1)+"</td> ");
out.println("<td> "+r.getString(2)+"</td> ");
out.println("<td> "+r.getString(3)+"</td>");
out.println("<td> "+r.getInt(4)+" </td> </tr>");
}
out.println("</table></center><br>");
out.println("<div align = center><button class = bt> <a href = transfer.html>Transfer</a></button></div>");
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
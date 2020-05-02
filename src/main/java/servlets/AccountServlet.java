package com.google.sps.servlets;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");
    response.getWriter().println("<h1>This is the account page.</h1>");
    try {
        handleRequest(request, response);
    } catch(Exception e) {
        out.println(e.getMessage());
    }
   }

  public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 
    response.setContentType("text/html");
    HttpSession session=request.getSession(false);  
    String name=(String)session.getAttribute("name");  
    String email=(String)session.getAttribute("email"); 

    PrintWriter htmlRespone = response.getWriter();
        htmlRespone.write("<html>");
        htmlRespone.write("<meta http-equiv='refresh' content='5;URL=home.html' />");
        htmlRespone.write("<h2> Hello " + name + "<br/>");
        htmlRespone.write("Your username is: " + email + "<br/>");       
        htmlRespone.write("</html>");
        htmlRespone.close();
  }
}

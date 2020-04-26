package com.google.sps.servlets;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");


    //PrintWriter writer = response.getWriter();
   // String htmlRespone = "<html>";
     //   htmlRespone += "<h2> Hello " + name + "<br/>";
      //  htmlRespone += "Your username is: " + email + "<br/>";      
      //  htmlRespone += "Your password is: " + password + "</h2>";    
      //  htmlRespone += "</html>";

        // return response
        //writer.println(htmlRespone);


    UserService userService = UserServiceFactory.getUserService();
    if (userService.isUserLoggedIn()) {
      String userEmail = userService.getCurrentUser().getEmail();
      response.getWriter().println("<p>Hello " + userEmail + "!</p>");
    } else {
      response.sendRedirect("/login.html");
    }
  }
}


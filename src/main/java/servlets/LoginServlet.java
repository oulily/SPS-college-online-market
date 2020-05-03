package com.google.sps.servlets;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;
import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");

    HttpSession session=request.getSession(false);  
    String named=(String)session.getAttribute("name");  
    String password1=(String)session.getAttribute("password");

    String uname = request.getParameter("uname");
    String passwords = request.getParameter("psw");

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Query query = new Query("User");
    PreparedQuery results = datastore.prepare(query);
        for (Entity entity : results.asIterable()) {
            String name = (String)entity.getProperty("name");
            String email = (String)entity.getProperty("email");
            String password = (String)entity.getProperty("password");
            String university = (String)entity.getProperty("university");
            String telephone = (String)entity.getProperty("telephone");
        }
        
    if (uname == named) {
        if (passwords == password1) {
            response.sendRedirect("/home.html");
        }
        else {
            out.println("Invalid password");
        }   
    }
    else {
            out.println("Invalid username");
    }

    UserService userService = UserServiceFactory.getUserService();
    if (userService.isUserLoggedIn()) {
      response.sendRedirect("/home.html");
    } else {
      String urlToRedirectToAfterUserLogsIn = "/home.html";
      String loginUrl = userService.createLoginURL(urlToRedirectToAfterUserLogsIn);
      response.sendRedirect("/login.html");
    }
}
}
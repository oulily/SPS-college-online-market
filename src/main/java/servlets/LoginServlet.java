package com.google.sps.servlets;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html");


   

    System.out.println("Hello" + username);
    response.sendRedirect("/home.html");
    // if (username == email) {
    //     System.out.println("Hello" + username);
    //     response.sendRedirect("/index.html");
    // }
    // else {
    //     System.out.println("Invalid user or password");

    // }

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
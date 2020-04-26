package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    response.getWriter().println("<h1>This is the login page.</h1>");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String username = getParameter(request, "email address", "");

    // Respond with the result.
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

    }

    private String getParameter(HttpServletRequest request, String name, String defaultvalue) {
    String value = request.getParameter(name);
    if (value == null) {
       return defaultvalue;
    }
    return value;
    }

  }




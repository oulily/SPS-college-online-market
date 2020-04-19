package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
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

    long timestamp = System.currentTimeMillis();

    Entity taskEntity = new Entity("Task");
    taskEntity.setProperty("username", username);
    taskEntity.setProperty("timestamp", timestamp);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(taskEntity);

    if (username == email) {
        system.out.println("Hello" + name);
        response.sendRedirect("/index.html");
    }
    else {
        system.out.println(Invalid user or password);

    }

    }

    private String getParameter(HttpServletRequest request, String name, String defaultvalue) {
    String value = request.getParameter(name);
    if (value == null) {
       return defaultvalue;
    }
    return value;
    }

  }




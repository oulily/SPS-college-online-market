package com.google.sps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    response.getWriter().println("<h1>This is the sign-up page.</h1>");
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
       String name = request.getParameter("name");
       String university = request.getParameter("university"); 
       String telephone = request.getParameter("telephone");   
       String email = request.getParameter("email");
       String password = request.getParameter("password");

     Entity user = new Entity("User");
     user.setProperty ("name", name);
     user.setProperty("university", university);
     user.setProperty("telephone", telephone);
     user.setProperty("email", email);
     user.setProperty("password", password);
    List<Entity> userlist = Arrays.asList(name, university, telephone, email, password);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

    datastore.put(user);


    PrintWriter writer = response.getWriter();
    String htmlRespone = "<html>";
        htmlRespone += "<h2> Hello " + name + "<br/>";
        htmlRespone += "Your username is: " + email + "<br/>";      
        htmlRespone += "Your password is: " + password + "</h2>";    
        htmlRespone += "</html>";

        // return response
        writer.println(htmlRespone);
        
        response.sendRedirect("/home.html");
  }
}
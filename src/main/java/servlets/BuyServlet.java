package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {    
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("<h1>This is the buy page.</h1>");

    out.println("<form action='/buy'>");
    out.println("<div><h4 class='filter'>Filter by:</h4></div>");
    out.println("<div><input type='checkbox'><label>School Supplies</label>");
    out.println("<div><input type='checkbox'><label>Furniture</label>");
    out.println("<div><input type='checkbox'><label>Miscellaneous</label>");
    out.println("</form>");
    
    // UserService userService = UserServiceFactory.getUserService();
    // if (userService.isUserLoggedIn())
    // else { String loginUrl = userService.createLoginURL...}
    
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Query query = new Query("Listing").addSort("timestamp", SortDirection.DESCENDING);
    PreparedQuery results = datastore.prepare(query);
    
    for (Entity entity : results.asIterable()) {
      boolean sold = (boolean)entity.getProperty("sold");
      Double price = (Double)entity.getProperty("price");
      String image = (String)entity.getProperty("image");
      long timestamp = (long)entity.getProperty("timestamp");
      String title = (String)entity.getProperty("title");
      String description = (String)entity.getProperty("description"); 
      
      out.println("<div>");
      out.println("<p>Sold: " + sold + "</p>");
      out.println("<p>Price: " + price + "</p>");
      out.println("<p>Image: " + image + "</p>");
      out.println("<p>Timestamp: " + timestamp + "</p>");
      out.println("<p>Title: " + title + "</p>");
      out.println("<p>Description: " + description + "</p>");
      out.println("</div>");
    }
  }
} 

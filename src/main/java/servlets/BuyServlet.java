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
    
    // UserService userService = UserServiceFactory.getUserService();
    // if (userService.isUserLoggedIn())
    // else { String loginUrl = userService.createLoginURL...}
    
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    Query query = new Query("Listing").addSort("timestamp", SortDirection.DESCENDING);
    PreparedQuery results = datastore.prepare(query);
    
    // UNCOMMENT ONCE WE KNOW DATASTORE WORKS
    // for (Entity entity : results.asIterable()) {
    //   boolean sold = entity.getProperty("sold");
    //   Double price = entity.getProperty("price");
    //   String image = entity.getProperty("image");
    //   long timestamp = entity.getProperty("timestamp");
    //   String title = entity.getProperty("title");
    //   String description = entity.getProperty("description"); 
      
    //   out.println("<div>");
    //   out.println("<p>Sold: " + sold + "</p>");
    //   out.println("<p>Price: " + price + "</p>");
    //   out.println("<p>Image: " + image + "</p>");
    //   out.println("<p>Timestamp: " + timestamp + "</p>");
    //   out.println("<p>Title: " + title + "</p>");
    //   out.println("</div>");

    // }
    boolean sold = true;
    Double price = 10.00;
    String image = "stub";
    long timestamp = 10;
    String title = "stub";
    String description = "stub"; 
    
    out.println("<div>");
    out.println("<p>Sold: " + sold + "</p>");
    out.println("<p>Price: " + price + "</p>");
    out.println("<p>Image: " + image + "</p>");
    out.println("<p>Timestamp: " + timestamp + "</p>");
    out.println("<p>Title: " + title + "</p>");
    out.println("</div>");

    
  }
} 


package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {

  @Override
  public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {    
    final DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    final Query query = new Query("Listing").addSort("timestamp", SortDirection.DESCENDING);
    final PreparedQuery results = datastore.prepare(query);
    
    List<Entity> listings = new ArrayList<>();
    for (final Entity entity : results.asIterable()) {
      final boolean sold = (boolean)entity.getProperty("sold");
      final Double price = (Double)entity.getProperty("price");
      final String image = (String)entity.getProperty("image");
      final long timestamp = (long)entity.getProperty("timestamp");
      final String title = (String)entity.getProperty("title");
      final String description = (String)entity.getProperty("description"); 
      
      listings.add(entity);
    }

    Gson gson = new Gson();
    
    response.setContentType("application/json;");
    response.getWriter().println(gson.toJson(listings));
  }
  
} 

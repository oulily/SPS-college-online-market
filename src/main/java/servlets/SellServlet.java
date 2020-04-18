package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobInfoFactory;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sell")
public class SellServlet extends HttpServlet {

 @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    String uploadUrl = blobstoreService.createUploadUrl("/sell");

    response.setContentType("text/html");
    response.getWriter().println(uploadUrl);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    UserService userService = UserServiceFactory.getUserService();

    // if (!userService.isUserLoggedIn()) {
    //   response.sendRedirect("/");
    //   return;
    // }

    boolean sold = false;
    Double price = Double.valueOf(request.getParameter("price"));
    String location = request.getParameter("location"); // JSON string in {lat, lng} form
    String image = getUploadedFileUrl(request, "image"); // image url
    long timestamp = System.currentTimeMillis();
    String title = request.getParameter("title");
    String description = request.getParameter("description");
    // String userId = userService.getCurrentUser().getUserId();

    Entity listing = new Entity("Listing");
    listing.setProperty("sold", sold);
    listing.setProperty("price", price);
    listing.setProperty("location", location);
    listing.setProperty("image", image);
    listing.setProperty("timestamp", timestamp);
    listing.setProperty("title", title);
    listing.setProperty("description", description);
    // listing.setProperty("userId", userId);

    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    datastore.put(listing);

    response.sendRedirect("/home.html");

    if (sold == true) {
        //send email notification to buyer && seller
    }

  }

  private String getUploadedFileUrl(HttpServletRequest request, String formInputElementName) {
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
    List<BlobKey> blobKeys = blobs.get("image");

    if (blobKeys == null || blobKeys.isEmpty()) {
      return null;
    }

    BlobKey blobKey = blobKeys.get(0);

    BlobInfo blobInfo = new BlobInfoFactory().loadBlobInfo(blobKey);
    if (blobInfo.getSize() == 0) {
      blobstoreService.delete(blobKey);
      return null;
    }

    ImagesService imagesService = ImagesServiceFactory.getImagesService();
    ServingUrlOptions options = ServingUrlOptions.Builder.withBlobKey(blobKey);
    return imagesService.getServingUrl(options);
  }
}
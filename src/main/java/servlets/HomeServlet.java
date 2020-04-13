package com.google.sps.servlets;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index.html")
public class HomeServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");

    UserService userService = UserServiceFactory.getUserService();
    if (userService.isUserLoggedIn()) {
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><head>");
        response.getWriter().println("<meta charset=\"UTF-8\">");
        response.getWriter().println("<title>College Online Market</title>");
        response.getWriter().println("<link rel=\"stylesheet\" href=\"stylesheets/index.css\">");
        response.getWriter().println("<script src=\"javascript/index.js\"></script>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body onload=\"loadComments()\">");
        response.getWriter().println("<div style=\"text-align:center\">");
        response.getWriter().println("<header><div>");
        response.getWriter().println("<ul class=\"list\">");
        response.getWriter().println("<li><a href=\"/index.html\">Home</a></li>");
        response.getWriter().println("<li><a href=\"/buy.html\">Buy</a></li>");
        response.getWriter().println("<li><a href=\"/sell.html\">Sell</a></li>");
        response.getWriter().println("<li><a href=\"/account.html\">Account</a></li>");
        response.getWriter().println("<li><a href=\"/login.html\">Logout</a></li>");
        response.getWriter().println("</ul></div>");
        response.getWriter().println("<div class=\"heading\">");
        response.getWriter().println("<h1>COLLEGE ONLINE MARKET</h1>");
        response.getWriter().println("</div>");
        response.getWriter().println("<div class=\"title\">");
        response.getWriter().println("<h1>THE PLACE TO BUY AND SELL ITEMS NEEDED BY COLLEGE STUDENTS</h1>");
        response.getWriter().println("</div>");
        response.getWriter().println("<div class=\"buttn\">");
        response.getWriter().println("<a href=\"/buy.html\" class=\"btn\">BUY</a>");
        response.getWriter().println("<a href=\"/sell.html\" class=\"btn\">SELL</a>");
        response.getWriter().println("</div></header>");
        response.getWriter().println("<div class=\"parallax\"></div>");
        response.getWriter().println("<div style=\"height:100px; background-color:white; color:gray; font-size:18px\">");
        response.getWriter().println("<h3>ABOUT</h3>");
        response.getWriter().println("<p>The website that allows college students to buy and sell items like textbooks, clothes, furniture, and so much more. It's as simple as creating an account and making a post to sell an item or scrolling through current posts to purchase an item.</p>");
        response.getWriter().println("</div>");
        response.getWriter().println("<div class=\"parallax\"></div>");
        response.getWriter().println("<hr>");
        response.getWriter().println("<form method=\"POST\" action=\"/data\">");
        response.getWriter().println("<h1>COMMENT SECTION:</h1>");
        response.getWriter().println("<input id=\"textbox\" type=\"text\" name=\"commentInput\" />");
        response.getWriter().println("<br/>");
        response.getWriter().println("<button>SUBMIT</button>");
        response.getWriter().println("</form>");
        response.getWriter().println("</hr>");
        response.getWriter().println("<hr>");
        response.getWriter().println("<section>");
        response.getWriter().println("<ul id=\"comment-list\"></ul>");
        response.getWriter().println("</section>");
        response.getWriter().println("</div></body></html>");
    }
    else {
        String loginUrl = userService.createLoginURL("/");
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html><head>");
        response.getWriter().println("<meta charset=\"UTF-8\">");
        response.getWriter().println("<title>College Online Market</title>");
        response.getWriter().println("<link rel=\"stylesheet\" href=\"stylesheets/index.css\">");
        response.getWriter().println("<script src=\"javascript/index.js\"></script>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body onload=\"loadComments()\">");
        response.getWriter().println("<div style=\"text-align:center\">");
        response.getWriter().println("<header><div>");
        response.getWriter().println("<div class=\"heading\">");
        response.getWriter().println("<h1>COLLEGE ONLINE MARKET</h1>");
        response.getWriter().println("</div>");
        response.getWriter().println("<div class=\"title\">");
        response.getWriter().println("<h1>THE PLACE TO BUY AND SELL ITEMS NEEDED BY COLLEGE STUDENTS</h1>");
        response.getWriter().println("</div>");
        response.getWriter().println("<div class=\"buttn\">");
        response.getWriter().println("<a href=\"/login.html\" class=\"btn\">LOGIN</a>");
        response.getWriter().println("</div></header>");
        response.getWriter().println("<div class=\"parallax\"></div>");
        response.getWriter().println("<div style=\"height:100px; background-color:white; color:gray; font-size:18px\">");
        response.getWriter().println("<h3>ABOUT</h3>");
        response.getWriter().println("<p>The website that allows college students to buy and sell items like textbooks, clothes, furniture, and so much more. It's as simple as creating an account and making a post to sell an item or scrolling through current posts to purchase an item.</p>");
        response.getWriter().println("</div>");
        response.getWriter().println("<div class=\"parallax\"></div>");
        response.getWriter().println("<hr>");
        response.getWriter().println("<form method=\"POST\" action=\"/data\">");
        response.getWriter().println("<h1>COMMENT SECTION:</h1>");
        response.getWriter().println("<input id=\"textbox\" type=\"text\" name=\"commentInput\" />");
        response.getWriter().println("<br/>");
        response.getWriter().println("<button>SUBMIT</button>");
        response.getWriter().println("</form>");
        response.getWriter().println("</hr>");
        response.getWriter().println("<hr>");
        response.getWriter().println("<section>");
        response.getWriter().println("<ul id=\"comment-list\"></ul>");
        response.getWriter().println("</section>");
        response.getWriter().println("</div></body></html>");
    }
  }
}

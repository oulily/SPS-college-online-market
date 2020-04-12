package com.google.sps.servlets;

public class User {
    String name;
    String university;
    String email;
    String telephone;
    int userID;

    public User(String name, String university, String email, String telephone, int userID ) {
        this.name = name;
        this.university = university;
        this.email = email;
        this.telephone = telephone;
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String getEmail() {
        return email;
    }
    public StringBuilder getTelephone() {
        StringBuilder x = new StringBuilder();
       for (int i = 0; i < telephone.length(); i++) {
        if (Character.isDigit(telephone.charAt(i)) == true) 
            x.append(telephone.charAt(i));
         
         }
        
       
       return x;
    }

    public void setuserID() {
    }

@Override
    public String toString() {
        return "name: " + name + "university:" +  university + "email: " + email + "telephone: " + telephone + "user ID: " + userID  ;
    }
}
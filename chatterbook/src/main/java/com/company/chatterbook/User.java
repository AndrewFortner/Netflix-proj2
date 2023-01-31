package com.company.chatterbook;
import java.util.*;

public class User {
    String name;
    private ArrayList<ChatterPost> chatterPosts;

    public User(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public List<ChatterPost> getPosts() {
        return chatterPosts;
    }
    public void setChatterPosts(List chatterPosts) {
        this.chatterPosts = (ArrayList<ChatterPost>) chatterPosts;
    }
}

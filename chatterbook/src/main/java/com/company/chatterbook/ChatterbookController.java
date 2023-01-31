package com.company.chatterbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@SpringBootApplication
public class ChatterbookController {

    private List<User> userList;

    public ChatterbookController() {
        userList = new ArrayList<User>();
        User luis = new User("Luis");
        userList.add(luis);
        User sue = new User("Sue");
        userList.add(sue);
        User timothy = new User("Timothy");
        userList.add(timothy);
        User george = new User("George");
        userList.add(george);
        User arturo = new User("Arturo");
        userList.add(arturo);
        User mariella = new User("Mariella");
        userList.add(mariella);
        User paolo = new User("Paolo");
        userList.add(paolo);
        User tri = new User("Tri");
        userList.add(tri);
        User jane = new User("Jane");
        userList.add(jane);
        User carol = new User("Carol");
        userList.add(carol);
        User carl = new User("Carl");
        userList.add(carl);


        luis.setChatterPosts(Arrays.asList(new ChatterPost("Hey! This is my first post!"), new ChatterPost("Anybody want to be friends?")));
        sue.setChatterPosts(Arrays.asList(new ChatterPost("I'm bored"), new ChatterPost("Who wants to hang?")));
        timothy.setChatterPosts(Arrays.asList(new ChatterPost("My life is awesome!"), new ChatterPost("Click here to buy my vegan shakes!")));
        george.setChatterPosts(Arrays.asList(new ChatterPost("I like pigs."), new ChatterPost("I love lamp.")));
        arturo.setChatterPosts(Arrays.asList(new ChatterPost("My cat is so cute"), new ChatterPost("My kitten is purr-fect.")));
        mariella.setChatterPosts(Arrays.asList(new ChatterPost("I'll never post again")));
        paolo.setChatterPosts(Arrays.asList(new ChatterPost("Have you ever heard of the band Nirvana?"), new ChatterPost("Pearl Jam 4 Life")));
        tri.setChatterPosts(Arrays.asList(new ChatterPost("You definitely grew up in the 90s if you get these 10 references."), new ChatterPost("I don't get this generation? Everyone expects a participation trophy.")));
        jane.setChatterPosts(Arrays.asList(new ChatterPost("I just wrecked my dad's car. He's going to kill me!"), new ChatterPost("Grounded.... for 5 months :( ")));
        carol.setChatterPosts(Arrays.asList(new ChatterPost("Does anyone have some imodium?")));
        carl.setChatterPosts(Arrays.asList(new ChatterPost("My roommate is awful!!!!"), new ChatterPost("Anyone know a room for rent in Hyde Park?")));

        userList = Arrays.asList(luis, sue, timothy, george, arturo, mariella, paolo, tri, jane, carol, carl);
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatterbookController.class, args);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ChatterPost> getAllPosts(@RequestParam String user) {
        for(int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(user)) {
                return userList.get(i).getPosts();
            }
        }
        return null;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public User getUsername(@RequestParam String name) {
        for(int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(name)) {
                return userList.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<User> getUsername() {
        return userList;
    }
}

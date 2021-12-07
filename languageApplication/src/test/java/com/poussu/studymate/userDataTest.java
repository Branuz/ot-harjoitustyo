package com.poussu.studymate;

import static org.junit.Assert.assertEquals;

import com.poussu.studymate.userData.User;

import org.junit.Before;
import org.junit.Test;

public class userDataTest {
    User user;

    @Before
    public void setup(){
        user = new User("Admin", "1234", "Admin@gmail.com");
    }
    @Test
    public void correctName(){
        assertEquals("Admin", user.getName());
    }

    @Test
    public void correctEmail(){
        assertEquals("Admin@gmail.com", user.getEmail());
    }

    @Test
    public void correctPassword(){
        assertEquals("1234", user.getPassword());
    }

    @Test
    public void setPasswordCorrect(){
        user.setPassword("4321");
        assertEquals("4321", user.getPassword());
    }

    @Test
    public void setEmailCorrect(){
        user.setEmail("mikko@gmail.com");
        assertEquals("mikko@gmail.com", user.getEmail());
    }

    @Test
    public void setNameCorrect(){
        user.setName("mikael");
        assertEquals("mikael", user.getName());
    }
}

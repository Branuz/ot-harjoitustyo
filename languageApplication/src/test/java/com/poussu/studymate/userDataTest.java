package com.poussu.studymate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.sql.Connection;
import java.sql.SQLException;

import com.poussu.studymate.databasehandler.ConnectionManager;
import com.poussu.studymate.databasehandler.DatabaseUpdater;
import com.poussu.studymate.databasehandler.UserManager;
import com.poussu.studymate.userdata.User;

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

    @Test
    public void userManagerNoUserFound() throws SQLException {
        UserManager um = new UserManager();
        User user = um.getLoggedUser("TestAdmin123", "1234");
        assertNull(user.getName());
    }

    @Test
    public void userManagerUserFound() throws Exception {
        Connection conn = ConnectionManager.getConnection();
        DatabaseUpdater db = new DatabaseUpdater();
        String input = "INSERT INTO Users(email, name, password) VALUES (?,?,?)";
        String[] values = {"testAdmin@gmail.com", "TestAdmin", "1234"};
        db.databaseInsert(conn, input, values);

        UserManager um = new UserManager();
        User user = um.getLoggedUser("TestAdmin", "1234");
        assertEquals("TestAdmin", user.getName());
    }
}

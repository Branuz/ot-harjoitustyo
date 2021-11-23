package com.poussu.studymate;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class loginTest {
    static Login login;
    static DataBaseConnection db;

    @Before
    public void setUp(){
        login = new Login();
        db = new DataBaseConnection();
        String setup = "CREATE TABLE Users (id INTEGER PRIMARY KEY, email TEXT, name TEXT, password TEXT)";
        db.connect(setup, "CREATE", new String[0]);

        String input = "INSERT INTO Users(email, name, password) VALUES (?,?,?)";
        String[] values = {"Admin@gmail.com", "Admin", "1234"};
        db.connect(input, "INSERT", values);
    }

    @Test
    public void userIsFoundInDbWithName(){
        assertTrue(login.checkLoginDetails("Admin", "1234"));
    }
    @Test
    public void notAddedUserIsNotFound(){
        assertFalse(login.checkLoginDetails("Markka", "23123"));
    }
}

package org.example.stepdefinition;

import io.cucumber.java.*;
import org.example.driversandhelpers.Driver;

import static org.example.constants.URL.LOGIN_PAGE_URL;

public class Hooks extends Driver {
    @Before
    public void setUp(){
        String browserName = "chrome";
        String url = LOGIN_PAGE_URL;
        initializeDriver(browserName, url);
    }

    @After
    public void tearDown(){
        quitDriver();
    }
}

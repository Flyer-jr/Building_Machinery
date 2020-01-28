package com.fly.servlets.add;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class addNewUser extends HttpServlet {

    @Override
    protected void doPost ( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        createUser(req, resp);


    }
}

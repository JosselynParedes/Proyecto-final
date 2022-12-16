package com.cybertools.collegeServlet;

import com.cybertools.collegeController.ControllerLogin;
import com.cybertools.collegeController.DAOLogin;
import com.cybertools.collegeModel.ModelUsers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
@MultipartConfig
public class ServletLogin extends HttpServlet {

    private static final Gson objGson = new GsonBuilder().serializeNulls().create();
    private static final DAOLogin<ModelUsers> dao = new ControllerLogin();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelUsers mu = objGson.fromJson(formData, ModelUsers.class);
        boolean login = dao.login(mu);
        if(login){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            response.sendRedirect("Introduction.jsp");
        }else {
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelUsers mu = objGson.fromJson(formData, ModelUsers.class);
        boolean register = dao.register(mu);
        if(register){
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10*60);
            response.sendRedirect("Introduction.jsp");
        }else {
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }

    }
}

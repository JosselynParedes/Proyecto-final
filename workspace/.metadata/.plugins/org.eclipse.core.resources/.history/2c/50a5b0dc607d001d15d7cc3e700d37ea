package com.cybertools.collegeServlet;

//@author jpjar

import com.cybertools.collegeController.*;
import com.cybertools.collegeModel.ModelTeachers;
import com.google.gson.*;
import java.io.*;
import java.util.List;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "TeachersServlet", urlPatterns = "/teachers")
@MultipartConfig
 
public class ServletTeachers extends HttpServlet{
    
    private static final Gson objGson = new GsonBuilder().serializeNulls().create();
    private static final DAO<ModelTeachers> dao = new ControllerTeachers();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        List<ModelTeachers> list = dao.read();
        String data = objGson.toJson(list);        
        out.write(data);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String formData = objGson.toJson(request.getParameterMap()); 
        formData = formData.replaceAll("[\\[\\]]", ""); 
        ModelTeachers mt = objGson.fromJson(formData, ModelTeachers.class);
        boolean create = dao.create(mt);
        if(create){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelTeachers mt = objGson.fromJson(formData, ModelTeachers.class);
        boolean update = dao.update(mt);
        if(update){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelTeachers mt = objGson.fromJson(formData, ModelTeachers.class);
        boolean del = dao.delete(mt);
        if(del){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }

}

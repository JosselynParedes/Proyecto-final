package com.cybertools.collegeServlet;

//@author jpjar

import com.cybertools.collegeController.*;
import com.cybertools.collegeModel.ModelCareers;
import com.google.gson.*;
import java.io.*;
import java.util.List;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet(name = "CareersServlet", urlPatterns = "/careers")
@MultipartConfig
 
public class ServletCareers extends HttpServlet {
    
    private static final Gson objGson = new GsonBuilder().serializeNulls().create();
    private static final DAO<ModelCareers> dao = new ControllerCareers();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        List<ModelCareers> list = dao.read();
        String data = objGson.toJson(list);        
        out.write(data);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String formData = objGson.toJson(request.getParameterMap()); 
        formData = formData.replaceAll("[\\[\\]]", ""); 
        ModelCareers mc = objGson.fromJson(formData, ModelCareers.class);
        boolean create = dao.create(mc);
        if(create){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelCareers mc = objGson.fromJson(formData, ModelCareers.class);
        boolean update = dao.update(mc);
        if(update){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelCareers mc = objGson.fromJson(formData, ModelCareers.class);
        boolean del = dao.delete(mc);
        if(del){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }

}

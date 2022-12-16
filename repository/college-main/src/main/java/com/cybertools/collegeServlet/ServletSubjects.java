package com.cybertools.collegeServlet;

//@author jpjar

import com.cybertools.collegeController.*;
import com.cybertools.collegeModel.ModelSubjects;
import com.google.gson.*;
import java.io.*;
import java.util.List;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

@WebServlet("/subjects")
@MultipartConfig
 
public class ServletSubjects extends HttpServlet{
    
    private static final Gson objGson = new GsonBuilder().serializeNulls().create();
    private static final DAO<ModelSubjects> dao = new ControllerSubjects();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("test");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        List<ModelSubjects> list = dao.read();
        String data = objGson.toJson(list);        
        out.write(data);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String formData = objGson.toJson(request.getParameterMap()); //optiene todos los datos de una sola vez
        formData = formData.replaceAll("[\\[\\]]", ""); //remplaza simbolos de request
        ModelSubjects mSt = objGson.fromJson(formData, ModelSubjects.class);//se convierte al objeto para eso se usa el .class
        boolean create = dao.create(mSt);
        if(create){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelSubjects mSt = objGson.fromJson(formData, ModelSubjects.class);
        boolean update = dao.update(mSt);
        if(update){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelSubjects mSt = objGson.fromJson(formData, ModelSubjects.class);
        boolean del = dao.delete(mSt);
        if(del){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }

}

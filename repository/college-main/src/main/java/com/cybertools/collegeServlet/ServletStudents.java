package com.cybertools.collegeServlet;

//@author jpjar

import com.cybertools.collegeController.*;
import com.cybertools.collegeModel.ModelStudents;
import com.google.gson.*;
import java.io.*;
import java.util.List;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;


@WebServlet(name = "StudentsServlet", urlPatterns = "/students")
@MultipartConfig

public class ServletStudents extends HttpServlet{
    
    private static final Gson objGson = new GsonBuilder().serializeNulls().create();
    private static final DAO<ModelStudents> dao = new ControllerStudents();
    
    //Obtiene datos del servidor
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        List<ModelStudents> list = dao.read();
        String data = objGson.toJson(list);        
        out.write(data);
    }
    
    //Crea datos en el server
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String formData = objGson.toJson(request.getParameterMap()); //optiene todos los datos de una sola vez
        formData = formData.replaceAll("[\\[\\]]", ""); //remplaza simbolos de request
        ModelStudents mSt = objGson.fromJson(formData, ModelStudents.class);//se convierte al objeto para eso se usa el .class
        boolean create = dao.create(mSt);
        if(create){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
    
    //Actualiza datos del server
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelStudents mSt = objGson.fromJson(formData, ModelStudents.class);
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
        ModelStudents mSt = objGson.fromJson(formData, ModelStudents.class);
        boolean del = dao.delete(mSt);
        if(del){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }

}

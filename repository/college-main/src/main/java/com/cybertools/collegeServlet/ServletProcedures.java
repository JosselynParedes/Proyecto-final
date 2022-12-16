package com.cybertools.collegeServlet;

import com.cybertools.collegeController.ControllerProcedures;
import com.cybertools.collegeController.DAOProcedures;
import com.cybertools.collegeModel.ModelStudents;
import com.google.gson.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProceduresServlet", urlPatterns = "/procedures/correoEst")
@MultipartConfig
public class ServletProcedures extends HttpServlet{

    private static final Gson objGson = new GsonBuilder().serializeNulls().create();

    private static final DAOProcedures<ModelStudents> dao = new ControllerProcedures();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String formData = objGson.toJson(request.getParameterMap());
        formData = formData.replaceAll("[\\[\\]]", "");
        ModelStudents ms = objGson.fromJson(formData, ModelStudents.class);
        String result = dao.correoEst(ms);
        PrintWriter out = response.getWriter();
        if(result != null){
            response.setStatus(HttpServletResponse.SC_OK);
            out.write(result);
        }else{
            response.sendError(HttpServletResponse.SC_CONFLICT);
        }
    }
}

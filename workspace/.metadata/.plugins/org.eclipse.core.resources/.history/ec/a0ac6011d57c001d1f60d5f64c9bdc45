package com.cybertools.collegeController;

//@author jpjar

import com.cybertools.collegeCBDD.CBDD;
import com.cybertools.collegeModel.ModelSubjects;
import java.sql.*;
import java.util.*;
 
public class ControllerSubjects implements DAO<ModelSubjects>{
    
    static Connection conn = CBDD.getConnection();
    
    @Override
    public List<ModelSubjects> read() {
        List<ModelSubjects> listSubjects = new ArrayList<>();
        try {
            String query = "SELECT * FROM subjects";
            ResultSet rs = conn.createStatement().executeQuery(query);
            while (rs.next()){
               ModelSubjects ms = new ModelSubjects();
               ms.setIdSubjects(rs.getInt(1));
               ms.setNameSubjects(rs.getString(2));
               listSubjects.add(ms);
            }
        }catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return listSubjects;
    }
    
    @Override
    public boolean create(ModelSubjects t) {        
        try {
            String query = "INSERT INTO subjects (nameSubjects) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, t.getNameSubjects());
            return ps.executeUpdate() != 0; //si no se ejecuta
        }catch (Exception ex) {
            ex.printStackTrace(System.out);
        }   
        return false; //retorna el falso
    }
    
    @Override
    public boolean update(ModelSubjects t) {       
        try {
            String query = "UPDATE subjects SET nameSubjects=? WHERE idSubjects=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(2, t.getIdSubjects());
            ps.setString(1, t.getNameSubjects());
            return ps.executeUpdate() != 0;
        }catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        return false;
    }
    
    @Override
    public boolean delete(ModelSubjects t) {    
        try {
            String query = "DELETE FROM subjects WHERE idSubjects=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, t.getIdSubjects());
            System.out.println(t);
            System.out.println(ps.toString());
            return ps.executeUpdate() != 0;
        }catch (Exception ex) {
            ex.printStackTrace(System.out);
        }   
        return false;
    }

}

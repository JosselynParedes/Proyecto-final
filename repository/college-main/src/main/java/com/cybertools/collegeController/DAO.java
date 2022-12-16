package com.cybertools.collegeController;

//@author jpjar

import java.util.List;

public interface DAO <T>{
    //DAO de tipo, en la T recibe cualquier objeto
    List <T> read();
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);

}

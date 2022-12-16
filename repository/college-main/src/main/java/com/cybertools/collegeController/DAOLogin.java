package com.cybertools.collegeController;

public interface DAOLogin <T> {

    boolean login(T t);
    boolean register(T t);
}

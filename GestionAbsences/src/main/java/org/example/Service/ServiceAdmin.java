package org.example.Service;


import org.example.DAO.AdminDao;
import org.example.DAO.AdminDaoImp;
import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImp;
import org.example.Model.Apprenant;
import org.example.Model.Formateur;
import org.example.Model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceAdmin {

    public static void main(String[] args) throws SQLException {
//        //Users user = new Users("KHOUILID ABDELKBIR", "ABDO@ABDO@", "A","Formateur");
//        Users user = new Users();
//        user.setEmail("e@e");
//        user.setPassword("s");
//        user.setId(4);
//        UserDao newUser = new UserDaoImp();
//        System.out.println(newUser.update(user));


        Apprenant apprenant = new Apprenant(2,1, 2, 1);
//        Formateur formateur =new Formateur(1, 2, 2);


        AdminDao setap = new AdminDaoImp();
        System.out.println(setap.updateApprenent(apprenant));

    }

}

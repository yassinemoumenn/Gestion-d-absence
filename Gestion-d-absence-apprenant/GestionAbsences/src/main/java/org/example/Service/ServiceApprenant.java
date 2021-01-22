package org.example.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import org.example.DAO.*;
import org.example.Model.StudentV2;
import org.example.Model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceApprenant {
    public ObservableList<StudentV2> collectApprenants(String type) throws SQLException, ClassNotFoundException {
        ObservableList<StudentV2> users = FXCollections.observableArrayList();
        UserDao dataSet = new UserDaoImp();
        ResultSet rs = dataSet.getByType(type);
        while (rs.next()) {
            ApprenantDao appre = new ApprenantDaoImp();
            ResultSet apprenant = appre.getById(rs.getInt(1));
            if (apprenant.next()) {
                ClassesDAO clas = new ClassesDAOImpl();
                ResultSet cla = clas.getClassById(apprenant.getInt("classe_id"));
                if (cla.next()) {
                    StudentV2 usr = new StudentV2(rs.getInt(1), rs.getString("full_name"), rs.getString("email"), cla.getString("classe"));
                    users.add(usr);
                }
            }
        }
        return users;
    }
}

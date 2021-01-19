package org.example.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImp;
import org.example.Model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceApprenant {


    public ObservableList<Users> collectApprenants() throws SQLException {
        ObservableList<Users> users = FXCollections.observableArrayList();
        UserDao dataSet = new UserDaoImp();
        ResultSet rs = dataSet.getByType("Apprenant");
        while (rs.next()) {
            Users usr = new Users(rs.getString("full_name"), rs.getString("email"), rs.getString("password"), rs.getString("type"));
             users.add(usr);
        }
        return users;
    }
}

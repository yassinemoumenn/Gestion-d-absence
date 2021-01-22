package org.example.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImp;
import org.example.Model.Users;
import org.example.Model.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ServiceApprenant {
    public ObservableList<Users> collectApprenants(String type) throws SQLException {
        ObservableList<Users> users = FXCollections.observableArrayList();

//        Map<Users,classes> map = new HashMap<Users,classes>();
//
//        ObservableMap<Users,classes> observableMap = FXCollections.observableMap(map);

        UserDao dataSet = new UserDaoImp();
        ResultSet rs = dataSet.getByType(type);
        while (rs.next()) {
            Users usr = new Users(rs.getString("full_name"), rs.getString("email"), rs.getString("password"), rs.getString("type"));
            usr.setId(rs.getInt(1));


            users.add(usr);
        }
        return users;
    }
}

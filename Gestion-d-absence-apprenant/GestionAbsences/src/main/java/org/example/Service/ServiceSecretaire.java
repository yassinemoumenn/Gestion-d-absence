package org.example.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImp;
import org.example.Model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceSecretaire {
    public ObservableList<Users> collectSecretiare(String type) throws SQLException, ClassNotFoundException, SQLException {
        ObservableList<Users> users = FXCollections.observableArrayList();
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

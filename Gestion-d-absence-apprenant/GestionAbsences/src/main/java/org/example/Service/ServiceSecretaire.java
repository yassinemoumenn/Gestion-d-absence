package org.example.Service;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImp;
import org.example.Model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceSecretaire {
    private ObservableList<Users> collectSecretiare(String type) throws SQLException, ClassNotFoundException, SQLException {
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

    public void display(String type, TableColumn name, TableColumn email, TableView<Users> table) throws SQLException, ClassNotFoundException {
        name.setCellValueFactory(new PropertyValueFactory<>("full_name"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        table.setItems(this.collectSecretiare(type));
    }
}

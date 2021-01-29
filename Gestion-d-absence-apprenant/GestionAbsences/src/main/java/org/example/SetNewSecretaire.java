package org.example;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.DAO.ClassesDAO;
import org.example.DAO.ClassesDAOImpl;
import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImp;
import org.example.Model.Users;

import java.sql.SQLException;

public class SetNewSecretaire {
    public TextField email;
    public TextField Name;
    public PasswordField password;

    public void setUserFormateur(MouseEvent mouseEvent) throws SQLException {
        if (!email.getText().equals("") && !Name.getText().equals("") && !password.getText().equals("")) {
            UserDao usr = new UserDaoImp();
            Users nUser = new Users(Name.getText(), email.getText(), password.getText(), "Secretaire");
            usr.create(nUser);
            AdminPanel.stage.close();
        }

    }
}

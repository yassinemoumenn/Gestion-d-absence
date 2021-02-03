package org.example;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.DAO.ClassesDAO;
import org.example.DAO.ClassesDAOImpl;
import org.example.DAO.UserDao;
import org.example.DAO.UserDaoImp;
import org.example.Model.Users;
import org.example.Service.ServiceUser;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class SetNewSecretaire {
    public TextField email;
    public TextField Name;
    public PasswordField password;
    public Label msgField;
    private static final Pattern pattern = Pattern.compile("^[A-Za-z]\\w{5,29}$");


    public void setUserFormateur(MouseEvent mouseEvent) throws SQLException {


        if (!email.getText().equals("") && !Name.getText().equals("") && !password.getText().equals("")) {
            if (email.getText().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$") && pattern.matcher(Name.getText()).matches()) {
                UserDao usr = new UserDaoImp();
                Users nUser = new Users(Name.getText(), email.getText(), ServiceUser.hashPassord(password.getText()), "Secretaire");
                usr.create(nUser);
                AdminPanel.stage.close();

            }else{
                msgField.setVisible(true);
                msgField.setText("Please verify your infos ");
            }

        }

    }
}

package org.example.DAO;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import org.example.Model.Absences;
        import org.example.Model.AffichageStudent;
        import org.example.MysqlConnect.Connexion;
        import java.sql.*;
        import java.util.Objects;

public  class FormateurDaoImp extends Connexion implements FormateurDao{

    Statement statement=null;

    @Override
    public ResultSet get_By_id(int id) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return null;
    }
    @Override
    public String setAbsence(Absences absences) throws SQLException {
        return null;
    }



    @Override
    public ObservableList<AffichageStudent> AfficheStudentName() {
        ObservableList<AffichageStudent> AbsenceStudents= FXCollections.observableArrayList();
        Connection conn = null;
        try {
            String requete= "SELECT full_name FROM users,students WHERE users.id=students.user_id AND type=\"student\"";
            PreparedStatement statement = Objects.requireNonNull(connect()).prepareStatement(requete);
            ResultSet rs = statement.executeQuery();
            AffichageStudent affichageStudent;
            while (rs.next()) {
                affichageStudent = new  AffichageStudent(rs.getString("full_name"));
                AbsenceStudents.add(affichageStudent);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (conn  != null) {
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return AbsenceStudents;
    }
}


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

    public void setAbsence(Absences Absence_type) {

        Connection conn = null;
        try{
            String requete = "INSERT INTO absences (`absence_type`,`student_id` ) VALUES (?)";
            PreparedStatement statement =  Objects.requireNonNull(connect()).prepareStatement(requete);
            statement.setInt(1,Absence_type.getAbsence_type());
            statement.executeUpdate();

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }



    @Override
    public ObservableList<AffichageStudent> AfficheStudentName() {
        ObservableList<AffichageStudent> AbsenceStudents= FXCollections.observableArrayList();
        Connection conn = null;
        try {
            String requete= "SELECT u.full_name, t.type FROM Users u INNER JOIN Students s ON u.id = s.user_id INNER JOIN Absences a ON s.id = a.Student_id INNER JOIN Absence_type t ON t.id = a.Absence_type WHERE u.type = 'Apprenant'";
            PreparedStatement statement = Objects.requireNonNull(Connexion.connect()).prepareStatement(requete);
            ResultSet rs = statement.executeQuery();
            AffichageStudent affichageStudent;
            while (rs.next()) {
                affichageStudent = new AffichageStudent(rs.getString("full_name"),rs.getString("type"));
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


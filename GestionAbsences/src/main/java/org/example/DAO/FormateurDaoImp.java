package org.example.DAO;

        import javafx.collections.FXCollections;
        import javafx.collections.ObservableList;
        import org.example.Model.Absence_type;
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

    public void UpdateAbsence(int student_id, int absence_type) {

        Connection conn = null;
        try{
            String requete= "select * from absences where Student_id = ?";
            PreparedStatement statement = Objects.requireNonNull(Connexion.connect()).prepareStatement(requete);
            statement.setInt(1, student_id);
            ResultSet rs = statement.executeQuery();
            boolean exists = false;
            while (rs.next()) {
                exists = true;
            }
            if (exists) {
                String rq = "update absences set Absence_type = ? where Student_id = ?";
                PreparedStatement st = Objects.requireNonNull(connect()).prepareStatement(rq);
                st.setInt(2, student_id);

                st.setInt(1, absence_type);

                st.executeUpdate();
            } else {
                String rq = "INSERT INTO `absences`( `Student_id`, `date`, `Absence_type`) VALUES (?,NOW(),?)";
                PreparedStatement st = Objects.requireNonNull(connect()).prepareStatement(rq);
                st.setInt(1, student_id);
                st.setInt(2, absence_type);

                st.execute();
            }

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
    public ObservableList<Absence_type> GetTypes() {
        ObservableList<Absence_type> AbsencesTypes= FXCollections.observableArrayList();
        Connection conn = null;
        try {
            String requete= "SELECT  id , type AS type_ab FROM absence_type";
            PreparedStatement statement = Objects.requireNonNull(Connexion.connect()).prepareStatement(requete);
            ResultSet rs = statement.executeQuery();
            Absence_type type;
            while (rs.next()) {
                //System.out.println(rs.getInt("id"));
                //System.out.println(rs.getString("type_ab"));
                type = new Absence_type (rs.getInt("id"),rs.getString("type_ab")) ;
                AbsencesTypes.add(type);
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
        return AbsencesTypes;
    }



    @Override
    public ObservableList<AffichageStudent> AfficheStudentName() {
        ObservableList<AffichageStudent> AbsenceStudents = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            String requete= "SELECT DISTINCT s.id, u.full_name, COALESCE(t.type, 'Present') AS type_ab FROM users u INNER JOIN students s ON u.id = s.user_id left JOIN absences a ON s.id = a.student_id left JOIN absence_type t ON t.id = a.absence_type INNER JOIN teachers ts ON ts.classe_id =s.classe_id WHERE u.type = 'Apprenant'";
            PreparedStatement statement = Objects.requireNonNull(Connexion.connect()).prepareStatement(requete);
            ResultSet rs = statement.executeQuery();
            AffichageStudent affichageStudent;
            while (rs.next()) {
                System.out.println(rs.getString("full_name"));
                System.out.println(rs.getString("type_ab"));
                affichageStudent = new AffichageStudent(rs.getInt("id") ,rs.getString("full_name"),rs.getString("type_ab"));
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


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


    public class CommentDAO {
        private static final String URL = "jdbc:mysql://localhost:3306/vertinimo_sistema";
        private static final String PASS = "";
        private static final String USER = "root";


        public static void createNewTableComments(){
            String query = "CREATE TABLE IF NOT EXISTS Comment(" +
                    "comment_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "user_id INT," +
                    "company_id INT," +
                    "comment TEXT," +
                    "FOREIGN KEY (user_id) REFERENCES User(user_id)," +
                    "FOREIGN KEY (company_id) REFERENCES Company(company_id))";

            try{
                Connection connection = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.executeUpdate();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        public static void createNewComment(Comment comment){
            String query ="INSERT INTO Comment(user_id, company_id, comment) VALUES (?,?,?)";

            try{
                Connection connection = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1,comment.getUserId());
                preparedStatement.setInt(2,comment.getCompanyId());
                preparedStatement.setString(3,comment.getComment());
                preparedStatement.executeUpdate();

            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        public static void updateCommentById(int id, String comment){
            String query = "UPDATE Comment SET comment = ? WHERE comment_id = ?";

            try{
                Connection connection = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1,comment);
                preparedStatement.setInt(2,id);

                preparedStatement.executeUpdate();


            }catch (SQLException e){
                e.printStackTrace();
            }
        }



    }




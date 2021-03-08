import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/vertinimo_sistema";
    private static final String PASS = "";
    private static final String USER = "root";


    public static void createTableCompany() {
        String query = "CREATE TABLE IF NOT EXISTS Company(" +
                "company_id INT PRIMARY KEY AUTO_INCREMENT," +
                "company_name VARCHAR(255)" +
                ")";
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createNewCompany(String companyName) {
        String query = "INSERT INTO Company(company_name) VALUES(?)";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, companyName);


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

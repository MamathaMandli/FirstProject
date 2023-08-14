package CurdOperations;
import CurdOperations.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class DeleteData
{


        public void delete() throws SQLException {
            Connection connection = DatabaseConnection.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name");
            String name=sc.next();
            String query = "SELECT * FROM phone WHERE name = '" + name + "'";
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String deleteQuery = "delete from phone where name=?";
                PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                deleteStatement.setString(1, name);
                deleteStatement.executeUpdate();
                System.out.println("Contact deleted successfully!");
            }
            else {
                System.out.println("in the database this name is not there");

            }

        }
    }






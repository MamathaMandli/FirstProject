package CurdOperations;

import CurdOperations.DatabaseConnection;

import java.sql.*;
import java.util.Scanner;

public class UpdateData
{


        public void updateData() throws SQLException {
            Connection connection = DatabaseConnection.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("enter the name");
            String searchName = sc.next();
            String query = "SELECT * FROM phone WHERE name = '" + searchName + "'";
            Statement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                String updateQuery = "UPDATE phone SET  phonenumber = ? WHERE name=?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                System.out.println("Enter the phone number");
                int phonenumber=sc.nextInt();
                updateStatement.setInt(1, phonenumber);
                updateStatement.setString(2,searchName);
                int rowsUpdated = updateStatement.executeUpdate();
                System.out.println("updated successfully");

            }
            else{
                System.out.println("in the database this name is not there");
            }
        }
    }



package CurdOperations;

import CurdOperations.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchData
{

        public void searchName() throws SQLException {
            Connection connection = DatabaseConnection.getConnection();
            Scanner sc = new Scanner(System.in);
            Statement stmt = connection.createStatement();
            System.out.println("enter the name");
            String searchName = sc.next();
            String query = "SELECT * FROM phone WHERE name = '" + searchName + "'";
            ResultSet resultSet = stmt.executeQuery(query);
            if (resultSet.next()) {
                System.out.print(resultSet.getString(1)+" ");
                System.out.print(resultSet.getString(2)+" ");
                System.out.println(resultSet.getInt(3)+" ");
            } else {
                System.out.println("Name not found in the database.");
            }

        }
    }






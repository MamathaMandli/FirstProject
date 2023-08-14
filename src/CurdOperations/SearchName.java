package CurdOperations;

import CurdOperations.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchName
{

        public  void searchName() throws SQLException {
            Connection connection = DatabaseConnection.getConnection();
            Scanner sc = new Scanner(System.in);
            String checkQuery = "SELECT COUNT(*) FROM phone WHERE name = ?";
            PreparedStatement Statement = connection.prepareStatement(checkQuery);
            System.out.println("Enter the sno");
            int sno = sc.nextInt();
            System.out.println("Enter the name");
            String name = sc.next();
            Statement.setString(1, name);
            ResultSet check = Statement.executeQuery();
            check.next();
            int nameCount = check.getInt(1);
            if (nameCount > 0) {
                System.out.println("Name " + name + " already present in the database.");
            } else {
                System.out.println("Enter the phone number");
                int phone = sc.nextInt();
                String insertQuery = "INSERT INTO phone (sno,name,phone) VALUES (?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setInt(1, sno);
                insertStatement.setString(2, name);
                insertStatement.setInt(3, phone);
                insertStatement.executeUpdate();
                System.out.println("New record added successfully");
            }
            Statement.close();



        }

    }



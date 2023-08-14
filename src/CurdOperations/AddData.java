package CurdOperations;

import CurdOperations.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddData
{
        public void addData() throws SQLException {
            Connection connection = DatabaseConnection.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name");
            String name=sc.next();
            System.out.println("Enter the phone number");
            int phone=sc.nextInt();
            String query="insert into phone (name,phonenumber) values (?,?)";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,name);
            statement.setInt(2,phone);
            statement.executeUpdate();
            connection.close();
            statement.close();
            System.out.println("data inserted successfully");

        }
    }



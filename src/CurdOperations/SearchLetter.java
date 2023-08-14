package CurdOperations;

import CurdOperations.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchLetter
{


        public void fetchMethod() throws SQLException {
            Connection connection = DatabaseConnection.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the character");
            char starLetter = sc.next().charAt(0);
            String query = "SELECT No,name,phonenumber FROM  phone WHERE name LIKE '" + starLetter + "%'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ArrayList<String> phoneNumberList = new ArrayList<>();
                String No = resultSet.getString("No");
                String name = resultSet.getString("name");
                String phonenumber = resultSet.getString("phonenumber");
                String contact= No+","+name+","+phonenumber;
                // phoneNumberList.add(No+" "+name+" "+phonenumber);
                phoneNumberList.add(contact);
                System.out.println(phoneNumberList);
                //System.out.println(No + " " + name + " " + phonenumber);
                //list should be printed. [[],[],[]];
            }
            resultSet.close();
            statement.close();
            connection.close();

        }


    }








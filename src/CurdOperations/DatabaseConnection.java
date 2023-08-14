package CurdOperations;

import CurdOperations.AddData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection
{

     public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "admin");
        }

        public static void main(String[] args) {
            try {
                Scanner sc = new Scanner(System.in);
                int choice;
                do {
                    System.out.println("1 \t Insert the data");
                    System.out.println("2 \t update the data");
                    System.out.println("3 \t delete the data");
                    System.out.println("4 \t search name ");
                    System.out.println("5 \t search first letter");
                    System.out.println("Enter the choice");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1: {
                            CurdOperations.AddData addData = new AddData();
                            addData.addData();
                            break;
                        }
                        case 2: {
                            UpdateData update = new UpdateData();
                            update.updateData();
                            break;
                        }
                        case 3: {
                            DeleteData deleteData = new DeleteData(); //delete the data with name not id
                            deleteData.delete();
                            break;
                        }
                        case 4: {
                            SearchName searchData = new SearchName();
                            searchData.searchName();
                            break;
                        }

                        case 5: {
                            SearchLetter search = new SearchLetter();
                            search.fetchMethod();
                            break;
                        }
                    }

                } while (choice != 0);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }


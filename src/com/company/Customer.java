package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Customer {
    String firstName, lastName, birthDate, email,phoneNumber,creditcard,creditcardType;


    public void createCustomer(PreparedStatement statement, Connection connect,ResultSet resultSet) throws SQLException {
        firstName = Dialog.dialogString("Please write your first name:");
        lastName = Dialog.dialogString("Please write your last name: ");
        birthDate = Dialog.dialogString("Please write your birth year: ");
        email = Dialog.dialogString("Please write your email: ");
        phoneNumber = Dialog.dialogString("Please write your phone number: ");
        creditcardType = Dialog.dialogString("Please write your creditcard type: ");

        try {
            statement = connect.prepareStatement("INSERT INTO Customer(First_Name, Last_Name, Birth_Date, Email, Phone_Number, Creditcard_Type)VALUES(?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, birthDate);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
            statement.setString(6, creditcardType);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            statement = connect.prepareStatement("SELECT * FROM Customer WHERE First_Name = ? AND Last_Name = ? AND Birth_Date = ? AND Email = ? AND Phone_Number = ? AND Creditcard_Type = ?");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, birthDate);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
            statement.setString(6, creditcardType);
            resultSet = statement.executeQuery();
            System.out.println("Customer was added successfully!");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");

            while (resultSet.next()) {
                String query =
                        "First Name: " + " " + resultSet.getString("First_Name") +
                                "\nLast Name: " + " " + resultSet.getString("Last_Name") +
                                "\nBirth year: " + " " + resultSet.getString("Birth_Date") +
                                "\nPhone Number: " + " " + resultSet.getString("Phone_Number") +
                                "\nCredit card type: " + " " + resultSet.getString("Creditcard_Type") +
                                "\nCustomer ID: " + " " + resultSet.getInt("Customer_Id");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception e ){
            e.printStackTrace();
        }
    }

        public void editCustomerInfo(PreparedStatement statement, Connection connect, ResultSet resultSet){ // fixa klart
        int customerId = Dialog.dialog("Please select a customer ID: ");
        System.out.println("You chose" + " "+ customerId);

        System.out.println("Please update following information:");

        firstName = Dialog.dialogString("Please write your first name:");
        lastName = Dialog.dialogString("Please write your last name: ");
        birthDate = Dialog.dialogString("Please write your birth year: ");
        email = Dialog.dialogString("Please write your email: ");
        phoneNumber = Dialog.dialogString("Please write your phone number: ");
        creditcardType = Dialog.dialogString("Please write your creditcard type: ");
        try {
            statement = connect.prepareStatement("UPDATE Customer SET First_Name = ?, Last_Name = ?, Birth_Date = ?, Email = ?, Phone_Number = ?, Creditcard_Type = ? WHERE Customer_Id = ? " );
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, birthDate);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
            statement.setString(6, creditcardType);
            statement.setInt(7,customerId);
            statement.executeUpdate();

        }
        catch (Exception e ){
            e.printStackTrace();
        }

    }

    public void removeCustomer(PreparedStatement statement, Connection connect, ResultSet resultSet){  // inte klar
         int customerIdChoice = Dialog.dialog("Please choose a customer ID: ");
        try {
            statement = connect.prepareStatement("DELETE FROM Customer WHERE Customer_Id = ?");
            statement.setInt(1, customerIdChoice);
            statement.executeUpdate();
            System.out.println(" Customer " + customerIdChoice + " was successfully removed.");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void searchCustomer(PreparedStatement statement, Connection connect, ResultSet resultSet){
        String customerFirstName = Dialog.dialogString("Please write the customer's first name: ");
        String customerLastName = Dialog.dialogString("Please write the customer's last name: ");
        try {
            statement = connect.prepareStatement("SELECT * FROM Customer WHERE First_Name = ? AND Last_Name = ?");
            statement.setString(1,customerFirstName);
            statement.setString(2,customerLastName);
            resultSet = statement.executeQuery();
            System.out.println("Following customer(s) where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            boolean searchCustomer = false;
            while(resultSet.next()){

            String query = ("First name: " + customerFirstName +
                        "\nLast Name: " + customerLastName + "\nBirth year: " + resultSet.getString("Birth_Date")+ ", " +
                    "\nCredit card type: " + resultSet.getString("Creditcard_Type") +
                    "\nCustomer ID: " + resultSet.getString("Customer_Id"));
            System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                searchCustomer = true;
            }
            if (!searchCustomer){
                System.out.println("The customer you searched for could not be found.");
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

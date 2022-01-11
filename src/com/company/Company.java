package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Company {
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String birthDate;

    public void addCompany(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException { // lägg till customer menu
        int customerId = Dialog.dialog("Please type in customer ID you would like to add company to:");

        int companyAmount = Dialog.dialog("How many people would you like to add as company?");

        for(int i = 0; i < companyAmount; i++) {

            String firstName = Dialog.dialogString("Please type in your company's first name:");
            String lastName = Dialog.dialogString("Please type in your company's last name: ");
            String email = Dialog.dialogString("Please type in your company's email: ");
            String phoneNumber = Dialog.dialogString("Please type in your company's phone number: ");
            String birthDate = Dialog.dialogString("Please type in your company's birthyear: ");

            statement = connect.prepareStatement("INSERT INTO Company( First_Name, Last_Name, Email, Phone_Number, Birth_Date, Customer_Id ) VALUES(?, ?, ?, ?, ?, ?)");
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.setString(5, birthDate);
            statement.setInt(6, customerId);
            statement.executeUpdate();
        }
    }

    public void findCompany(PreparedStatement statement, Connection connect, ResultSet resultSet){
        int customerId = Dialog.dialog("Please type in customer ID:");
        System.out.println("Searching after company for customer " + customerId);

        try {
            statement = connect.prepareStatement("SELECT * FROM Company WHERE Customer_Id = ?");
            statement.setInt(1,customerId);
            resultSet = statement.executeQuery();
            System.out.println("Following company where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            boolean findCompany = false;
            while(resultSet.next()){
                String query = "First name: " + (resultSet.getString("First_Name") + "\nLast name: "
                        + resultSet.getString("Last_Name") + "\nCompany ID: " + resultSet.getString("Company_Id") +
                        "\nBirth year: " + resultSet.getString("Birth_Date") +
                        "\nCustomer ID: "+ resultSet.getString("Customer_Id"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                findCompany = true;
            }
            if (!findCompany){
                System.out.println("The company you searched for could not be found.");
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /*public void viewAllCompany(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM Company");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
            String query = "First Name: " + " " + resultSet.getString("First_Name") +
                    "\nLast Name: " + " " + resultSet.getString("Last_Name") +
                   "\nBirth year: " + " " + resultSet.getString("Birth_Date")+
                    "\nPhone Number: " + " " + resultSet.getString("Phone_Number") +
                    " \nCompany ID: " + " " + resultSet.getInt("Company_Id");
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }
    }*/

    public void editCompanyInformation(PreparedStatement statement, Connection connect, ResultSet resultSet){
        int companyId = Dialog.dialog("Please select a company ID: ");
        System.out.println("You chose Company ID: " + companyId);

        System.out.println("Update following information please:");

        firstName = Dialog.dialogString("Please write your first name:");
        lastName = Dialog.dialogString("Please write your last name: ");
        birthDate = Dialog.dialogString("Please write your birth year: ");
        email = Dialog.dialogString("Please write your email: ");
        phoneNumber = Dialog.dialogString("Please write your phone number:");
        try {
            statement = connect.prepareStatement("UPDATE Company SET First_Name = ?, Last_Name = ?, Birth_Date = ? , Email = ? , Phone_Number = ? WHERE Company_Id = ? " );
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, birthDate);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
            statement.setInt(6,companyId);
            statement.executeUpdate();
        }
        catch (Exception e ){
            e.printStackTrace();
        }

    }

    /*public void removeCompany(PreparedStatement statement, Connection connect, ResultSet resultSet){

        int companyAmount = Dialog.dialog("How many companies would you like to remove ?");

        for(int i = 0; i < companyAmount; i++) {
            int companyIdChoice = Dialog.dialog("Please choose a company ID: ");
            try {
                statement = connect.prepareStatement("DELETE FROM Company WHERE Company_Id = ?");
                statement.setInt(1, companyIdChoice);
                statement.executeUpdate();
                System.out.println("Company " + companyIdChoice + " was successfully removed.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }*/


}

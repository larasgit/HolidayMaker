package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Booking {

    public void createBooking(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int bookingId = Dialog.dialog("Please type in your booking ID: ");
        int customerId = Dialog.dialog("Please type in your customer ID: ");
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");

        statement = connect.prepareStatement("UPDATE Booking SET Customer_Id = ?, Start_Date = ?, End_Date = ? WHERE Booking_Id = ?");
        statement.setInt(1, customerId);
        statement.setString(2, startDate);
        statement.setString(3, endDate);
        statement.setInt(4, bookingId);
        statement.executeUpdate();

    }

    public void editBooking(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int bookingId = Dialog.dialog("Please type in your booking ID: ");
        int customerId = Dialog.dialog("Please type in your customer ID: ");
        String startDate = Dialog.dialogString("Please update the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please update the end date of your reservation (YYYY-MM-DD): ");

        statement = connect.prepareStatement("UPDATE Booking SET Customer_Id = ?, Start_Date = ?, End_Date = ? WHERE Booking_Id = ?");
        statement.setInt(1, customerId);
        statement.setString(2, startDate);
        statement.setString(3, endDate);
        statement.setInt(4, bookingId);
        statement.executeUpdate();

    }

    public void removeBooking(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int bookingId = Dialog.dialog("Please type in the booking ID for the reservation you want to delete: ");

        statement = connect.prepareStatement("DELETE FROM Booking  WHERE Booking_Id = ?");
        statement.setInt(1, bookingId);
        statement.executeUpdate();

    }

    public void searchBookings(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("PLEASE TYPE IN FOLLOWING INFORMATION TO FIND YOUR RESERVATION:");
        String customerFirstName = Dialog.dialogString("Please write the Customer's first name: ");
        String customerLastName = Dialog.dialogString("Please write the Customer's last name: ");
        try {
            statement = connect.prepareStatement("SELECT * FROM Customer WHERE First_Name = ? AND Last_Name = ?");
            statement.setString(1, customerFirstName);
            statement.setString(2, customerLastName);
            resultSet = statement.executeQuery();
            System.out.println("Following customer(s) where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while (resultSet.next()) {
                String query = ("First name: " + customerFirstName +
                        "\nLast Name: " + customerLastName + "\nBirth year: " + resultSet.getString("Birth_Date") +
                         "\nCredit card Type: "+ resultSet.getString("Creditcard_Type") +
                        "\nCustomer ID: " + resultSet.getString("Customer_Id"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
                int customerId = Dialog.dialog("Please select a customer ID: ");
                statement = connect.prepareStatement("SELECT * FROM ViewBookings WHERE Customer_Id = ?");
                statement.setInt(1, customerId);
                resultSet = statement.executeQuery();

                System.out.println("Following reservations where found: ");
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                while (resultSet.next()) {
                    String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                            "\nCheck in date: " + resultSet.getString("Start_Date") +
                            "\nCheck out date: " + resultSet.getString("End_Date") +
                            "\nHotel room: " + resultSet.getInt("Hotel_Rooms_Id") +
                            "\nHotel name: " + resultSet.getString("Hotel_Name") +
                            "\nCity: " + resultSet.getString("City") +
                            "\nReview: " + resultSet.getInt("Review")
                            + "\nCustomer first name: " + resultSet.getString("First_Name")
                            + "\nCustomer last name: " + resultSet.getString("Last_Name")+
                            "\nCustomer ID: " + resultSet.getInt("Customer_Id") +
                            "\nCompany ID: " + resultSet.getInt("Company_Id")
                            + "\nBed type: " + resultSet.getString("Bed_Name")
                            + "\nExtra: " + resultSet.getString("Extras_Alt"));
                    System.out.println(query);
                    System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                }
            }

    public void availableRooms(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRooms ");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                        "\nCheck in date: " + resultSet.getString("Start_Date") +
                        "\nCheck out date: " + resultSet.getString("End_Date") +
                        "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                        "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Bed_Price")+
                        "\nBed type: "+ resultSet.getString("Bed_Name"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }



    public void allBookedRooms(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM ViewBookings ");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                        "\nCheck in date: " + resultSet.getString("Start_Date") +
                        "\nCheck out date: " + resultSet.getString("End_Date") +
                        "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                        "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nReview: "+ resultSet.getString("Review")
                        +"\nCustomer first name: "+ resultSet.getString("First_Name")
                        +"\nCustomer last name: "+ resultSet.getString("Last_Name")+
                        "\nCustomer ID: " + resultSet.getInt("Customer_Id"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void availableRoomsGothenburg(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsGothenburg");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                        "\nCheck in date: " + resultSet.getString("Start_Date") +
                        "\nCheck out date: " + resultSet.getString("End_Date") +
                        "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                        "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Bed_Price") +
                         "\nBed type: "+ resultSet.getString("Bed_Name"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void availableRoomsStockholm(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsStockholm");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                        "\nCheck in date: " + resultSet.getString("Start_Date") +
                        "\nCheck out date: " + resultSet.getString("End_Date") +
                        "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                        "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Bed_Price")+
                        "\nBed type: "+ resultSet.getString("Bed_Name"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void availableRoomsLulea(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsLulea");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                        "\nCheck in date: " + resultSet.getString("Start_Date") +
                        "\nCheck out date: " + resultSet.getString("End_Date") +
                        "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                        "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Bed_Price")+
                        "\nBed type: "+ resultSet.getString("Bed_Name"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void availableRoomsMalmo(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsMalmo");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                        "\nCheck in date: " + resultSet.getString("Start_Date") +
                        "\nCheck out date: " + resultSet.getString("End_Date") +
                        "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                        "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Bed_Price")+
                        "\nBed type: "+ resultSet.getString("Bed_Name"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public void availableRoomsSkovde(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsSkovde");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                        "\nCheck in date: " + resultSet.getString("Start_Date") +
                        "\nCheck out date: " + resultSet.getString("End_Date") +
                        "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                        "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Bed_Price")+
                        "\nBed type: "+ resultSet.getString("Bed_Name"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void addOrEditFullBoard(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int hotelRoomsId = Dialog.dialog("Please type in your hotel room number: ");
        int extrasId = Dialog.dialog("Please type in your customer ID: ");

        statement = connect.prepareStatement("UPDATE Hotel_Rooms SET Extras_Id = ? WHERE Hotel_Rooms_Id = ?");
        statement.setInt(1, extrasId);
        statement.setInt(2, hotelRoomsId);
        statement.executeUpdate();

    }

    public void addOrEditHalfBoard(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int hotelRoomsId = Dialog.dialog("Please type in your hotel room number: ");
        int extrasId = Dialog.dialog("Please type in your customer ID: ");

        statement = connect.prepareStatement("UPDATE Hotel_Rooms SET Extras_Id = ? WHERE Hotel_Rooms_Id = ?");
        statement.setInt(1, extrasId);
        statement.setInt(2, hotelRoomsId);
        statement.executeUpdate();

    }

    public void addOrEditExtraBed(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int hotelRoomsId = Dialog.dialog("Please type in your hotel room number: ");
        int extrasId = Dialog.dialog("Please type in your customer ID: ");

        statement = connect.prepareStatement("UPDATE Hotel_Rooms SET Extras_Id = ? WHERE Hotel_Rooms_Id = ?");
        statement.setInt(1, extrasId);
        statement.setInt(2, hotelRoomsId);
        statement.executeUpdate();

    }

    public void addOrEditNone(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int hotelRoomsId = Dialog.dialog("Please type in your hotel room number: ");
        int extrasId = Dialog.dialog("Please type in your customer ID: ");

        statement = connect.prepareStatement("UPDATE Hotel_Rooms SET Extras_Id = ? WHERE Hotel_Rooms_Id = ?");
        statement.setInt(1, extrasId);
        statement.setInt(2, hotelRoomsId);
        statement.executeUpdate();

    }


    //göra bokningar
    // & ta bort bokningar
    // & ändra bokningar
    // se alla lediga rum


}

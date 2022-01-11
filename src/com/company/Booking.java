package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Booking {
    int bookingId,customerId,hotelRoomsId;
    String startDate, endDate;


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

    public void availableRoomsActivities(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        try {
            statement = connect.prepareStatement("SELECT * FROM AvailableRoomsWithExtras");
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
                        "\nEvening entertainment: "+ resultSet.getBoolean("Evening_Entertainment")+
                        "\nKids Club: "+ resultSet.getBoolean("Kids_Club")+
                        "\nPool: "+ resultSet.getBoolean("Pool")+
                        "\nRestaurant: "+ resultSet.getBoolean("Restaurant"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void searchBookingsPt1(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
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
                        "\nLast Name: " + customerLastName + "\nBirth year: " + resultSet.getString("Birth_Date") + "\nCredit card: "
                        + resultSet.getString("Creditcard") + ", " + resultSet.getString("Creditcard_Type") +
                        "\nCustomer ID: " + resultSet.getString("Customer_Id"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
            }

            public void searchBookingsPt2(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {

                int customerId = Dialog.dialog("Please select a customer ID: ");
                statement = connect.prepareStatement("SELECT * FROM BookedRooms WHERE Customer_Id = ?");
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
                            "\nCompany ID: " + resultSet.getInt("Company_Id"));
                    System.out.println(query);
                    System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                }
            }

    public void availableRoomsFullboard(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsFullBoard ");
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
                        "\nAlternative: "+ resultSet.getString("Extras_Alt")+
                        "\nExtra Price: "+ resultSet.getInt("Extra_Price"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void availableRoomsHalfBoard(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsHalfBoard ");
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
                        "\nAlternative: "+ resultSet.getString("Extras_Alt")
                +"\nExtras price: "+ resultSet.getInt("Extra_Price"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void availableRoomsExtraBed(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsExtraBed ");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                        "\nCheck in date: " + resultSet.getString("Start_Date") +
                        "\nCheck out date: " + resultSet.getString("End_Date") +
                        "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                        "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                        "\nCity: "+ resultSet.getString("City")
                        +
                        "\nRoom price: "+ resultSet.getString("Bed_Price")+
                        "\nAlternative: "+ resultSet.getString("Extras_Alt")
                        +"\nExtra Price: "+ resultSet.getInt("Extra_Price"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void allAvailableRooms(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRooms");
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
                        "\nAlternative: "+ resultSet.getString("Extras_Alt")+
                        "\nTotal price: "+ resultSet.getString("Price"));
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
            statement = connect.prepareStatement("SELECT * FROM BookedRooms ");
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

    public void emptyRoomsWithoutExtras(PreparedStatement statement, Connection connect, ResultSet resultSet){
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsWithoutExtras");
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
                        "\nAlternative: "+ resultSet.getString("Extras_Alt")
                        +"\nExtra Price: "+ resultSet.getInt("Extra_Price"));
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
                        "\nRoom price: "+ resultSet.getString("Bed_Price"));
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
                        "\nRoom price: "+ resultSet.getString("Bed_Price"));
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
                        "\nRoom price: "+ resultSet.getString("Bed_Price"));
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
                        "\nRoom price: "+ resultSet.getString("Bed_Price"));
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
                        "\nRoom price: "+ resultSet.getString("Bed_Price"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //göra bokningar
    // & ta bort bokningar
    // & ändra bokningar
    // se alla lediga rum


}

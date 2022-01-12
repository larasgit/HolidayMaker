package com.company;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Booking {
    String startDate;
    String endDate;
    Menu menu;

    public void createBooking(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int roomId = Dialog.dialog("Please type in the room number: ");
        int customerId = Dialog.dialog("Please type in your customer ID: ");

        statement = connect.prepareStatement("INSERT INTO Booking (Customer_Id,Start_Date,End_Date,Hotel_Rooms_Id) VALUES(?,?,?,?)");
        statement.setInt(1, customerId);
        statement.setString(2, startDate);
        statement.setString(3, endDate);
        statement.setInt(4, roomId);
        statement.executeUpdate();

    }

    public void editBooking(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        String newStartDate = Dialog.dialogString("Please type in new check-in date (YYYY-MM-DD:");
        String newEndDate = Dialog.dialogString("Please type in new check-in date (YYYY-MM-DD:");

        try {
            statement = connect.prepareStatement("SELECT * FROM AllRoomsBookedAndAvailable WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM AllRoomsBookedAndAvailable\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, newStartDate);
            statement.setString(2, newEndDate);
            statement.setString(3, newStartDate);
            statement.setString(4, newEndDate);
            statement.executeQuery();
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            statement = connect.prepareStatement("SELECT * FROM AvailableRooms");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query =
                        "Hotel room: "+ resultSet.getInt("RoomNumber")+
                                "\nHotel name: "+ resultSet.getString("HotelName") +
                                "\nCity: "+ resultSet.getString("City")+
                                "\nRoom price: "+ resultSet.getString("Price")+
                                "\nBed type: "+ resultSet.getString("BedType");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        int roomId = Dialog.dialog("Please type in the room number you would like to book: ");
        int customerId = Dialog.dialog("Please type in your customer ID: ");
        statement = connect.prepareStatement("UPDATE Booking SET Start_Date = ?, End_Date = ?, Hotel_Rooms_Id = ? WHERE Customer_Id =?");
        statement.setString(1, newStartDate);
        statement.setString(2, newEndDate);
        statement.setInt(3, roomId);
        statement.setInt(4, customerId);
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
       String customerFirstName = Dialog.dialogString("Please write the customer's first name: ");
       String customerLastName = Dialog.dialogString("Please write the customer's last name: ");
        try {
            statement = connect.prepareStatement("SELECT * FROM Customer WHERE First_Name = ? AND Last_Name = ?");
            statement.setString(1, customerFirstName);
            statement.setString(2, customerLastName);
            resultSet = statement.executeQuery();
            System.out.println("Following customer(s) where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            boolean searchCustomer = false;
            while (resultSet.next()) {
                String query = ("First name: " + customerFirstName +
                        "\nLast Name: " + customerLastName + "\nBirth year: " + resultSet.getString("Birth_Date") +
                         "\nCredit card Type: "+ resultSet.getString("Creditcard_Type") +
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
              int customerFound = Dialog.dialog("Was a customer found? " +
                "\n(1) Yes.  (2) No. ", 1, 2);

        if(customerFound == 1) {
            int customerId = Dialog.dialog("Please select a customer ID: ");
            statement = connect.prepareStatement("SELECT * FROM ViewBookings WHERE Customer_Id = ?");
            statement.setInt(1, customerId);
            resultSet = statement.executeQuery();

            System.out.println("Following reservations where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            boolean searchBooking = false;
            while (resultSet.next()) {
                String query = "Customer ID: " + resultSet.getString("Customer_Id") +
                        "\nCustomer first name: " + resultSet.getString("First_Name") +
                        "\nCustomer last name: " + resultSet.getString("First_Name") +
                        "\nBooking ID: " + resultSet.getString("Booking_Id") +
                        "\nHotel room: " + resultSet.getInt("Hotel_Rooms_Id") +
                        "\nHotel name: " + resultSet.getString("Hotel_Name") +
                        "\nCity: " + resultSet.getString("City") +
                        "\nBed type: " + resultSet.getString("Bed_Name") +
                        "\nRoom price: " + resultSet.getString("Bed_Price");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                searchBooking = true;
            }
            if (!searchBooking) {
                System.out.println("The reservation you searched for could not be found.");
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }
        }
        if(customerFound== 2){
            menu.bookingMenu(statement,connect,resultSet);
        }
            }

    public void availableRooms(PreparedStatement statement, Connection connect, ResultSet resultSet){
        startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");
        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM AllRoomsBookedAndAvailable WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM AllRoomsBookedAndAvailable\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try {
            statement = connect.prepareStatement("SELECT * FROM AvailableRooms");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query =
                        "Hotel room: "+ resultSet.getInt("RoomNumber")+
                        "\nHotel name: "+ resultSet.getString("HotelName") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Price")+
                        "\nBed type: "+ resultSet.getString("BedType");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if (!availablerooms){
            System.out.println("There are no available rooms found during requested dates.");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
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
                        "\nCustomer first name: "+ resultSet.getString("First_Name")
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
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");

        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsGothenburg WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM EmptyRoomsGothenburg\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();

            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsGothenburg");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Hotel room: "+ resultSet.getInt("RoomNumber")+
                        "\nHotel name: "+ resultSet.getString("HotelName") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Price")+
                        "\nBed type: "+ resultSet.getString("BedType");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if(!availablerooms){
            System.out.println("There are no available rooms during your requested date.");
        }

    }

    public void availableRoomsStockholm(PreparedStatement statement, Connection connect, ResultSet resultSet){
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");

        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsStockholm WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM EmptyRoomsStockholm\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();

            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsStockholm");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Hotel room: "+ resultSet.getInt("RoomNumber")+
                        "\nHotel name: "+ resultSet.getString("HotelName") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Price")+
                        "\nBed type: "+ resultSet.getString("BedType");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if(!availablerooms){
            System.out.println("There are no available rooms during your requested date.");
        }
    }

    public void availableRoomsLulea(PreparedStatement statement, Connection connect, ResultSet resultSet){
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");

        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsLulea WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM EmptyRoomsLulea\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();

            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsLulea");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Hotel room: "+ resultSet.getInt("RoomNumber")+
                        "\nHotel name: "+ resultSet.getString("HotelName") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Price")+
                        "\nBed type: "+ resultSet.getString("BedType");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if(!availablerooms){
            System.out.println("There are no available rooms during your requested date.");
        }

    }

    public void availableRoomsMalmo(PreparedStatement statement, Connection connect, ResultSet resultSet){
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");

        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsMalmo WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM EmptyRoomsMalmo\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsMalmo");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Hotel room: "+ resultSet.getInt("RoomNumber")+
                        "\nHotel name: "+ resultSet.getString("HotelName") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Price")+
                        "\nBed type: "+ resultSet.getString("BedType");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if(!availablerooms){
            System.out.println("There are no available rooms during your requested date.");
        }

    }
    public void availableRoomsSkovde(PreparedStatement statement, Connection connect, ResultSet resultSet){
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");

        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsSkovde WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM EmptyRoomsSkovde\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();
            statement = connect.prepareStatement("SELECT * FROM EmptyRoomsSkovde");
            resultSet = statement.executeQuery();
            System.out.println("Following rooms where found: ");
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while(resultSet.next()){
                String query = "Hotel room: "+ resultSet.getInt("RoomNumber")+
                        "\nHotel name: "+ resultSet.getString("HotelName") +
                        "\nCity: "+ resultSet.getString("City")+
                        "\nRoom price: "+ resultSet.getString("Price")+
                        "\nBed type: "+ resultSet.getString("BedType");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        if(!availablerooms){
            System.out.println("There are no available rooms during your requested date.");
        }

    }

    public void addOrEditFullBoard(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int hotelRoomsId = Dialog.dialog("Please type in your hotel room number:");
        int extrasId = 1;

        statement = connect.prepareStatement("UPDATE Hotel_Rooms SET Extras_Id = ? WHERE Hotel_Rooms_Id = ?");
        statement.setInt(1, extrasId);
        statement.setInt(2, hotelRoomsId);
        statement.executeUpdate();

    }

    public void addOrEditHalfBoard(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int hotelRoomsId = Dialog.dialog("Please type in your hotel room number: ");
        int extrasId = 2;

        statement = connect.prepareStatement("UPDATE Hotel_Rooms SET Extras_Id = ? WHERE Hotel_Rooms_Id = ?");
        statement.setInt(1, extrasId);
        statement.setInt(2, hotelRoomsId);
        statement.executeUpdate();

    }

    public void addOrEditExtraBed(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int hotelRoomsId = Dialog.dialog("Please type in your hotel room number: ");
        int extrasId = 3;

        statement = connect.prepareStatement("UPDATE Hotel_Rooms SET Extras_Id = ? WHERE Hotel_Rooms_Id = ?");
        statement.setInt(1, extrasId);
        statement.setInt(2, hotelRoomsId);
        statement.executeUpdate();

    }

    public void addOrEditNone(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        int hotelRoomsId = Dialog.dialog("Please type in your hotel room number: ");
        int extrasId = 4;

        statement = connect.prepareStatement("UPDATE Hotel_Rooms SET Extras_Id = ? WHERE Hotel_Rooms_Id = ?");
        statement.setInt(1, extrasId);
        statement.setInt(2, hotelRoomsId);
        statement.executeUpdate();

    }

}

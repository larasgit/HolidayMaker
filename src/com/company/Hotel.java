package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Hotel {

    public void viewAllHotels(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM OurHotels");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
            String query =
                    "Hotel name: " + " " + resultSet.getString("Hotel_Name") +
                            "\nHotel city: " + " " + resultSet.getString("City")+
            "\nHas evening entertainment: " + " " + resultSet.getString("Evening_Entertainment")+
                            "\nHas restaurant: " + " " + resultSet.getString("Restaurant")+
                            "\nHas pool: " + " " + resultSet.getString("Pool")+
                            "\nHas kids Club: " + " " + resultSet.getString("Kids_Club");
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }

    }

    public void hotelCloseToCity(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM HotelDistanceCity");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
            String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                    "\nCheck in date: " + resultSet.getString("Start_Date") +
                    "\nCheck out date: " + resultSet.getString("End_Date") +
                    "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                    "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                    "\nCity: "+ resultSet.getString("City")+
                    "\nRoom price: "+ resultSet.getString("Bed_Price")+
                    "\nBed type: "+ resultSet.getString("Bed_Name")+
                    "\nDistance to city: "+ resultSet.getString("Distance_City"));
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            //KOLLA ÖVER KOLUMNER
        }

    }

    public void hotelCloseToBeach(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM HotelDistanceBeach");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
                    String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                    "\nCheck in date: " + resultSet.getString("Start_Date") +
                    "\nCheck out date: " + resultSet.getString("End_Date") +
                    "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                    "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                    "\nCity: "+ resultSet.getString("City")+
                    "\nRoom price: "+ resultSet.getString("Bed_Price")+
                    "\nBed type: "+ resultSet.getString("Bed_Name")+
                    "\nDistance to beach: "+ resultSet.getString("Distance_Beach"));
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }

    }

    public void hotelBasedOnReviews(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM OurHotelsReview");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
            String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                    "\nCheck in date: " + resultSet.getString("Start_Date") +
                    "\nCheck out date: " + resultSet.getString("End_Date") +
                    "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                    "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                    "\nCity: "+ resultSet.getString("City")+
                    "\nRoom price: "+ resultSet.getString("Bed_Price")+
                    "\nBed type: "+ resultSet.getString("Bed_Name")+
                    "\nRating: "+ resultSet.getString("Review"));
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");

        }

    }

    public void hotelBasedOnPrice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM OurHotelPrice");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
                    String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                    "\nCheck in date: " + resultSet.getString("Start_Date") +
                    "\nCheck out date: " + resultSet.getString("End_Date") +
                    "\nHotel room: "+ resultSet.getInt("Hotel_Rooms_Id")+
                    "\nHotel name: "+ resultSet.getString("Hotel_Name") +
                    "\nCity: "+ resultSet.getString("City")+
                    "\nBed type: "+ resultSet.getString("Bed_Name")+
                            "\nRoom price: "+ resultSet.getString("Bed_Price"));
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }

    }

    public void hotelBasedOnActivity(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM OurHotelActivity");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
            while (resultSet.next()) {
                String query = "Booking ID: " + (resultSet.getInt("Booking_Id") +
                        "\nCheck in date: " + resultSet.getString("Start_Date") +
                        "\nCheck out date: " + resultSet.getString("End_Date") +
                        "\nHotel room: " + resultSet.getInt("Hotel_Rooms_Id") +
                        "\nHotel name: " + resultSet.getString("Hotel_Name") +
                        "\nCity: " + resultSet.getString("City") +
                        "\nBed type: " + resultSet.getString("Bed_Name") +
                        "\nRoom price: " + resultSet.getString("Bed_Price") +
                        "\nHas pool: " + resultSet.getString("Pool") +
                        "\nHas restaurant: " + resultSet.getString("Restaurant") +
                        "\nHas evening entertainment: " + resultSet.getString("Evening_Entertainment") +
                        "\nHas kids-club: " + resultSet.getString("Kids_Club"));
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            }

        }


    }
}

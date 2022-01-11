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
                            "\nHotel City: " + " " + resultSet.getString("City")+
            "\nHas evening entertainment: " + " " + resultSet.getBoolean("Evening_Entertainment")+
                            "\nHas Restaurant: " + " " + resultSet.getBoolean("Restaurant")+
                            "\nHas Pool: " + " " + resultSet.getBoolean("Pool")+
                            "\nHas kids Club: " + " " + resultSet.getBoolean("Kids_Club");
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }

    }

    public void hotelCloseToCity(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM HotelDistanceCity");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
            String query =
                    "Hotel name: " + " " + resultSet.getString("Hotel_Name") +
                            "\nHotel City: " + " " + resultSet.getString("City")+
                            "\nDistance City: " + " " + resultSet.getString("Distance_City");
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }

    }

    public void hotelCloseToBeach(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM HotelDistanceBeach");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
            String query =
                    "Hotel name: " + " " + resultSet.getString("Hotel_Name") +
                            "\nHotel City: " + " " + resultSet.getString("City")+
                            "\nDistance City: " + " " + resultSet.getString("Distance_Beach");
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }

    }

    public void hotelBasedOnReviews(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM OurHotelsReview");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
            String query =
                    "Hotel name: " + " " + resultSet.getString("Hotel_Name") +
                            "\nHotel City: " + " " + resultSet.getString("City")+
                             "\nReviews: " + " " + resultSet.getString("Review");
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }

    }

    public void hotelBasedOnPrice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        statement = connect.prepareStatement("SELECT * FROM EmptyRooms");
        resultSet = statement.executeQuery();
        System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        while (resultSet.next()) {
            String query =
                    "Hotel name: " + " " + resultSet.getString("Hotel_Name") +
                            "\nHotel city: " + " " + resultSet.getString("City")+
                            "\nTotal price: " + " " + resultSet.getString("Price")
                            + "\nExtras: " + " " + resultSet.getString("Extras_Alt")
                            + "\nCheck in date: " + " " + resultSet.getString("Start_Date")
                            + "\nCheck out date: " + " " + resultSet.getString("End_Date")
                            + "\nBooking ID: " + " " + resultSet.getInt("Booking_Id")
                            + "\nHotel Rooms ID: " + " " + resultSet.getInt("Hotel_Rooms_Id");
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }

    }




}

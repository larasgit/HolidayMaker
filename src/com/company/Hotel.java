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
                            "\nHotel city: " + " " + resultSet.getString("City") +
                            "\nHas evening entertainment: " + " " + resultSet.getString("Evening_Entertainment") +
                            "\nHas restaurant: " + " " + resultSet.getString("Restaurant") +
                            "\nHas pool: " + " " + resultSet.getString("Pool") +
                            "\nHas kids Club: " + " " + resultSet.getString("Kids_Club");
            System.out.println(query);
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
        }

    }

    public void hotelCloseToCity(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");

        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM HotelDistanceCity WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM HotelDistanceCity\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();

            statement = connect.prepareStatement("SELECT * FROM HotelDistanceCity");
            resultSet = statement.executeQuery();

            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while (resultSet.next()) {
                String query = "Hotel room: " + resultSet.getInt("RoomNumber") +
                        "\nHotel name: " + resultSet.getString("HotelName") +
                        "\nCity: " + resultSet.getString("City") +
                        "\nRoom price: " + resultSet.getString("Price") +
                        "\nBed type: " + resultSet.getString("BedType") +
                        "\nRating: " + resultSet.getString("Review") +
                        "\nDistance to the city: " + resultSet.getString("CityDis");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!availablerooms) {
            System.out.println("There are no available rooms during your requested date.");
        }

    }

    public void hotelCloseToBeach(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");
        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM HotelDistanceBeach WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM HotelDistanceCity\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();

            statement = connect.prepareStatement("SELECT * FROM HotelDistanceBeach");
            resultSet = statement.executeQuery();
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while (resultSet.next()) {
                String query = "Hotel room: " + resultSet.getInt("RoomNumber") +
                        "\nHotel name: " + resultSet.getString("HotelName") +
                        "\nCity: " + resultSet.getString("City") +
                        "\nRoom price: " + resultSet.getString("Price") +
                        "\nBed type: " + resultSet.getString("BedType") +
                        "\nRating: " + resultSet.getString("Review") +
                        "\nDistance to beach: " + resultSet.getString("Review");

                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!availablerooms) {
            System.out.println("There are no available rooms during your requested date.");
        }

    }

    public void hotelBasedOnReviews(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");
        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM OurHotelsReview WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM OurHotelsReview\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();

            statement = connect.prepareStatement("SELECT * FROM OurHotelsReview");
            resultSet = statement.executeQuery();
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while (resultSet.next()) {
                String query = "Hotel room: " + resultSet.getInt("RoomNumber") +
                        "\nHotel name: " + resultSet.getString("HotelName") +
                        "\nCity: " + resultSet.getString("City") +
                        "\nRoom price: " + resultSet.getString("Price") +
                        "\nBed type: " + resultSet.getString("BedType") +
                        "\nRating: " + resultSet.getString("Review");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!availablerooms) {
            System.out.println("There are no available rooms during your requested date.");
        }
    }

    public void hotelBasedOnPrice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");
        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM OurHotelPrice WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM OurHotelPrice\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();

            statement = connect.prepareStatement("SELECT * FROM OurHotelPrice");
            resultSet = statement.executeQuery();
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while (resultSet.next()) {
                String query = "Hotel room: " + resultSet.getInt("RoomNumber") +
                        "\nHotel name: " + resultSet.getString("HotelName") +
                        "\nCity: " + resultSet.getString("City") +
                        "\nRoom price: " + resultSet.getString("Price") +
                        "\nBed type: " + resultSet.getString("BedType");
                System.out.println(query);
                System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                availablerooms = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!availablerooms) {
            System.out.println("There are no available rooms during your requested date.");
        }

    }

    public void hotelBasedOnActivity(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        String startDate = Dialog.dialogString("Please type in the start date of your reservation (YYYY-MM-DD): ");
        String endDate = Dialog.dialogString("Please type in the end date of your reservation (YYYY-MM-DD): ");
        boolean availablerooms = false;
        try {
            statement = connect.prepareStatement("SELECT * FROM OOurHotelActivity WHERE RoomNumber \n" +
                    "NOT IN(SELECT RoomNumber FROM OurHotelActivity\n" +
                    "WHERE StartDate BETWEEN ? AND ?)\n" +
                    "AND NOT (EndDate BETWEEN ? AND ?)\n" +
                    "OR StartDate IS NULL AND EndDate IS NULL\n" +
                    "GROUP BY RoomNumber");
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            statement.setString(3, startDate);
            statement.setString(4, endDate);
            statement.executeQuery();

            statement = connect.prepareStatement("SELECT * FROM OurHotelActivity");
            resultSet = statement.executeQuery();
            System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
            while (resultSet.next()) {
                while (resultSet.next()) {
                    String query = "Hotel room: " + resultSet.getInt("RoomNumber") +
                            "\nHotel name: " + resultSet.getString("HotelName") +
                            "\nCity: " + resultSet.getString("City") +
                            "\nRoom price: " + resultSet.getString("Price") +
                            "\nBed type: " + resultSet.getString("BedType") +
                            "\nHas pool: " + resultSet.getString("Pool") +
                            "\nHas restaurant: " + resultSet.getString("Restaurant") +
                            "\nHas evening entertainment: " + resultSet.getString("Evening") +
                            "\nHas kids-club: " + resultSet.getString("Kids");
                    System.out.println(query);
                    System.out.println("══════════════════════════════════════════════════════════════════════════════════════════ ");
                    availablerooms = true;
                }
            }
        }
        catch(Exception e){
                e.printStackTrace();
            }

            if (!availablerooms) {
                System.out.println("There are no available rooms during your requested date.");
            }
        }

    }
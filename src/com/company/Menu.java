package com.company;

import java.sql.*;
import java.util.Scanner;

//här ska menyerna byggas
public class Menu {

    Customer customer = new Customer();
    Booking booking = new Booking();
    Company company = new Company();
    Hotel hotel = new Hotel();

    public Menu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        mainMenu(statement, connect, resultSet);
    }

    public void mainMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("｡☆✼★━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━★✼☆｡\n" +
                "       ＷＥＬＣＯＭＥ ＴＯ ＨＯＬＩＤＡＹ ＭＡＫＥＲ" +
                "\n  ｡☆✼★━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━★✼☆｡");

        System.out.println("         ┌──────────    ───────────┐" +
                "\n           PLEASE SELECT AN OPTION " +
                "\n         └──────────    ───────────┘");

        System.out.println("╔══════════════════════════════════════════╗" +
                "\n (1)  Customer Menu.   " +
                "\n (2)  Booking Menu.   " +
                "\n (3)  Our Hotels.    " +
                "\n (4)  Exit Program. " +
                "\n╚══════════════════════════════════════════╝");
        mainMenuChoice(statement, connect, resultSet);

    }


    public void mainMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                customerMenu(statement, connect, resultSet); // back to main menu
                break;
            case "2":
                bookingMenu(statement,connect,resultSet);
                break;
            case "3":
                System.out.println("HERE ARE OUR HOTELS:");
                hotel.viewAllHotels(statement,connect,resultSet);
                mainMenu(statement,connect,resultSet);
                break;
            case "4":
                System.out.println("Exiting Holiday Maker....");
                System.exit(0); // leave application with no error
                break;
        }
    }


    public void customerMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("       ┌──────────    ───────────┐\n" +
                "              CUSTOMER MENU \n" +

                "       └──────────    ───────────┘");
        System.out.println("         PLEASE SELECT AN OPTION");

        System.out.println("╔══════════════════════════════════════════╗"+
                "\n (1)  Register customer." +
                "\n (2)  Update customer information.  " +
                "\n (3)  Update company information.  " +
                "\n (4)  Add Company. " +
                "\n (5)  Remove customer." +
                "\n (6)  Remove company.   " +
                "\n (7)  Search for a customer.  " +
                "\n (8)  Search for company.  " +
                "\n (9) Back to main menu. " +
                "\n╚══════════════════════════════════════════╝");
        customerMenuChoice(statement, connect, resultSet);
    }

    public void customerMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                System.out.println("YOU CHOSE TO REGISTER A CUSTOMER.  ");
                customer.createCustomer(statement, connect, resultSet); //create a new customer

                int choice1 = Dialog.dialog("Would you like to add company?" +
                        "\n (1) Yes.   (2) No. " , 1 ,2);

                if(choice1 == 1 ){
                    company.addCompany(statement,connect,resultSet);
                    System.out.println("Customer and company successfully added.");
                    customerMenu(statement,connect,resultSet);
                }
                else{
                    customerMenu(statement,connect,resultSet);
                }

                break;
            case "2":
                System.out.println("YOU CHOSE TO UPDATE CUSTOMER INFORMATION.  ");
                System.out.println("Please type in following information:");
                customer.searchCustomer(statement, connect, resultSet);// visar alla kunder.
                customer.editCustomerInfo(statement, connect, resultSet); //redigera kund info

                System.out.println("Customer information is now updated.");
                int choice2 = Dialog.dialog("Would you like to double check the updated information?" +
                        "\n (1) Yes.   (2) No. " , 1 ,2);

                if(choice2 == 1 ){
                    customer.searchCustomer(statement,connect,resultSet);
                    customerMenu(statement,connect,resultSet);
                }
                else{
                    customerMenu(statement,connect,resultSet);
                }

                break;

            case "3":
                System.out.println("YOU CHOSE TO UPDATE COMPANY INFORMATION.  ");
                System.out.println("Here are the current companies:");
                customer.searchCustomer(statement,connect,resultSet);
                company.editCompanyInformation(statement,connect,resultSet);

                int choice3 = Dialog.dialog("Would you like to double check the updated information?" +
                        "\n (1) Yes.   (2) No. " , 1 ,2);

                if(choice3 == 1 ){
                    company.findCompany(statement,connect,resultSet);
                    customerMenu(statement,connect,resultSet);
                }
                else{
                    customerMenu(statement,connect,resultSet);
                }
                break;

            case "4":
                System.out.println("YOU CHOSE TO ADD COMPANY.  ");
                System.out.println("Searching for customer to add company to...");
                customer.searchCustomer(statement,connect,resultSet);// visar alla customers.
                company.addCompany(statement, connect, resultSet); // lägger till company
                System.out.println("Company added successfully!");
                customerMenu(statement, connect, resultSet); // gå tillbaka till customer menu
                break;

            case "5":
                System.out.println("YOU CHOSE TO REMOVE A CUSTOMER.  ");
                System.out.println("Here are the current customers:");
                customer.searchCustomer(statement,connect,resultSet);
                customer.removeCustomer(statement, connect, resultSet); // tar bort vald customer
                System.out.println("Customer deleted successfully!");
                customerMenu(statement, connect, resultSet); // gå tillbaka till customer menu
                break;
            case "6":
                System.out.println("YOU CHOSE TO REMOVE COMPANY.  ");
                System.out.println("Please fill in the following information:");
                customer.searchCustomer(statement,connect,resultSet);
                company.findCompany(statement,connect,resultSet);// hittar sällskap
                company.removeCompany(statement, connect, resultSet); // tar bort vald customer
                customerMenu(statement, connect, resultSet); // gå tillbaka till customer menu
                break;

            case "7":
                System.out.println("YOU CHOSE TO SEARCH A CUSTOMER.  ");
                customer.searchCustomer(statement,connect,resultSet); // söker efter kund
                customerMenu(statement, connect, resultSet);
                break;

            case "8":
                System.out.println("YOU CHOSE TO SEARCH FOR COMPANY.  ");
                System.out.println("Please fill in the following information:");
                customer.searchCustomer(statement,connect,resultSet);
                company.findCompany(statement,connect,resultSet);//hittar sällskap
                customerMenu(statement, connect, resultSet);
                break;

            case "9":
                System.out.println("Taking you back to main menu...");
                mainMenu(statement, connect, resultSet);
                break;
        }
    }

    public void bookingMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("Booking menu:");

        System.out.println("(1) Make a reservation. (2) Edit reservation." +
                "\n (3)  Remove reservation. (4)  Search for reservation. (5) Back to main menu.  ");
        bookingMenuChoice(statement,connect,resultSet);
    }

    public void bookingMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                int choice3 = Dialog.dialog("Are you a new customer?" +
                        "\n (1) Yes.   (2) No. " , 1 ,2);

                if(choice3 == 1 ){
                    newCustomerReservationMenu(statement,connect,resultSet);
                }
                else{
                    existingCustomerMenu(statement,connect,resultSet);
                }
                break;
            case "2":
                System.out.println("YOU CHOSE TO EDIT A RESERVATION.");
                booking.searchBookings(statement,connect,resultSet);
                booking.editBooking(statement,connect,resultSet);
                int choice1 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice1 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice1 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice1 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was updated successfully.");
                bookingMenu(statement, connect, resultSet); // gå tillbaka till booking menu
                break;

            case "3":
                System.out.println("YOU CHOSE TO REMOVE A RESERVATION");
                booking.searchBookings(statement,connect,resultSet);
                booking.removeBooking(statement,connect,resultSet);
                System.out.println("Reservation deleted successfully.");
                bookingMenu(statement, connect, resultSet); // gå tillbaka till booking menu
                break;

            case "4":
                System.out.println("You choose to search for a reservation.");
                booking.searchBookings(statement,connect,resultSet); // söker efter bokning
                bookingMenu(statement, connect, resultSet); // går tillbaka till booking menu
                break;

            case "5":
                System.out.println("Taking you back to main menu...");
                mainMenu(statement, connect, resultSet);
                break;
        }
    }


    public void newCustomerReservationMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("Reservation menu:");

        System.out.println("(1) Make a reservation." +
                "\n(2) Make reservation in a specific city. " +
                "\n(3) Make a reservation based on reviews." +
                "\n(4) Make a reservation based on price." +
                "\n(5) Make a reservation based on distance to the city. " +
                "\n(6) Make a reservation based on distance to the beach. " +
                "\n(7) Make a reservation based on hotel activities. " +
                "\n(8) Back to booking menu.");
        newCostumerChoice(statement,connect,resultSet);
    }


    public void newCostumerChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                booking.availableRooms(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice1 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice1 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice1 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice1 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;
            case "2":
                cityMenu(statement,connect,resultSet);
                break;
            case "3":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelBasedOnReviews(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice2 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice2 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice2 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice2 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;
            case "4":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelBasedOnPrice(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice3 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice3 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice3 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice3 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "5":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelCloseToCity(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice4 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice4 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice4 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice4 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "6":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelCloseToBeach(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice5 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice5 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice5== 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice5 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "7":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelBasedOnActivity(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice6 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice6 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice6 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice6 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                break;
            case "8":
                System.out.println("Taking you back to booking menu...");
                bookingMenu(statement, connect, resultSet);
                break;
        }

    }

    public void cityMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("(1) Make reservation in Gothenburg. " +
                "\n(2) Make Reservation in Stockholm. " +
                "\n(3) Make Reservation in Luleå. " +
                "\n(4)  Make Reservation in Malmö. " +
                "\n(5)  Make Reservation in Skövde. " +
                "\n(6)  Go back to reservation menu. ");
        cityMenuChoice(statement,connect,resultSet);
    }


    public void cityMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.availableRoomsGothenburg(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice1 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice1 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice1 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice1 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "2":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.availableRoomsStockholm(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice2 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice2 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice2 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice2 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "3":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.availableRoomsLulea(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice3 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice3 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice3 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice3 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "4":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.availableRoomsMalmo(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice4 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice4 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice4 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice4 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "5":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.availableRoomsSkovde(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice5 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice5 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice5 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice5 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "6":
                System.out.println("Taking you back to reservation menu...");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

        }
    }

    public void existingCustomerMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("Reservation menu:");

        System.out.println("(1) Make a reservation." +
                "\n(2) Make reservation in a specific city. " +
                "\n(3) Make a reservation based on reviews." +
                "\n(4) Make a reservation based on price." +
                "\n(5) Make a reservation based on distance to the city. " +
                "\n(6) Make a reservation based on distance to the beach. " +
                "\n(7) Make a reservation based on hotel activities. " +
                "\n(8) Back to booking menu.");
        existingMenuChoice(statement,connect,resultSet);
    }
    public void existingMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                customer.searchCustomer(statement, connect, resultSet); //create a new customer
                booking.availableRooms(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice1 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice1 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice1 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice1 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;
            case "2":
                cityMenu2(statement,connect,resultSet);
                break;
            case "3":
                customer.searchCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelBasedOnReviews(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice2 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice2 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice2 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice2 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;
            case "4":
                customer.searchCustomer(statement, connect, resultSet);
                hotel.hotelBasedOnPrice(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice3 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice3 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice3 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice3 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "5":
                customer.searchCustomer(statement, connect, resultSet);
                hotel.hotelCloseToCity(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice4 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice4 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice4 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice4 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "6":
                customer.searchCustomer(statement, connect, resultSet);
                hotel.hotelCloseToBeach(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice5 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice5 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice5== 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice5 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "7":
                customer.searchCustomer(statement, connect, resultSet);
                hotel.hotelBasedOnActivity(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);
                int choice6 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice6 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice6 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice6 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                break;
            case "8":
                System.out.println("Taking you back to booking menu...");
                bookingMenu(statement, connect, resultSet);
                break;
        }


    }

    public void cityMenu2(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("(1) Make reservation in Gothenburg. " +
                "\n(2) Make Reservation in Stockholm. " +
                "\n(3) Make Reservation in Luleå. " +
                "\n(4)  Make Reservation in Malmö. " +
                "\n(5)  Make Reservation in Skövde. " +
                "\n(6)  Go back to reservation menu. ");
        cityMenuChoice2(statement,connect,resultSet);
    }

    public void cityMenuChoice2(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsGothenburg(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice1 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice1 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice1 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice1 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "2":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsStockholm(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice2 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice2 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice2 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice2 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "3":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsLulea(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice3 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice3 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice3 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice3 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "4":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsMalmo(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice4 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice4 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice4 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice4 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "5":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsSkovde(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice5 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  " , 1 ,2);

                if(choice5 == 1 ){
                    booking.addOrEditFullBoard(statement,connect,resultSet);
                }
                else if(choice5 == 2 ){
                    booking.addOrEditHalfBoard(statement,connect,resultSet);
                }
                else if(choice5 == 3 ){
                    booking.addOrEditExtraBed(statement,connect,resultSet);
                }
                else{
                    booking.addOrEditNone(statement,connect,resultSet);
                }
                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;
            case "6":
                System.out.println("Taking you back to reservation menu...");
                existingCustomerMenu(statement, connect, resultSet);
                break;


        }
    }


}

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
                bookingMenu(statement, connect, resultSet);
                break;
            case "3":
                System.out.println("HERE ARE OUR HOTELS:");
                hotel.viewAllHotels(statement, connect, resultSet);
                mainMenu(statement, connect, resultSet);
                break;
            case "4":
                System.out.println("Exiting Holiday Maker....");
                System.exit(0); // leave application with no error
                break;
        }
    }


    public void customerMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("       ┌──────────    ───────────┐" +
                "\n              CUSTOMER MENU " +

                "\n       └──────────    ───────────┘");
        System.out.println("         PLEASE SELECT AN OPTION");

        System.out.println("╔══════════════════════════════════════════╗" +
                "\n (1) Register customer." +
                "\n (2) Update customer information.  " +
                "\n (3) Update company information.  " +
                "\n (4) Add Company. " +
                "\n (5) Remove customer." +
                "\n (6) Search for a customer.  " +
                "\n (7) Search for company.  " +
                "\n (8) Back to main menu. " +
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
                        "\n (1) Yes.   (2) No. ", 1, 2);

                if (choice1 == 1) {
                    company.addCompany(statement, connect, resultSet);
                    System.out.println("Customer and company successfully added.");
                    customerMenu(statement, connect, resultSet);
                }
                    if (choice1 == 2) {
                    customerMenu(statement, connect, resultSet);}

                break;
            case "2":
                System.out.println("YOU CHOSE TO UPDATE CUSTOMER INFORMATION.  ");
                System.out.println("Please type in following information:");
                customer.searchCustomer(statement, connect, resultSet);// visar alla kunder.

                int choice5 = Dialog.dialog("Are there any customers displayed?" +
                        "\n (1) Yes.   (2) No. ", 1, 2);

                if (choice5 == 1) {
                    customer.editCustomerInfo(statement, connect, resultSet); //redigera kund info
                    System.out.println("Customer information is now updated.");
                    customerMenu(statement, connect, resultSet);
                }
                    if (choice5 == 2){
                    customerMenu(statement, connect, resultSet);
                }

                break;

            case "3":
                System.out.println("YOU CHOSE TO UPDATE COMPANY INFORMATION.  ");
                customer.searchCustomer(statement, connect, resultSet);
                int choice6 = Dialog.dialog("Are there any customers displayed?" +
                        "\n (1) Yes.   (2) No. ", 1, 2);
                if (choice6 == 1) {
                    company.findCompany(statement, connect, resultSet);
                    company.editCompanyInformation(statement, connect, resultSet);
                    System.out.println("Company information updated successfully.");
                    customerMenu(statement, connect, resultSet);
                } if (choice6 == 2) {
                    customerMenu(statement, connect, resultSet);
                }
                break;

            case "4":
                System.out.println("YOU CHOSE TO ADD COMPANY.  ");
                System.out.println("Searching for customer to add company to...");
                customer.searchCustomer(statement, connect, resultSet);// visar alla customers.

                int choice7 = Dialog.dialog("Are there any customers displayed?" +
                        "\n (1) Yes.   (2) No. ", 1, 2);
                if (choice7 == 1) {
                    company.addCompany(statement, connect, resultSet);
                    System.out.println("Company added successfully!");
                    customerMenu(statement, connect, resultSet);
                } if (choice7 == 2){
                    customerMenu(statement, connect, resultSet);
                }
                break;

            case "5":
                System.out.println("YOU CHOSE TO REMOVE A CUSTOMER.  ");
                customer.searchCustomer(statement, connect, resultSet);
                int choice8 = Dialog.dialog("Are there any customers displayed?" +
                        "\n (1) Yes.   (2) No. ", 1, 2);
                if (choice8 == 1) {
                    customer.removeCustomer(statement, connect, resultSet);
                    customerMenu(statement, connect, resultSet);
                } if (choice8 == 2) {
                    customerMenu(statement, connect, resultSet);
                }
                break;
            case "6":
                System.out.println("YOU CHOSE TO SEARCH FOR A CUSTOMER.  ");
                customer.searchCustomer(statement, connect, resultSet); // söker efter kund
                customerMenu(statement, connect, resultSet);
                break;

            case "7":
                System.out.println("YOU CHOSE TO SEARCH FOR COMPANY.  ");
                System.out.println("Please fill in the following information:");
                customer.searchCustomer(statement, connect, resultSet);
                int choice4 = Dialog.dialog("Are there any customers displayed?" +
                        "\n (1) Yes.   (2) No. ", 1, 2);

                if (choice4 == 1) {
                    company.findCompany(statement, connect, resultSet);//hittar sällskap
                    customerMenu(statement, connect, resultSet);
                } if (choice4 == 2){
                    customerMenu(statement, connect, resultSet);
                }
                break;

            case "8":
                System.out.println("Taking you back to main menu...");
                mainMenu(statement, connect, resultSet);
                break;
        }
    }

    public void bookingMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("       ┌──────────    ───────────┐" +
                "\n              BOOKING MENU " +

                "\n       └──────────    ───────────┘");
        System.out.println("         PLEASE SELECT AN OPTION");

        System.out.println("╔══════════════════════════════════════════╗" +
                "\n(1) Make a reservation. " +
                "\n(2) Edit reservation." +
                "\n(3) Remove reservation. " +
                "\n(4) Search for reservation. " +
                "\n(5) Back to main menu.  " +
                "\n╚══════════════════════════════════════════╝");
        bookingMenuChoice(statement, connect, resultSet);
    }

    public void bookingMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                int choice3 = Dialog.dialog("Are you a new customer?" +
                        "\n (1) Yes.   (2) No. ", 1, 2);

                if (choice3 == 1) {
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice3 == 2) {
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;
            case "2":
                System.out.println("YOU CHOSE TO EDIT A RESERVATION.");
                booking.searchBookings(statement, connect, resultSet);
                int choice4 = Dialog.dialog("Are there any reservations displayed?" +
                        "\n (1) Yes.   (2) No. ", 1, 2);

                if (choice4 == 1) {
                    booking.editBooking(statement, connect, resultSet);
                    int choice5 = Dialog.dialog("Please select one of the following extras:" +
                            "(1)\nFull board: Breakfast, lunch and dinner. (1000kr)" +
                            "\n(2) Half board: Breakfast and lunch. (750kr)" +
                            "\n(3) Extra bed: (150kr)." +
                            "\n(4) None. ", 1, 4);
                    if (choice5 == 1) {
                        booking.addOrEditFullBoard(statement, connect, resultSet);
                        System.out.println("Reservation was updated successfully.");
                        bookingMenu(statement, connect, resultSet);
                    }
                    if (choice5 == 2) {
                        booking.addOrEditHalfBoard(statement, connect, resultSet);
                        System.out.println("Reservation was updated successfully.");
                        bookingMenu(statement, connect, resultSet);
                    }
                    if (choice5 == 3) {
                        booking.addOrEditExtraBed(statement, connect, resultSet);
                        System.out.println("Reservation was updated successfully.");
                        bookingMenu(statement, connect, resultSet);
                    }
                    if (choice5 == 4) {
                        booking.addOrEditNone(statement, connect, resultSet);
                        System.out.println("Reservation was updated successfully.");
                        bookingMenu(statement, connect, resultSet);
                    }
                }
                if (choice4 == 2) {
                    bookingMenu(statement, connect, resultSet);
                }

                System.out.println("Reservation was updated successfully.");
                bookingMenu(statement, connect, resultSet); // gå tillbaka till booking menu
                break;

            case "3":
                System.out.println("YOU CHOSE TO REMOVE A RESERVATION");
                booking.searchBookings(statement, connect, resultSet);
                booking.removeBooking(statement, connect, resultSet);
                System.out.println("Reservation deleted successfully.");
                bookingMenu(statement, connect, resultSet); // gå tillbaka till booking menu
                break;

            case "4":
                System.out.println("You choose to search for a reservation.");
                booking.searchBookings(statement, connect, resultSet); // söker efter bokning
                bookingMenu(statement, connect, resultSet); // går tillbaka till booking menu
                break;

            case "5":
                System.out.println("Taking you back to main menu...");
                mainMenu(statement, connect, resultSet);
                break;
        }
    }


    public void newCustomerReservationMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("       ┌──────────    ───────────┐" +
                "\n            RESERVATION MENU " +

                "\n       └──────────    ───────────┘");
        System.out.println("         PLEASE SELECT AN OPTION");

        System.out.println("╔══════════════════════════════════════════╗" +
                "\n(1) View all empty rooms." +
                "\n(2) Make reservation in a specific city. " +
                "\n(3) Make a reservation based on reviews." +
                "\n(4) Make a reservation based on price." +
                "\n(5) Make a reservation based on distance to the city. " +
                "\n(6) Make a reservation based on distance to the beach. " +
                "\n(7) Make a reservation based on hotel activities. " +
                "\n(8) Back to booking menu." +
                "\n╚══════════════════════════════════════════╝");
        newCostumerChoice(statement, connect, resultSet);
    }


    public void newCostumerChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                booking.availableRooms(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice5 = Dialog.dialog("Please select one of the following extras:" +
                        "(1) Full board: Breakfast, lunch and dinner. (1000kr)" +
                        "\n(2) Half board: Breakfast and lunch. (750kr)" +
                        "\n(3) Extra bed: (150kr)." +
                        "\n(4) None. ", 1, 4);
                if (choice5 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice5 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice5 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice5 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;
            case "2":
                cityMenu(statement, connect, resultSet);
                break;
            case "3":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelBasedOnReviews(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice6 = Dialog.dialog("Please select one of the following extras:" +
                        "\n(1) Full board: Breakfast, lunch and dinner. (1000kr)" +
                        "\n(2) Half board: Breakfast and lunch. (750kr)" +
                        "\n(3) Extra bed: (150kr)." +
                        "\n(4) None. ", 1, 4);
                if (choice6 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice6 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice6 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice6 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;
            case "4":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelBasedOnPrice(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice10 = Dialog.dialog("Please select one of the following extras:" +
                        "\n(1) Full board: Breakfast, lunch and dinner. (1000kr)" +
                        "\n(2) Half board: Breakfast and lunch. (750kr)" +
                        "\n(3) Extra bed: (150kr)." +
                        "\n(4) None. ", 1, 4);
                if (choice10 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice10 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice10 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice10 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;

            case "5":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelCloseToCity(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice11 = Dialog.dialog("Please select one of the following extras:" +
                        "\n(1) Full board: Breakfast, lunch and dinner. (1000kr)" +
                        "\n(2) Half board: Breakfast and lunch. (750kr)" +
                        "\n(3) Extra bed: (150kr)." +
                        "\n(4) None. ", 1, 4);
                if (choice11 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice11 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice11 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice11 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;

            case "6":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelCloseToBeach(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice12 = Dialog.dialog("Please select one of the following extras:" +
                        "\n(1) Full board: Breakfast, lunch and dinner. (1000kr)" +
                        "\n(2) Half board: Breakfast and lunch. (750kr)" +
                        "\n(3) Extra bed: (150kr)." +
                        "\n(4) None. ", 1, 4);
                if (choice12 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice12 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice12 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice12 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;

            case "7":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelBasedOnActivity(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice13 = Dialog.dialog("Please select one of the following extras:" +
                        "\n(1) Full board: Breakfast, lunch and dinner. (1000kr)" +
                        "\n(2) Half board: Breakfast and lunch. (750kr)" +
                        "\n(3) Extra bed: (150kr)." +
                        "\n(4) None. ", 1, 4);
                if (choice13 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice13 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice13 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice13 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;
            case "8":
                System.out.println("Taking you back to booking menu...");
                bookingMenu(statement, connect, resultSet);
                break;
        }

    }

    public void cityMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("       ┌──────────    ───────────┐" +
                "\n         CITY RESERVATION MENU " +

                "\n       └──────────    ───────────┘");
        System.out.println("         PLEASE SELECT AN OPTION");
        System.out.println("╔══════════════════════════════════════════╗" +
                "\n(1) Make reservation in Gothenburg. " +
                "\n(2) Make Reservation in Stockholm. " +
                "\n(3) Make Reservation in Luleå. " +
                "\n(4) Make Reservation in Malmö. " +
                "\n(5) Make Reservation in Skövde. " +
                "\n(6) Go back to reservation menu. " +
                "\n╚══════════════════════════════════════════╝");
        cityMenuChoice(statement, connect, resultSet);
    }


    public void cityMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement, connect, resultSet);
                booking.availableRoomsGothenburg(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice14 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice14 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice14 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice14 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice14 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }

                break;
            case "2":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement, connect, resultSet);
                booking.availableRoomsStockholm(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice15 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice15 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice15 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice15 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice15 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;

            case "3":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement, connect, resultSet);
                booking.availableRoomsLulea(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice16 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice16 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice16 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice16 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice16 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;

            case "4":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement, connect, resultSet);
                booking.availableRoomsMalmo(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice17 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice17 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice17 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice17 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice17 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;

            case "5":
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement, connect, resultSet);
                booking.availableRoomsSkovde(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice18 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice18 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice18 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice18 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                if (choice18 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    newCustomerReservationMenu(statement, connect, resultSet);
                }
                break;

            case "6":
                System.out.println("Taking you back to reservation menu...");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;
        }
    }


    public void existingCustomerMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("       ┌──────────    ───────────┐" +
                "\n            RESERVATION MENU " +

                "\n       └──────────    ───────────┘");
        System.out.println("         PLEASE SELECT AN OPTION");
        System.out.println("╔══════════════════════════════════════════╗" +
                "\n(1) Make a reservation." +
                "\n(2) Make reservation in a specific city. " +
                "\n(3) Make a reservation based on reviews." +
                "\n(4) Make a reservation based on price." +
                "\n(5) Make a reservation based on distance to the city. " +
                "\n(6) Make a reservation based on distance to the beach. " +
                "\n(7) Make a reservation based on hotel activities. " +
                "\n(8) Back to booking menu." +
                "\n╚══════════════════════════════════════════╝");
        existingMenuChoice(statement, connect, resultSet);
    }

    public void existingMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                customer.searchCustomer(statement, connect, resultSet); //create a new customer
                booking.availableRooms(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice19 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice19 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice19 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice19 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice19 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;

            case "2":
                cityMenu2(statement, connect, resultSet);
                break;
            case "3":
                customer.searchCustomer(statement, connect, resultSet); //create a new customer
                hotel.hotelBasedOnReviews(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice20 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice20 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice20 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice20 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice20 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;
            case "4":
                customer.searchCustomer(statement, connect, resultSet);
                hotel.hotelBasedOnPrice(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice21 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice21 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice21 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice21 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice21 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;

            case "5":
                customer.searchCustomer(statement, connect, resultSet);
                hotel.hotelCloseToCity(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice22 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice22 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice22 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice22 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice22 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;

            case "6":
                customer.searchCustomer(statement, connect, resultSet);
                hotel.hotelCloseToBeach(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice23 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice23 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice23 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice23 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice23 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;

            case "7":
                customer.searchCustomer(statement, connect, resultSet);
                hotel.hotelBasedOnActivity(statement, connect, resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement, connect, resultSet);
                int choice24 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice24 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice24 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice24 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice24 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;
            case "8":
                System.out.println("Taking you back to booking menu...");
                bookingMenu(statement, connect, resultSet);
                break;
        }


    }

    public void cityMenu2(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("       ┌──────────    ───────────┐" +
                "\n              CITY RESERVATION MENU " +

                "\n       └──────────    ───────────┘");
        System.out.println("         PLEASE SELECT AN OPTION");
        System.out.println("╔══════════════════════════════════════════╗" +
                "\n(1) Make reservation in Gothenburg. " +
                "\n(2) Make Reservation in Stockholm. " +
                "\n(3) Make Reservation in Luleå. " +
                "\n(4)  Make Reservation in Malmö. " +
                "\n(5)  Make Reservation in Skövde. " +
                "\n(6)  Go back to reservation menu. " +
                "\n╚══════════════════════════════════════════╝");
        cityMenuChoice2(statement, connect, resultSet);
    }

    public void cityMenuChoice2(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsGothenburg(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice18 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice18 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice18 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice18 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice18 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;

            case "2":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsStockholm(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice19 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice19 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice19 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice19 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice19 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;

            case "3":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsLulea(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice20 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice20 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice20 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice20 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice20 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;

            case "4":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsMalmo(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice21 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice21 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice21 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice21 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice21 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;

            case "5":
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement, connect, resultSet);
                booking.availableRoomsSkovde(statement, connect, resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning
                int choice22 = Dialog.dialog("Please select one of the following additions:" +
                        "\n(1) Full board: breakfast, lunch, dinner (1000kr)   " +
                        "\n(2) Half board: breakfast and lunch (750kr) " +
                        "\n(3) Extra bed (150kr)" +
                        "\n(4) No addition.  ", 1, 4);

                if (choice22 == 1) {
                    booking.addOrEditFullBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice22 == 2) {
                    booking.addOrEditHalfBoard(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice22 == 3) {
                    booking.addOrEditExtraBed(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                if (choice22 == 4) {
                    booking.addOrEditNone(statement, connect, resultSet);
                    System.out.println("Reservation was made successfully.");
                    existingCustomerMenu(statement, connect, resultSet);
                }
                break;
            case "6":
                System.out.println("Taking you back to reservation menu...");
                existingCustomerMenu(statement, connect, resultSet);
                break;

        }

    }
}



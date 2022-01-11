package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;

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
                "\n (3)  Hotel Menu.    " +
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
                hotelMenu(statement,connect,resultSet);
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
                "\n (1)  Register customer with company." +
                "\n (2)  Register customer without company.  " +
                "\n (3)  Edit customer information.  " +
                "\n (4)  Edit company information.  " +
                "\n (5)  Add Company. " +
                "\n (6)  Remove customer." +
                "\n (7)  Remove company.   " +
                "\n (8)  Search for a customer.  " +
                "\n (9)  Search for company.  " +
                "\n (10) Back to main menu. " +
                "\n╚══════════════════════════════════════════╝");
        customerMenuChoice(statement, connect, resultSet);
    }

    public void customerMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                System.out.println("                          YOU CHOSE TO REGISTER A CUSTOMER WITH COMPANY.  ");
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                customer.viewAllCustomers(statement,connect,resultSet);
                company.addCompany(statement,connect,resultSet);
                System.out.println("                              Customer and company successfully added.");
                customerMenu(statement, connect, resultSet);
                break;
            case "2":
                System.out.println("                     ┌───────────────────────────    ────────────────────────────┐" +
                        " \n                           YOU CHOSE TO REGISTER A CUSTOMER WITHOUT COMPANY.  "+
                        " \n                     └───────────────────────────    ────────────────────────────┘");
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                System.out.println("                              Customer successfully added.");
                customerMenu(statement, connect, resultSet);
                break;
            case "3":
                System.out.println("                     ┌───────────────────────────    ────────────────────────────┐" +
                        " \n                              YOU CHOSE TO EDIT CUSTOMER INFORMATION.  "+
                        "" +
                        " \n                     └───────────────────────────    ────────────────────────────┘");
                System.out.println("                                  Here are the current customers:");
                customer.viewAllCustomers(statement, connect, resultSet);// visar alla kunder.
                customer.editCustomerInfo(statement, connect, resultSet); //redigera kund info

                System.out.println("                                  New customer information was added successfully.");
                customerMenu(statement, connect, resultSet);
                break;

            case "4":
                System.out.println("                     ┌───────────────────────────    ────────────────────────────┐" +
                        " \n                              YOU CHOSE TO EDIT COMPANY INFORMATION.  "+
                        "" +
                        " \n                     └───────────────────────────    ────────────────────────────┘");
                System.out.println("                                  Here are the current companies:");
                company.viewAllCompany(statement,connect,resultSet);// visar alla customers.
                company.editCompanyInformation(statement,connect,resultSet);

                System.out.println("                                  New company information was added successfully.");
                customerMenu(statement, connect, resultSet); // gå tillbaka till customer menu
                break;

            case "5":
                System.out.println("                     ┌───────────────────────────    ────────────────────────────┐" +
                        " \n                               YOU CHOSE TO ADD A COMPANY.  "+
                        "" +
                        " \n                     └───────────────────────────    ────────────────────────────┘");
                System.out.println("                                  Here are the current customers:");
                customer.viewAllCustomers(statement, connect, resultSet);// visar alla customers.
                company.addCompany(statement, connect, resultSet); // lägger till company
                System.out.println("Company added successfully!");

                customerMenu(statement, connect, resultSet); // gå tillbaka till customer menu
                break;

            case "6":
                System.out.println("                     ┌───────────────────────────    ────────────────────────────┐" +
                        " \n                               YOU CHOSE TO REMOVE A CUSTOMER.  "+
                        "" +
                        " \n                     └───────────────────────────    ────────────────────────────┘");
                System.out.println("                                  Here are the current customers:");
                customer.viewAllCustomers(statement, connect, resultSet);// visar alla customers.
                customer.removeCustomer(statement, connect, resultSet); // tar bort vald customer

                customerMenu(statement, connect, resultSet); // gå tillbaka till customer menu
                break;
            case "7":
                System.out.println("                     ┌───────────────────────────    ────────────────────────────┐" +
                        " \n                               YOU CHOSE TO REMOVE A COMPANY.  "+
                        "" +
                        " \n                     └───────────────────────────    ────────────────────────────┘");
                System.out.println("                                  Here are the current companies:");
                company.viewAllCompany(statement,connect,resultSet);// visar alla customers.
                company.removeCompany(statement, connect, resultSet); // tar bort vald customer

                customerMenu(statement, connect, resultSet); // gå tillbaka till customer menu
                break;

            case "8":
                System.out.println("                     ┌───────────────────────────    ────────────────────────────┐" +
                        " \n                               YOU CHOSE TO SEARCH FOR A CUSTOMER.  "+
                        "" +
                        " \n                     └───────────────────────────    ────────────────────────────┘");
                customer.searchCustomer(statement,connect,resultSet); // söker efter kund

                customerMenu(statement, connect, resultSet);
                break;

            case "9":
                System.out.println("                     ┌───────────────────────────    ────────────────────────────┐" +
                        " \n                                YOU CHOSE TO SEARCH A COMPANY.  "+
                        "" +
                        " \n                     └───────────────────────────    ────────────────────────────┘");
                System.out.println("                                  Here are the current customers:");
                customer.viewAllCustomers(statement, connect, resultSet);// visar alla customers.
                company.findCompany(statement,connect,resultSet);
                customerMenu(statement, connect, resultSet);
                break;

            case "10":
                System.out.println("                                                                Taking you back to main menu...");
                mainMenu(statement, connect, resultSet);
                break;
        }
    }

    public void bookingMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("Booking menu:");

        System.out.println("(1) Make a reservation as a new customer. (2) Make a reservation as existing customer. (3) Edit reservation." +
                "\n (4)  Remove reservation. (5)  Search for reservation. (6) Back to main menu.  ");
        bookingMenuChoice(statement,connect,resultSet);
    }

    public void bookingMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                newCustomerReservationMenu(statement,connect,resultSet);
                break;
            case "2":
                existingCustomerMenu(statement,connect,resultSet);
                break;
            case "3":
                System.out.println("You choose to edit a reservation.");
                System.out.println("Here are the current reservations:");
                booking.allBookedRooms(statement,connect,resultSet);
                booking.editBooking(statement,connect,resultSet);

                System.out.println("Reservation was updated successfully.");

                bookingMenu(statement, connect, resultSet); // gå tillbaka till booking menu
                break;

            case "4":
                System.out.println("You choose to remove a reservation.");
                System.out.println("Here are the current reservations:");
                booking.allBookedRooms(statement,connect,resultSet);
                booking.removeBooking(statement,connect,resultSet);
                System.out.println("Reservation deleted successfully.");
                bookingMenu(statement, connect, resultSet); // gå tillbaka till booking menu
                break;

            case "5":
                System.out.println("You choose to search for a reservation.");
                booking.searchBookingsPt1(statement,connect,resultSet); // söker efter bokning
                booking.searchBookingsPt2(statement,connect,resultSet);
                bookingMenu(statement, connect, resultSet); // går tillbaka till booking menu
                break;

            case "6":
                System.out.println("Taking you back to main menu...");
                mainMenu(statement, connect, resultSet);
                break;
        }
    }


    public void newCustomerReservationMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("Reservation menu:");

        System.out.println("(1) Make reservation with full board. (2) Make reservation with half board. (3) Make reservation with Extra bed." +
                "\n(4) Make reservation without extras.  (5)  Make reservation in a specific city. (6) Make random reservation. (7) Back to booking menu.  ");
        newCostumerChoice(statement,connect,resultSet);
    }


    public void newCostumerChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                booking.availableRoomsFullboard(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);


                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;
            case "2":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                booking.availableRoomsHalfBoard(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;
            case "3":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                booking.availableRoomsExtraBed(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;
            case "4":
                customer.createCustomer(statement,connect,resultSet);
                booking.emptyRoomsWithoutExtras(statement,connect,resultSet);// utan extras
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);//skapar bokning

                System.out.println("Reservation was made successfully.");
                existingCustomerMenu(statement, connect, resultSet);
                break;

            case "5":
                cityMenu1(statement,connect,resultSet);
                break;

            case "6":
                customer.createCustomer(statement, connect, resultSet); //create a new customer
                booking.allAvailableRooms(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "7":
                System.out.println("Taking you back to booking menu...");
                bookingMenu(statement, connect, resultSet);
                break;
        }

    }

    public void cityMenu1(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("(1) Make reservation in Gothenburg. (2) Make Reservation in Stockholm. " +
                "\n(3) Make Reservation in Luleå. (4)  Make Reservation in Malmö. (5)  Make Reservation in Skövde. ");
        cityMenuChoice1(statement,connect,resultSet);
    }


    public void cityMenuChoice1(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":

                booking.availableRoomsGothenburg(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "2":
                booking.availableRoomsStockholm(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "3":
                booking.availableRoomsLulea(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "4":
                booking.availableRoomsMalmo(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "5":
                booking.availableRoomsSkovde(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.createCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

        }
    }

    public void existingCustomerMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("Reservation menu:");

        System.out.println("(1) Make reservation with full board. (2) Make reservation with half board. (3) Make reservation with Extra bed." +
                "\n(4) Make reservation without extras.  (5)  Make reservation in a specific city. (6) Make random reservation. (7) Back to booking menu.  ");
        existingMenuChoice(statement,connect,resultSet);
    }
    public void existingMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                customer.searchCustomer(statement,connect,resultSet);
                booking.availableRoomsFullboard(statement,connect,resultSet);// lediga rum med full board
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);

                System.out.println("Reservation was made successfully.");
                existingCustomerMenu(statement, connect, resultSet);
                break;
            case "2":
                customer.searchCustomer(statement,connect,resultSet);
                booking.availableRoomsHalfBoard(statement,connect,resultSet);// lediga rum med half board
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);//skapar bokning

                System.out.println("Reservation was made successfully.");
                existingCustomerMenu(statement, connect, resultSet);
                break;
            case "3":
                customer.searchCustomer(statement,connect,resultSet);
                booking.availableRoomsExtraBed(statement,connect,resultSet);// lediga rum med extra säng
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);//skapar bokning

                System.out.println("Reservation was made successfully.");
                existingCustomerMenu(statement, connect, resultSet);
                break;

            case "4":
                customer.searchCustomer(statement,connect,resultSet);
                booking.emptyRoomsWithoutExtras(statement,connect,resultSet);// utan extras
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);//skapar bokning

                System.out.println("Reservation was made successfully.");
                existingCustomerMenu(statement, connect, resultSet);
                break;

            case "5":
               cityMenu2(statement,connect,resultSet);
                break;

            case "6":
                booking.allAvailableRooms(statement,connect,resultSet);
                customer.searchCustomer(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                booking.createBooking(statement,connect,resultSet);

                System.out.println("Reservation was made successfully.");
                existingCustomerMenu(statement, connect, resultSet);
                break;

            case "7":
                System.out.println("Taking you back to booking menu...");
                bookingMenu(statement, connect, resultSet);
                break;
        }

    }

    public void cityMenu2(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("(1) Make reservation in Gothenburg. (2) Make Reservation in Stockholm. " +
                "\n(3) Make Reservation in Luleå. (4)  Make Reservation in Malmö. (5)  Make Reservation in Skövde. ");
        cityMenuChoice2(statement,connect,resultSet);
    }

    public void cityMenuChoice2(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":

                booking.availableRoomsGothenburg(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "2":
                booking.availableRoomsStockholm(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "3":
                booking.availableRoomsLulea(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "4":
                booking.availableRoomsMalmo(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

            case "5":
                booking.availableRoomsSkovde(statement,connect,resultSet);
                System.out.println("Fill in following information to book a room:");
                customer.searchCustomer(statement,connect,resultSet);
                booking.createBooking(statement, connect, resultSet); //skapa bokning

                System.out.println("Reservation was made successfully.");
                newCustomerReservationMenu(statement, connect, resultSet);
                break;

        }
    }


    public void hotelMenu(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        System.out.println("Hotel menu:");

        System.out.println("(1) Our Hotels. (2) Hotels closest to the beach. (3)  Hotels closest to the city. (4)  Hotels based on reviews. (5) Hotels based on price. (6) Back to main menu. ");
        hotelMenuChoice(statement, connect, resultSet);
    }

    public void hotelMenuChoice(PreparedStatement statement, Connection connect, ResultSet resultSet) throws SQLException {
        Scanner input = new Scanner(System.in);
        String option;
        option = input.nextLine();
        switch (option) {
            case "1":
                System.out.println("Here are our Hotels:");
                hotel.viewAllHotels(statement,connect,resultSet);
                hotelMenu(statement,connect,resultSet);
                break;
            case "2":
                System.out.println("Our hotels closest to the beach:");
                hotel.hotelCloseToCity(statement,connect,resultSet);
                int choice = Dialog.dialog("Would you like to make a reservation?" +
                        "\n (1) Yes.   (2) No. " , 1 ,2);

                if(choice == 1 ){
                    bookingMenu(statement,connect,resultSet);
                }
                else{
                    hotelMenu(statement,connect,resultSet);
                }

                break;
            case "3":
                System.out.println("Our hotels closest to the city:");
                hotel.hotelCloseToBeach(statement,connect,resultSet);
                int choice2 = Dialog.dialog("Would you like to make a reservation?" +
                        "\n (1) Yes.   (2) No. " , 1 ,2);

                if(choice2 == 1 ){
                    bookingMenu(statement,connect,resultSet);
                }
                else{
                    hotelMenu(statement,connect,resultSet);
                }
                break;

            case "4":
                System.out.println("Our hotel based on reviews:");
                hotel.hotelBasedOnReviews(statement,connect,resultSet);
                int choice3 = Dialog.dialog("Would you like to make a reservation?" +
                        "\n (1) Yes.   (2) No. " , 1 ,2);

                if(choice3 == 1 ){
                   bookingMenu(statement,connect,resultSet);
                }
                else{
                    hotelMenu(statement,connect,resultSet);
                }

            case "5":
                System.out.println("Our hotel rooms based on price:");
                hotel.hotelBasedOnPrice(statement,connect,resultSet);
                int choice4 = Dialog.dialog("Would you like to make a reservation?" +
                        "\n (1) Yes.   (2) No. " , 1 ,2);

                if(choice4 == 1 ){
                    booking.createBooking(statement,connect,resultSet);
                }
                else{
                    hotelMenu(statement,connect,resultSet);
                }
                break;
            case "6":
                System.out.println("Taking you back to main menu...");
                mainMenu(statement, connect, resultSet);
                break;
        }

    }


}

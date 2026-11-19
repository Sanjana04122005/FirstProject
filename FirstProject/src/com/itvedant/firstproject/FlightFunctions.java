
package com.itvedant.firstproject;


import java.util.Scanner;

public class FlightFunctions
{
    static String source;
    static String destination;
    static String airlineName;
    static byte noOfPassengers;

    static double ticketPrice = 3499.50;
    static double bookingPrice, finalTicketPrice;

    static boolean bookingStatus = false;
    static String passengerCategory;
    static double discount = 0.0;

    // Method to accept booking details
    static void setBookingDetails()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the airline name, Source, Destination");

        airlineName = sc.next();
        source = sc.next();
        destination = sc.next();

        System.out.println("The ticket price is Rs. " + ticketPrice);

        System.out.println("Please enter no of passengers");
        noOfPassengers = sc.nextByte();

        System.out.println("Please enter the passenger category as 'regular' or 'student' or 'armed forces'?");

        // Use nextLine() to accept multi-word string
        sc.nextLine();
        passengerCategory = sc.nextLine();

        if(noOfPassengers > 0 && noOfPassengers <= 5)
        {
            bookingPrice = noOfPassengers * ticketPrice;

            // Switch statement
            switch(passengerCategory)
            {
                case "regular":
                    discount = 5.0;
                    break;

                case "student":
                    discount = 10.0;
                    break;

                case "armed forces":
                    discount = 20.0;
                    break;

                default:
                    System.err.println("Please provide valid category");
                    bookingStatus = false;
                    break;
            }

            if(passengerCategory.equals("regular") ||
               passengerCategory.equals("student") ||
               passengerCategory.equals("armed forces"))
            {
                bookingStatus = true;
                System.out.println("Thank you for providing details.");
            }
        }
        else
        {
            System.err.println("Your booking cannot be processed, as number of passengers must be 1 to 5");
            bookingPrice = 0;
            bookingStatus = false;
        }

        sc.close();
    }

    // Accept discount percent and return total price after discount
    static double calculateFinalTicketPrice(double percent)
    {
        // discount = percent;
        double amountToPay = bookingPrice - bookingPrice * discount / 100;

        return amountToPay;
    }

    // Method to display booking information
    static void displayBookingInformation()
    {
        System.out.println("\n ****");
        System.out.println("Your flight booking details are as follows:");

        System.out.println("Airline Name: " + airlineName);
        System.out.println("From: " + source);
        System.out.println("To: " + destination);
        System.out.println("No of passengers: " + noOfPassengers);

        System.out.println("Passenger Category: " + passengerCategory);

        System.out.println("After " + discount +
        "% discount, The total booking amount is Rs. " + finalTicketPrice);
    }

    public static void main(String[] args)
    {
        setBookingDetails();

        if(bookingStatus)
        {
            finalTicketPrice = calculateFinalTicketPrice(discount);

            System.out.println("You need to pay rupees Rs. " + finalTicketPrice);

            System.out.println("Your booking is confirmed!!");

            displayBookingInformation();
        }
    }
}

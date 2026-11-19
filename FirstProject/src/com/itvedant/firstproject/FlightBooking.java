package com.itvedant.firstproject;


import java.util.Scanner;

public class FlightBooking
{
    public static void main(String[] args)
    {
        String source;
        String destination;
        byte noOfPassengers;

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the Flight Booking details:");

        System.out.println("Enter the source, destination and number of passengers");

        source = sc.next();
        destination = sc.next();
        noOfPassengers = sc.nextByte();

        // Declaring arrays to store passenger names and ages
        String[] passengerNames = new String[noOfPassengers];
        byte[] passengerAge = new byte[noOfPassengers];

        System.out.println("Enter the " + noOfPassengers + " passenger names and ages");

        // Accept passenger names and ages using for loop
        for(byte i = 0; i < passengerNames.length; i++)
        {
            System.out.print("Enter Passenger Name: ");
            passengerNames[i] = sc.next();

            System.out.print("Enter Passenger Age: ");
            passengerAge[i] = sc.nextByte();
        }

        sc.close();

        System.out.println("\nFollowing passengers are travelling from "
                + source + " to " + destination);

        // Display passenger names and ages
        for(byte i = 0; i < noOfPassengers; i++)
        {
            System.out.println("Passenger name: " + passengerNames[i]
                    + ", Age: " + passengerAge[i]);
        }
    }
}

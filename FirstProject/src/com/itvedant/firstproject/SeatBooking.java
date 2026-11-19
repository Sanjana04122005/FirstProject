package com.itvedant.firstproject;


import java.util.Scanner;

public class SeatBooking
{
    public static void main(String[] args)
    {
        String[][] seats = new String[6][2];

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of passengers: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int k = 1; k <= n; k++)
        {
            System.out.println("\nPassenger " + k);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Row (1-6): ");
            int row = sc.nextInt();

            System.out.print("Enter Column (1-2): ");
            int col = sc.nextInt();
            sc.nextLine();

            row = row - 1;
            col = col - 1;

            if(row < 0 || row >= 6 || col < 0 || col >= 2)
            {
                System.out.println("Invalid seat number!");
                k--;
                continue;
            }

            if(seats[row][col] == null)
            {
                seats[row][col] = name;
                System.out.println("Seats booked!");
            }
            else
            {
                System.out.println("Seat already booked!");
                k--; // retry
            }
        }

        System.out.println("\nFinal Seat Map:");

        System.out.println("       C1       C2");

        for(int i = 0; i < seats.length; i++)
        {
            System.out.print("R" + (i + 1) + "   ");

            for(int j = 0; j < seats[i].length; j++)
            {
                if(seats[i][j] == null)
                {
                    System.out.print("[Empty] ");
                }
                else
                {
                    System.out.print("[" + seats[i][j] + "] ");
                }
            }

            System.out.println();
        }

        sc.close();
    }
}


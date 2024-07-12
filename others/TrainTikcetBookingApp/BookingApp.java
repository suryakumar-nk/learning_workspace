package others.TrainTikcetBookingApp;

import java.util.Scanner;

public class BookingApp {
    
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("1. Booking ticket");
            System.out.println("2. Display Passengers list");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Exit");
            System.out.print("Enter You choice: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                            System.out.print("Enter the passenger name: ");
                            String name = sc.next();
                            System.out.print("Enter the age: ");
                            int age = sc.nextInt();
                            System.out.print("Enter the Prefered Birth [L,M,U]: ");
                            char preferedBirth = sc.next().charAt(0);
                            ticket.book(name, age, preferedBirth);
                        }
                        break;
                case 2: {
                            ticket.display();
                        }
                        break;
                case 3: {
                            System.out.print("Enter the passenger Id: ");
                            int id = sc.nextInt();
                            ticket.cancel(id);
                        }
                        break;    
                case 4: flag = false;
            }
        }
        sc.close();
    }
}

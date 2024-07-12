package others.TrainTikcetBookingApp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Ticket {

    private int lowerCount = 1;
    private int upperCount = 1;
    private int middleCount = 1;
    private int racCount = 1;
    private int weitingCount = 1;
    private int passengerId = 1;
    
    Map<Integer, Passenger> confirmedTickets = new HashMap<>();
    Queue<Passenger> rac = new LinkedList<>();
    Queue<Passenger> weiting = new LinkedList<>();

    private boolean allotedLowerBirth(char preferedBirth, Passenger passenger) {
        if (lowerCount > 0) {
            System.out.println("Lower Birth Alloted");
            passenger.setSeatNo(lowerCount--);
            passenger.setAllotedBirth('L');
            return true;
        } else if (middleCount > 0){
            System.out.println("Middle Birth Alloted");
            passenger.setSeatNo(middleCount--);
            passenger.setAllotedBirth('M');
            return true;
        } else if (upperCount > 0){
            System.out.println("Lower Birth Alloted");
            passenger.setSeatNo(upperCount--);
            passenger.setAllotedBirth('U');;
            return true;
        }
        return false;
    }

    private boolean allotedMiddleBirth(char preferedBirth, Passenger passenger) {
        if (middleCount > 0){
            System.out.println("Middle Birth Alloted");
            passenger.setSeatNo(middleCount--);
            passenger.setAllotedBirth('M');
            return true;
        } else if (lowerCount > 0) {
            System.out.println("Lower Birth Alloted");
            passenger.setSeatNo(lowerCount--);
            passenger.setAllotedBirth('L');
            return true;
        } else if (upperCount > 0){
            System.out.println("Upper Birth Alloted");
            passenger.setSeatNo(upperCount--);
            passenger.setAllotedBirth('U');
            return true;
        }
        return false;
    }

    private boolean allotedUpperBirth(char preferedBirth, Passenger passenger) {
        if (upperCount > 0){
            System.out.println("Upper Birth Alloted");
            passenger.setSeatNo(upperCount--);
            passenger.setAllotedBirth('U');;
            return true;
        } else if (middleCount > 0){
            System.out.println("Middle Birth Alloted");
            passenger.setSeatNo(middleCount--);
            passenger.setAllotedBirth('M');
            return true;
        } else if (lowerCount > 0) {
            System.out.println("Lower Birth Alloted");
            passenger.setSeatNo(lowerCount--);
            passenger.setAllotedBirth('L');
            return true;
        }
        return false;
    }

    public String book(String name, int age, char preferedBirth) {
        var passenger = new Passenger(passengerId++, name, age, preferedBirth);
        boolean allotedBirthStatus = false;
        if (preferedBirth == 'L') {
            allotedBirthStatus = allotedLowerBirth(preferedBirth, passenger);
        } else if (preferedBirth == 'M') {
            allotedBirthStatus = allotedMiddleBirth(preferedBirth, passenger);
        } else if (preferedBirth == 'U') {
            allotedBirthStatus = allotedUpperBirth(preferedBirth, passenger);
        }
        if (allotedBirthStatus) {
            passenger.setStatus(Passenger.Status.CONFIRM);
            confirmedTickets.put(passenger.getPassengerId(), passenger);
            return Passenger.Status.CONFIRM.name();
        }
        if (racCount > 0) {
            passenger.setStatus(Passenger.Status.RAC);
            System.out.println("You are under  RAC");
            rac.add(passenger);
            racCount--;
            // racPassengers.put(passenger.getPassengerId(), passenger);
            return Passenger.Status.RAC.name();
        } else if (weitingCount > 0) {
            passenger.setStatus(Passenger.Status.WEITING);
            System.out.println("You are under WEITING LIST");
            weiting.add(passenger);
            weitingCount--;
            // weitingPassengers.put(passenger.getPassengerId(), passenger);
            return Passenger.Status.WEITING.name();
        } else {
            System.out.println("Sorry all are full :-( cant booked");
            return Passenger.Status.CANCEL.toString();
        }
    }

    public void cancel(int passengerId) {
        if (!confirmedTickets.containsKey(passengerId)) {
            System.out.println("Confirmed tickets only able to cancel..");
            return;
        }
        var confPass = confirmedTickets.remove(passengerId);
        if (rac.isEmpty()) {
            switch (confPass.getAllotedBirth()) {
                case 'L' -> lowerCount++;
                case 'M' -> middleCount++;
                case 'U' -> upperCount++;
           }
           return;
        }
        var newPass = rac.poll();
        newPass.setSeatNo(confPass.getSeatNo());
        newPass.setAllotedBirth(confPass.getAllotedBirth());
        newPass.setStatus(Passenger.Status.CONFIRM);
        confirmedTickets.put(newPass.getPassengerId(), newPass);
        if (weiting.isEmpty()) {
            racCount++;
            return;
        }            
        var weitingPass = weiting.poll();
        weitingPass.setStatus(Passenger.Status.RAC);
        rac.add(weitingPass);
        weitingCount++;
        System.out.println("Ticket Cancelled SuccessFully for PassengerId "+ passengerId);
    }

    public void display() {
        System.out.println("The Passenger List Are: \n");
        confirmedTickets.values().forEach(p -> System.out.println(p.toString()));
        rac.forEach(p -> System.out.println(p.toString()));
        weiting.forEach(p -> System.out.println(p.toString()));
    }
}

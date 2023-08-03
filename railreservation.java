import java.util.*;

class Train {
    int number;
    int availableSeats;

    public Train(int number, int availableSeats) {
        this.number = number;
        this.availableSeats = availableSeats;
    }
}

class Reservation {
    Train train;
    String passengerName;

    public Reservation(Train train, String passengerName) {
        this.train = train;
        this.passengerName = passengerName;
    }
}

class TrainReservationSystem {
    Map<Integer, Train> trains = new HashMap<>();
    List<Reservation> reservations = new ArrayList<>();

    public void addTrain(Train train) {
        trains.put(train.number, train);
    }

    public Train searchTrain(int number) {
        return trains.get(number);
    }

    public void makeReservation(int number, String passengerName) {
        Train train = searchTrain(number);
        if(train != null && train.availableSeats > 0) {
            train.availableSeats--;
            reservations.add(new Reservation(train, passengerName));
            System.out.println("Reservation made successfully for passenger: " + passengerName);
        } else {
            System.out.println("Unable to make reservation. Train not found or no available seats.");
        }
    }

    public void viewReservations() {
        for(Reservation r : reservations) {
            System.out.println("Passenger: " + r.passengerName + " Train number: " + r.train.number);
        }
    }
}

public class railreservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrainReservationSystem system = new TrainReservationSystem();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1: Add a train");
            System.out.println("2: Make a reservation");
            System.out.println("3: View reservations");
            System.out.println("4: Quit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter train number:");
                    int number = scanner.nextInt();
                    System.out.println("Enter available seats:");
                    int availableSeats = scanner.nextInt();
                    system.addTrain(new Train(number, availableSeats));
                    break;
                case 2:
                    System.out.println("Enter train number:");
                    number = scanner.nextInt();
                    System.out.println("Enter passenger name:");
                    String passengerName = scanner.next();
                    system.makeReservation(number, passengerName);
                    break;
                case 3:
                    system.viewReservations();
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}

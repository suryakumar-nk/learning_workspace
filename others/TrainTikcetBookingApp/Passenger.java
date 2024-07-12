package others.TrainTikcetBookingApp;

public class Passenger {
    private int passengerId;
    private String name;
    private int age;
    private char preferedBirth;
    private int seatNo;
    private char allotedBirth;
    private Status status;

    public Passenger(int passengerId, String name, int age, char preferedBirth) {
        this.age = age;
        this.name = name;
        this.preferedBirth = preferedBirth;
        this.passengerId = passengerId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getPreferedBirth() {
        return preferedBirth;
    }

    public void setPreferedBirth(char preferedBirth) {
        this.preferedBirth = preferedBirth;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public char getAllotedBirth() {
        return allotedBirth;
    }

    public void setAllotedBirth(char allotedBirth) {
        this.allotedBirth = allotedBirth;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Passenger [passengerId=" + passengerId + ", name=" + name + ", age=" + age + ", preferedBirth="
                + preferedBirth + ", seatNo=" + seatNo + ", allotedBirth=" + allotedBirth + ", status=" + status + "]";
    }

    public enum Status {
        CONFIRM(1), RAC(2), WEITING(3), CANCEL(4);

        private final int key;
        
        Status(int key) {
            this.key = key;
        }

        public int getKey() {
            return this.key;
        }
    }
}

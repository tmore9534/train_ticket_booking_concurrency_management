package main.entities;

public class User {
    private String userId;
    private String name;
    private String hashedPassword;
    private List<Ticket> bookedTickets;

    User(String userId, String name, String hashedPassword, Sting bookedTickets) {
        this.userId = userId;
        this.name = name;
        this.hashedPassword = hashedPassword;
        this.bookedTickets = bookedTickets;
    }

    public String getName() {
        return this.name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public Tickets[] getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(Tickets[] bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    public void printBookedTickets() {
        for (Ticket t : this.bookedTickets) {
            System.out.println(t.toString());
        }
    }

}
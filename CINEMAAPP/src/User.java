package src;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private String fullName;
    private double balance;
    private List<Ticket> ticketList;
    private static final int MAX_TICKET = 20;

    public User(String email, String password, String fullName, double balance) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.balance = balance;
        this.ticketList = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public double getBalance() {
        return balance;
    }

    public void addTicket(Ticket ticket) {
        if (ticketList.size() < MAX_TICKET) {
            ticketList.add(ticket);
        } else {
            System.out.println("Maksimal tiket telah tercapai.");
        }
    }

    public void displayAllTickets() {
        for (Ticket ticket : ticketList) {
            System.out.println("Film: " + ticket.getMovie().getTitle() + 
                               ", Studio: " + ticket.getStudioNumber() + 
                               ", Harga: " + ticket.getPrice());
        }
    }

    public boolean isMatch(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void topUp(double amount) {
        balance += amount;
    }

    public boolean deductBalance(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}


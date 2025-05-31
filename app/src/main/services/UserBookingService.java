package main.services.UserBookingService;

import java.io.File;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import utils.UserServiceUtils;

public class UserBookingService {
    List<User> userList;
    User user;
    private final String USER_FILE_PATH = "app/src/main/local_db/trainsData.json";
    ObjectMapper ob = new ObjectMapper();

    UserBookingService() {
        loadUserListFromFile();
    }

    UserBookingService(User user) {
        this.user = user;
        loadUserListFromFile();
    }

    private void loadUserListFromFile() throws IOException {
        File userDataFile = new File(USER_FILE_PATH);
        // deserialization
        userList = ob.readValue(userDataFile, new TypeReference<List<User>>() {
        });
    }

    private void saveUserListToFile() throws IOException {
        File usersFile = new File(USER_FILE_PATH);
        ob.writeValue(userDataFile, this.userList);
    }

    public Boolean signUp(User user) {
        try {
            userList.add(user);
            // serialiaze and store
            this.saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException ex) {
            return Boolean.FALSE;
        }
    }

    public Boolean logIn(User user1) {
        Optional<User> userValue = userList.stream().filter(userVal -> {
            return userVal.getName().eualsIgnoreCase(user1.getName())
                    && UserServiceUtils.checkPassword(user1.getHashedPassword(), userVal.getHashedPassword());
        })
                .findFirst();
        return userValue.isPresent();
    }

    public void fetchBooking() {
        if (user != null)
            user.printBookedTickets();
    }

    public Boolean cancelBooking(int ticketId) {
        boolean removed = user.getBookedTickets().removeIf(user_ticket -> {
            return user_ticket.getTicketId().equals(ticketId);
        });

        if (!removed) {
            System.out.println("No booking found with Ticket ID: " + ticketId);
            return Boolean.FALSE;
        }

        // update the userList
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(user.getName())) {
                userList.set(i, user);
                break;
            }
        }

        try {
            saveUserListToFile();
            System.out.println("Booking has been canceled.");
            return Boolean.TRUE;
        } catch (IOException e) {
            System.out.println("Failed to update file: " + e.getMessage());
            return Boolean.FALSE;
        }

    }

}

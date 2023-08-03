import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class onlineexam {
    static Map<String, User> users = new HashMap<>();
    static User currentUser;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Update profile");
            System.out.println("4. Start exam");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    handleRegister();
                    break;
                case 2:
                    handleLogin();
                    break;
                case 3:
                    handleUpdateProfile();
                    break;
                case 4:
                    handleStartExam();
                    break;
                case 5:
                    handleLogout();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        }
    }

    static void handleRegister() {
        System.out.println("Enter username:");
        String username = in.next();
        System.out.println("Enter password:");
        String password = in.next();
        users.put(username, new User(username, password));
        System.out.println("Registration successful!");
    }

    static void handleLogin() {
        System.out.println("Enter username:");
        String username = in.next();
        System.out.println("Enter password:");
        String password = in.next();
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            currentUser = user;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid username or password");
        }
    }

    static void handleUpdateProfile() {
        if (currentUser == null) {
            System.out.println("You must be logged in to update your profile!");
            return;
        }
        // implement profile update
    }

    static void handleStartExam() {
        if (currentUser == null) {
            System.out.println("You must be logged in to start the exam!");
            return;
        }
        // implement exam start
    }

    static void handleLogout() {
        if (currentUser == null) {
            System.out.println("You're not logged in!");
            return;
        }
        currentUser = null;
        System.out.println("You've been logged out!");
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

package src.main.session4;


import java.time.LocalDate;
import java.util.List;

 class User {
    private String email;
    private LocalDate dob;
    private String name;

    public User(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setName(String name) {
        this.name = name;
    }
}


 class UserProfile {
    private String email;
    private LocalDate dob;
    private String name;

    public UserProfile(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }
}
 class UserService {

    public static User updateProfile(User existingUser,
                                     UserProfile newProfile,
                                     List<User> allUsers) {

        if (existingUser == null || newProfile == null) {
            return null;
        }

        // check dob future
        if (newProfile.getDob().isAfter(LocalDate.now())) {
            return null;
        }

        // check email duplicate
        if (!newProfile.getEmail().equals(existingUser.getEmail())) {

            for (User u : allUsers) {
                if (u.getEmail().equals(newProfile.getEmail())) {
                    return null;
                }
            }

        }

        existingUser.setEmail(newProfile.getEmail());
        existingUser.setDob(newProfile.getDob());
        existingUser.setName(newProfile.getName());

        return existingUser;
    }
}
public class s4_ex6 {
    public static void main(String[] args) {
        
    }
}

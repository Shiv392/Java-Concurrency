package AsyncPrograming_04.ThenCompose_07;

import java.util.List;
import java.util.ArrayList;

public class UserList {
    private List<User> users = new ArrayList<>();

    public void addUser() {
        for (int i = 1; i <= 20; i++) {
            users.add(new User(i, "User" + i));
        }
    }

    public List<User> getUser() {
        return users;
    }
}

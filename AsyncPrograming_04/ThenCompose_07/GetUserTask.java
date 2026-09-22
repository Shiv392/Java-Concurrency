package AsyncPrograming_04.ThenCompose_07;

import java.util.function.Function;
import java.util.function.Supplier;

public class GetUserTask implements Supplier<User> {

    private final UserList userList;
    private int userId;

    public GetUserTask(UserList _userList, int _userId){
        userList = _userList;
        userId = _userId;
    }

    @Override 
    public User get(){
        return userList.getUser().stream().filter(user-> user.getId()  == userId).findFirst().orElse(null);
    }
}

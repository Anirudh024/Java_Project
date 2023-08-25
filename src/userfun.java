import java.util.List;

public interface userfun {
    void addUser(user user);
    void updateUser(user user);
    void removeUser(int userId);
    user getUserById(int userId);
    public List<user> getAllUsers();
    // Other methods
}

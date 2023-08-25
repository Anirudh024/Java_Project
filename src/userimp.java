import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class userimp implements userfun {
    @Override
    public void addUser(user user) {
    	String query = "INSERT INTO users (id,name,age,city) VALUES (?,?,?,?)";

        try (Connection connection = dbutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        	preparedStatement.setInt(1, user.getId());
        	preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setString(4, user.getCity());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(user user) {
    	String query = "UPDATE users SET name=?,age=?,city=? WHERE id = ?";

        try (Connection connection = dbutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setString(3, user.getCity());
            preparedStatement.setInt(4, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUser(int userId) {
    	String query = "DELETE FROM users WHERE id = ?";

        try (Connection connection = dbutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public user getUserById(int userId) {
    	String query = "SELECT * FROM users WHERE id = ?";
        user user = null;

        try (Connection connection = dbutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, userId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user = new user();
                    user.setId(resultSet.getInt("id"));
                    user.setName(resultSet.getString("name"));
                    user.setage(resultSet.getInt("age"));
                    user.setcity(resultSet.getString("city"));
                    // Set other user attributes
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
    public List<user> getAllUsers() {
        String query = "SELECT * FROM users";
        List<user> users = new ArrayList<>();

        try (Connection connection = dbutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                user user = new user();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setage(resultSet.getInt("age"));
                user.setcity(resultSet.getString("city"));
                // Set other user attributes
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}

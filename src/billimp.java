import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class billimp implements billfun {

public void addBill(bill bill){
    if(userExists(bill.getUserId())) {
        String query = "INSERT INTO bills (id,user_id,amount,units) VALUES (?,?,?,?)";

        // Calculate the bill amount based on user's living area and units used
        double billAmount = calculateBillAmount(bill.getUserId(), bill.getUU());
    	try (Connection connection = dbutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, bill.getId());
            preparedStatement.setInt(2, bill.getUserId());
            preparedStatement.setDouble(3, billAmount);
            preparedStatement.setInt(4, bill.getUU());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    } 
    else {
        System.out.println("User with ID " + bill.getUserId() + " does not exist. Cannot add bill.");
    }
}

private boolean userExists(int userId) {
    String query = "SELECT COUNT(*) FROM users WHERE id = ?";
    boolean exists = false;

    try (Connection connection = dbutil.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

        preparedStatement.setInt(1, userId);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                exists = count > 0;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle exception
    }

    return exists;
}


//    @Override
//    public void addBill(bill bill) {
//    	String query = "INSERT INTO bills (id,user_id,amount,units) VALUES (?,?,?,?)";
//
//    	double billAmount = calculateBillAmount(bill.getUserId(), bill.getUU());
//    	try (Connection connection = dbutil.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//
//            preparedStatement.setInt(1, bill.getId());
//            preparedStatement.setInt(2, bill.getUserId());
//            preparedStatement.setDouble(3, billAmount);
//            preparedStatement.setInt(4, bill.getUU());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle exception
//        }
//    }
    private double calculateBillAmount(int userId, int unitsUsed) {
        
    	userfun x = new userimp();
    	user user = x.getUserById(userId);
    	double amt = 0;
        if (user != null) {
            String LA = user.getCity();
            if(LA.equalsIgnoreCase("CHE")||LA.equalsIgnoreCase("HYD")
            ||LA.equalsIgnoreCase("DEL")||LA.equalsIgnoreCase("BLR")) {
            	amt=6*unitsUsed;
            }
            else {
            	amt=3*unitsUsed;
            }
        }
            return amt;
    }
    @Override
    public void updateBill(bill bill) {
    	String query = "UPDATE bills SET user_id=?,units=? WHERE id = ?";

        try (Connection connection = dbutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, bill.getUserId());
            preparedStatement.setDouble(2, bill.getUU());
            preparedStatement.setInt(3, bill.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    @Override
    public void removeBill(int billId) {
    	 String query = "DELETE FROM bills WHERE id = ?";

         try (Connection connection = dbutil.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(query)) {

             preparedStatement.setInt(1, billId);

             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
             // Handle exception
         }
    }

    @Override
    public bill getBillById(int billId) {
    	String query = "SELECT * FROM bills WHERE id = ?";
        bill bill = null;

        try (Connection connection = dbutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, billId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    bill = new bill();
                    bill.setId(resultSet.getInt("id"));
                    bill.setUserId(resultSet.getInt("user_id"));
                    bill.setAmount(resultSet.getDouble("amount"));
                    bill.setUU(resultSet.getInt("units"));
                    // Set other bill attributes
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }

        return bill;
    }
    public List<bill> getAllBills() {
        String query = "SELECT * FROM bills";
        List<bill> bills = new ArrayList<>();

        try (Connection connection = dbutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                bill bill = new bill();
                bill.setId(resultSet.getInt("id"));
                bill.setUserId(resultSet.getInt("user_id"));
                bill.setAmount(resultSet.getDouble("amount"));
                bill.setUU(resultSet.getInt("units"));
                // Set other bill attributes
                bills.add(bill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }

        return bills;
    }
}

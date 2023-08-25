import java.util.List;

public interface billfun {
    void addBill(bill bill);
    void updateBill(bill bill);
    void removeBill(int billId);
    bill getBillById(int billId);
    public List<bill> getAllBills();
    // Other methods
}

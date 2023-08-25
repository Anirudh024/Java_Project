public class bill {
    private int id;
    private int userId;
    private int unitsUsed;
    private double amount;
    // Add other bill attributes as needed

    // Constructors
    public bill() {
    }

    public bill(int id, int userId, int unitsUsed) {
        this.id = id;
        this.userId = userId;
        this.unitsUsed=unitsUsed;
        this.amount=0;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUU() {
        return unitsUsed;
    }

    public void setUU(int unitsUsed) {
        this.unitsUsed = unitsUsed;
    }
    // Add getter and setter methods for other attributes as needed

    // Display method
    public void display() {
        System.out.println("--------------------------------------------------");
        System.out.println("                   Bill Details                   ");
        System.out.println("--------------------------------------------------");
        System.out.println("Bill ID:     " + id);
        System.out.println("User ID:     " + userId);
        System.out.println("Unis Used:     " + unitsUsed);
        System.out.println("Amount:      $" + String.format("%.2f", amount));
        // Display other attributes as needed
        System.out.println("--------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", userId=" + userId +
                ", amount=" + amount +
                // Add other attributes
                '}';
    }
}
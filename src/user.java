public class user {
    private int id;
    private String name;
    private int age;
    private String city;
    // Add other user attributes as needed

    // Constructors
    public user() {
    }

    public user(int id, String name,int age,String city) {
        this.id = id;
        this.name = name;
        this.age=age;
        this.city=city;
    }

    // Getter and Setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }

    public void setage(int age) {
        this.age = age;
    }
    
    public String getCity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;
    }
    // Display method
    public void display() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("City: " + city);
        // Display other attributes as needed
    }

    }


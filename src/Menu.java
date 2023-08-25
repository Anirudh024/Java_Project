import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        userfun userDao = new userimp();
        billfun billDao = new billimp();
        user x;
        bill y;
        String n,c;
        int a,id,i=0,uu;

        while (true) {
            System.out.println("Electric Bill Management Menu:");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Remove User");
            System.out.println("4. Add Bill");
            System.out.println("5. Update Bill");
            System.out.println("6. Remove Bill");
            System.out.println("7. Display User by ID");
            System.out.println("8. Display All Users");
            System.out.println("9. Display Bill by ID");
            System.out.println("10. Dsiplay All Bills");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Get user details and call userDao.addUser()
                	System.out.print("\nEnter the necessary details for the user...\n");
                	System.out.print("Enter User ID: ");
                	id=scanner.nextInt();
                	scanner.nextLine();
                	System.out.print("Enter name: ");
                	n=scanner.nextLine();
                	System.out.print("Enter age: ");
                	a=scanner.nextInt();
                	scanner.nextLine();
                	System.out.print("Enter the city: ");
                	c=scanner.nextLine();
                	userDao.addUser(new user(id,n,a,c));
                	System.out.print("\nUser details Added...\n");
                    break;
                case 2:
                    // Get user details and call userDao.updateUser()
                	System.out.print("\nEnter the User ID that needs to be updated...\n ");
                	System.out.print("Enter the User ID: ");
                	id=scanner.nextInt();
                	scanner.nextLine();
                	System.out.print("\nEnter the necessary details for the user to update...\n");
                	System.out.print("Enter name: ");
                	n=scanner.nextLine();
                	System.out.print("Enter age: ");
                	a=scanner.nextInt();
                	scanner.nextLine();
                	System.out.print("Enter the city: ");
                	c=scanner.nextLine();
                	userDao.updateUser(new user(id,n,a,c));
                	System.out.print("\nUser details Updated...\n");
                    break;
                case 3:
                    // Get user ID and call userDao.removeUser()
                	System.out.print("\nEnter the User ID that needs to be removed...\n ");
                	System.out.print("Enter the User ID: ");
                	id=scanner.nextInt();
                	scanner.nextLine();
                	userDao.removeUser(id);
                	System.out.print("\nUser details Removed...\n");
                    break;
                case 4:
                    // Get bill details and call billDao.addBill()
                	System.out.print("\nEnter the necessary details for the user...\n");
                	System.out.print("Enter Bill ID: ");
                	id=scanner.nextInt();
                	scanner.nextLine();
                	System.out.print("Enter User ID: ");
                	a=scanner.nextInt();
                	scanner.nextLine();
                	System.out.print("Enter the Units Used: ");
                	uu=scanner.nextInt();
                	scanner.nextLine();
                	billDao.addBill(new bill(id,a,uu));
                	System.out.print("\nBill details Added...\n");
                    break;
                case 5:
                    // Get bill details and call billDao.updateBill()
                	System.out.print("\nEnter the Bill ID that needs to be updated\n");
                	System.out.print("Enter Bill ID: ");
                	id=scanner.nextInt();
                	scanner.nextLine();
                	System.out.print("\nEnter the necessary details for the bill to update...\n");
                	System.out.print("Enter User ID: ");
                	a=scanner.nextInt();
                	scanner.nextLine();
                	System.out.print("Enter the Units Used: ");
                	uu=scanner.nextInt();
                	scanner.nextLine();
                	billDao.updateBill(new bill(id,a,uu));
                	System.out.print("\nBill details Updated...\n");
                    break;
                case 6:
                    // Get bill ID and call billDao.removeBill()
                	System.out.print("\nEnter the User ID that needs to be removed...\n ");
                	System.out.print("Enter the Bill ID: ");
                	id=scanner.nextInt();
                	scanner.nextLine();
                	billDao.removeBill(id);
                	System.out.print("\nBill details Removed...\n");
                    break;
                case 7:
                	System.out.print("\nDisplaying the User By ID..\n");
                	System.out.print("Enter User ID: ");
                	id=scanner.nextInt();
                	scanner.nextLine();
                	x=userDao.getUserById(id);
                	System.out.println("\n---------------------------------");
                	x.display();
                	System.out.println("\n---------------------------------");
                	break;
                case 8:
                	System.out.print("\nDisplaying all the User Details..\n");
                	for(user f: userDao.getAllUsers()) {
                		i++;
                		System.out.print("\nRecord number: "+i+"\n");
                		System.out.println("\n---------------------------------");
                		f.display();
                		System.out.println("\n---------------------------------");
                	}
                	i=0;
                	break;
                case 9:
                	System.out.print("\nDisplaying the Bill By ID..\n");
                	System.out.print("Enter Bill ID: ");
                	id=scanner.nextInt();
                	scanner.nextLine();
                	y=billDao.getBillById(id);
                	System.out.println("\n---------------------------------");
                	y.display();
                	System.out.println("\n---------------------------------");
                	System.out.println();
                	break;
                case 10:
                	System.out.print("\nDisplaying all the Bill Details..\n");
                	for(bill f: billDao.getAllBills()) {
                		i++;
                		System.out.print("\nRecord number: "+i+"\n");
                		f.display();
                		System.out.println();
                		System.out.println();
                	}
                	i=0;
                	break;
                case 0:
                    System.out.println("\nExiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please select a valid option.");
            }
        }
    }
}

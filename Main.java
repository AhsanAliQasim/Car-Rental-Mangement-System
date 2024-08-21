import java.util.Scanner;
public class Main {
    static int count=0;
    public static void main(String[] args)
    {
        //Read data from CompactCar file to CompactCar ArrayList
        if(count==0) {
            readdata obj1 = new readdata();
            User u1 = new User();
            obj1.readcompactcarstoarray(u1.ListofCompactCars);
            obj1.readSUVs(u1.ListofSUVs);
            obj1.readluxurycars(u1.ListofLuxuryCars);
            obj1.readrentaldetailtoarray(u1.ListofRentalRequests);
            count++;
        }


        //Manager Class ka object to call Manager Method
        Manager M = new Manager();
        //Renter Class ka object to call Renter Method
        Renter R = new Renter();


        //Yahan se Asal Output wala Project Start hota hai
        Scanner Input = new Scanner(System.in);
        String Choice1;
        String Username1;
        String Password1;
        //Welcoming Interface
        System.out.println("---------------------------------------------------------");
        System.out.println("              HORIZON WHEELS RENTELS");
        System.out.println("---------------------------------------------------------");
        System.out.println("\n");
        System.out.println("                  ---WELCOME---");
        System.out.println("\n");
        System.out.println("   ~ “Drive into Comfort: Rent, Ride, Explore!” ~");
        System.out.println("\n");
        System.out.println("Are you a Manager or a Renter (Press M for Manager, R for Renter)");
        Choice1 = Input.next();

        while (!Choice1.equals("M") && !Choice1.equals("R")) {
            System.out.println("Error! Please Press M for Manager, R for Renter");
            Choice1 = Input.next();
            if (Choice1.equals("M") || Choice1.equals("R"))
                break;
        }

        //Login for Manager
        if (Choice1.equals("M")) {
            do {
                System.out.println("Enter UserName:");
                Username1 = Input.next();
                System.out.println("Enter Password:");
                Password1 = Input.next();
                if (Username1.equals("Manager"))
                    if (Password1.equals("Carguy")) {
                        System.out.println("--------------------------------");
                        System.out.println("You Have Successfully Logged In!");
                        System.out.println("--------------------------------");
                        M.ManagerMethod();
                        break;
                    } else {
                        System.out.println("-----------------");
                        System.out.println("Invalid Password!");
                        System.out.println("-----------------");
                    }
                else {
                    System.out.println("----------------------");
                    System.out.println("Invalid Login details!");
                    System.out.println("----------------------");
                }
            } while (!Username1.equals("Manager") || !Password1.equals("Carguy"));
        } else {
            R.RenterMethod();
        }


    }
}



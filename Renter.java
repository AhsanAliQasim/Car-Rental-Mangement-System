import java.util.*;

public class Renter extends User
{
    private String Name;
    private String CNIC;
    private String Contact_No;
    private String Address;
    private double hours=0;
    private String Car_Name;
    private int Price=0;

    public Renter(String Name,String CNIC,String Contact_No,String Address,double hours,String Car_Name,int Price)
    {
        this.Name=Name;
        this.CNIC=CNIC;
        this.Contact_No=Contact_No;
        this.Address=Address;
        this.hours=hours;
        this.Car_Name=Car_Name;
        this.Price=Price;
    }
    public String getName()
    {
        return Name;
    }
    public String getCNIC()
    {
        return CNIC;
    }
    public String getContact_No()
    {
        return Contact_No;
    }
    public String getAddress()
    {
        return Address;
    }
    public double getHours()
    {
        return hours;
    }
    public String getCar_Name()
    {
        return Car_Name;
    }
    public int getPrice()
    {
        return Price;
    }

    public Renter()
    {

    }

    public void RenterMethod()
    {
        Main obj = new Main();
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("Main Menu for Renter");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("[1] List of Cars");
        System.out.println("[2] Filter Price(Low to high)");
        System.out.println("[3] Filter Price(high to low)");
        System.out.println("[4] Rent a Car");
        System.out.println("[5] Search for a Car");
        System.out.println("[6] Logout");
        System.out.println("[0] Exit");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("Enter Your Choice: ");
        choice = input.nextInt();
        while (choice < 0 || choice > 6)
        {
            System.out.println("Invalid Choice!");
            System.out.println("Re-Enter Choice:");
            choice = input.nextInt();
            if (choice >= 0 && choice <= 6)
                break;
        }
        switch (choice)
        {
            case 1:
            {
                listofcars();
                RenterMethod();
                break;
            }
            case 2:
            {
                filter_low_to_high();
                RenterMethod();
                break;
            }
            case 3:
            {
                filter_high_to_low();
                RenterMethod();
                break;
            }
            case 4:
            {
                rentCar();
                RenterMethod();
                break;
            }
            case 5:
            {
                searchCar();
                RenterMethod();
                break;
            }
            case 6:
            {
                obj.main(new String[0]);
                break;
            }
            case 0:
            {
                Exit();
                break;
            }
            default:
            {
                System.out.println("Error!");
                break;
            }
        }
    }


        public void rentCar ()
        {
            //majorfilter(ListofCompactCars,ListofSUVs,ListofLuxuryCars);
           int choice;
           String confirm;
           int id;
           int count=0;
            System.out.println("What type of Car You Want to Rent:");
            System.out.println("[1] Compact Cars");
            System.out.println("[2] SUVs ");
            System.out.println("[3] Luxury Cars");
            System.out.print("Enter Your Choice: ");
            choice=input.nextInt();
            while(choice<1||choice>3)
            {
                System.out.println("Invalid Choice!");
                System.out.print("Re-Enter Choice: ");
                choice=input.nextInt();
                if(choice>=1 && choice<=3)
                    break;
            }
            if(choice==1)
            {
                seeCompactCars();
                System.out.print("Enter the Car_Id You want to Rent:");
                id=input.nextInt();
                for(int i=0;i<ListofCompactCars.size();i++)
                {
                    if(ListofCompactCars.get(i).getCar_Id()==id)
                    {
                        if(ListofCompactCars.get(i).getRental_Status().equals("Available"))
                        {
                            System.out.print("Name: ");
                            Name=input.next();
                            input.nextLine();
                            System.out.print("CNIC: ");
                            CNIC=input.next();
                            input.nextLine();
                            System.out.print("Contact No: ");
                            Contact_No=input.next();
                            input.nextLine();
                            System.out.print("Address: ");
                            Address=input.next();
                            input.nextLine();
                            System.out.print("Enter the No of Hours You want to Rent for: ");
                            while (true) {
                                String temp = input.nextLine();
                                try {
                                    // Try to parse the input as an integer
                                    hours= Double.parseDouble(temp);
                                    // Break out of the loop if parsing was successful
                                    break;
                                } catch (NumberFormatException e) {
                                    // Inform the user that the input is not a valid integer
                                    System.out.println("Please Enter Valid No of hours!");
                                }
                            }

                            System.out.println("The Total Rental Cost is: "+hours*ListofCompactCars.get(i).getRental_Price()+"/-Rs for "+hours+" hours.");
                            System.out.println("Confirm! Press Y for Yes, N for No");
                            confirm=input.next();
                            while(!confirm.equals("Y") && !confirm.equals("N") &&!confirm.equals("y")&& !confirm.equals("n"))
                            {
                                System.out.println("Invalid character!");
                                System.out.print("Press Y for Yes, N for No: ");
                                confirm=input.next();
                                if(confirm.equals("Y") || confirm.equals("N") || confirm.equals("y")|| confirm.equals("n"))
                                    break;
                            }
                            if(confirm.equals("Y") || confirm.equals("y"))
                            {
                                Car_Name=ListofCompactCars.get(i).getCar_Name();
                                Price= (int) (hours * ListofCompactCars.get(i).getRental_Price());
                                Renter obj=new Renter(Name,CNIC,Contact_No,Address,hours,Car_Name,Price);
                                ListofRentalRequests.add(obj);
                                System.out.println("Car has been Rented Successfully!");
                                ListofCompactCars.get(i).setRental_Status("NotAvailable");
                                count++;
                                break;
                            }
                            else
                            {
                                count++;
                                break;
                            }
                        }
                        else
                        {
                            System.out.println("We Are Sorry! Car is Not Available for Rent.");
                            count++;
                        }
                    }
                }
                if(count==0)
                {
                    System.out.println("Invalid Id! Car Not found!");
                }
            }
            else if (choice==2) {
                seeSUVs();
                System.out.print("Enter the Car_Id You want to Rent:");
                id = input.nextInt();
                for (int i = 0; i < ListofSUVs.size(); i++) {
                    if (ListofSUVs.get(i).getCar_Id() == id) {
                        if (ListofSUVs.get(i).getRental_Status().equals("Available")) {
                            System.out.print("Name: ");
                            Name = input.next();
                            input.nextLine();
                            System.out.print("CNIC: ");
                            CNIC = input.next();
                            input.nextLine();
                            System.out.print("Contact No: ");
                            Contact_No = input.next();
                            input.nextLine();
                            System.out.print("Address: ");
                            Address = input.next();
                            input.nextLine();
                            System.out.print("Enter the No of Hours You want to Rent for: ");
                            while (true) {
                                String temp = input.nextLine();
                                try {
                                    // Try to parse the input as an integer
                                    hours = Double.parseDouble(temp);
                                    // Break out of the loop if parsing was successful
                                    break;
                                } catch (NumberFormatException e) {
                                    // Inform the user that the input is not a valid integer
                                    System.out.println("Please Enter Valid No of hours!");
                                }
                            }

                            System.out.println("The Total Rental Cost is: " + hours * ListofSUVs.get(i).getRental_Price() + "/-Rs for " + hours + " hours.");
                            System.out.println("Confirm! Press Y for Yes, N for No");
                            confirm = input.next();
                            while (!confirm.equals("Y") && !confirm.equals("N") &&!confirm.equals("y")&& !confirm.equals("n")) {
                                System.out.println("Invalid character!");
                                System.out.print("Press Y for Yes, N for No: ");
                                confirm = input.next();
                                if (confirm.equals("Y") || confirm.equals("N") || confirm.equals("y")|| confirm.equals("n"))
                                    break;
                            }
                            if (confirm.equals("Y") || confirm.equals("y")) {
                                Car_Name=ListofSUVs.get(i).getCar_Name();
                                Price= (int) (hours * ListofSUVs.get(i).getRental_Price());
                                Renter obj = new Renter(Name, CNIC, Contact_No, Address, hours,Car_Name,Price);
                                ListofRentalRequests.add(obj);

                                System.out.println("Car has been Rented Successfully!");
                                ListofSUVs.get(i).setRental_Status("NotAvailable");
                                count++;
                                break;
                            } else {
                                count++;
                                break;
                            }
                        } else {
                            System.out.println("We Are Sorry! Car is Not Available for Rent.");
                            count++;
                        }
                    }
                }
                if(count==0)
                {
                    System.out.println("Invalid Id! Car Not found!");
                }
            }
            else
            {
                seeLuxuryCars();
                System.out.print("Enter the Car_Id You want to Rent:");
                id=input.nextInt();
                for(int i=0;i<ListofLuxuryCars.size();i++) {
                    if (ListofLuxuryCars.get(i).getCar_Id() == id) {
                        if (ListofLuxuryCars.get(i).getRental_Status().equals("Available")) {
                            System.out.print("Name: ");
                            Name = input.next();
                            input.nextLine();
                            System.out.print("CNIC: ");
                            CNIC = input.next();
                            input.nextLine();
                            System.out.print("Contact No: ");
                            Contact_No = input.next();
                            input.nextLine();
                            System.out.print("Address: ");
                            Address = input.next();
                            input.nextLine();
                            System.out.print("Enter the No of Hours You want to Rent for: ");
                            while (true) {
                                String temp = input.nextLine();
                                try {
                                    // Try to parse the input as an integer
                                    hours = Double.parseDouble(temp);
                                    // Break out of the loop if parsing was successful
                                    break;
                                } catch (NumberFormatException e) {
                                    // Inform the user that the input is not a valid integer
                                    System.out.println("Please Enter Valid No of hours!");
                                }
                            }
                            System.out.println("The Total Rental Cost is: " + hours * ListofLuxuryCars.get(i).getRental_Price()+"/-Rs for " + hours + " hours");
                            System.out.println("Confirm! Press Y for Yes, N for No");
                            confirm = input.next();
                            while (!confirm.equals("Y") && !confirm.equals("N") &&!confirm.equals("y")&& !confirm.equals("n")) {
                                System.out.println("Invalid character!");
                                System.out.print("Press Y for Yes, N for No: ");
                                confirm = input.next();
                                if (confirm.equals("Y") || confirm.equals("N") || confirm.equals("y")|| confirm.equals("n"))
                                    break;
                            }
                            if (confirm.equals("Y") || confirm.equals("y")) {
                                Car_Name=ListofLuxuryCars.get(i).getCar_Name();
                                Price= (int) (hours * ListofLuxuryCars.get(i).getRental_Price());
                                Renter obj = new Renter(Name, CNIC, Contact_No, Address, hours,Car_Name,Price);
                                ListofRentalRequests.add(obj);
                                System.out.println("Car has been Rented Successfully!");
                                ListofLuxuryCars.get(i).setRental_Status("NotAvailable");
                                count++;
                                break;
                            } else {
                                count++;
                                break;
                            }
                        } else {
                            System.out.println("We Are Sorry! Car is Not Available for Rent.");
                            count++;
                        }
                    }
                }
                if(count==0)
                {
                    System.out.println("Invalid Id! Car Not found!");
                }
            }
        }
        public void filter_low_to_high ()
        {
            ArrayList<Car> New=majorfilter(ListofCompactCars,ListofSUVs,ListofLuxuryCars);
            for(int i=0;i<New.size();i++)
            {
                System.out.println("ID: "+New.get(i).getCar_Id());
                System.out.println("Manufacturer: "+New.get(i).getCar_Manufacturer());
                System.out.println("Name: "+New.get(i).getCar_Name());
                System.out.println("Model: "+New.get(i).getCar_Model());
                System.out.println("Rental Price: "+New.get(i).getRental_Price());
                System.out.println("Status: "+New.get(i).getRental_Status());
                System.out.println();
            }


        }

        public void filter_high_to_low ()
        {
            ArrayList<Car> New=majorfilter(ListofCompactCars,ListofSUVs,ListofLuxuryCars);
            for(int i=New.size()-1;i>=0;i--)
            {
                System.out.println("ID: "+New.get(i).getCar_Id());
                System.out.println("Manufacturer: "+New.get(i).getCar_Manufacturer());
                System.out.println("Name: "+New.get(i).getCar_Name());
                System.out.println("Model: "+New.get(i).getCar_Model());
                System.out.println("Rental Price: "+New.get(i).getRental_Price());
                System.out.println("Status: "+New.get(i).getRental_Status());
                System.out.println();
            }

        }
        public ArrayList<Car> majorfilter(ArrayList compactcar,ArrayList suv, ArrayList luxury)
        {
            ArrayList<Car> AllArrayList=new ArrayList<Car>();
            AllArrayList.addAll(compactcar);
            AllArrayList.addAll(suv);
            AllArrayList.addAll(luxury);

            Collections.sort(AllArrayList, new Comparator<Car>()
            {
                @Override
                public int compare(Car p1, Car p2) {
                    // Compare products based on their prices
                    return Double.compare(p1.getRental_Price(), p2.getRental_Price());
                }
            });
            return AllArrayList;
        }


    }


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import static java.lang.System.exit;

//methods and attributes common for both manager and renters
public class User
{
    Scanner input=new Scanner(System.in);
    //Declaring ArrayList of CompactCars,SUVs,LuxuryCars,rentalrequests
    public static ArrayList<CompactCar> ListofCompactCars=new ArrayList<CompactCar>();
    public static ArrayList<SUV> ListofSUVs=new ArrayList<SUV>();
    public static ArrayList<LuxuryCars> ListofLuxuryCars=new ArrayList<LuxuryCars>();
    public static ArrayList<Renter>ListofRentalRequests=new ArrayList<Renter>();



    public void listofcars()
    {
        int choice;
        System.out.println("[1] Compact Cars");
        System.out.println("[2] SUVs ");
        System.out.println("[3] Luxury Cars");
        System.out.println("[4] See All Cars");
        System.out.print("Enter Your Choice: ");
        choice=input.nextInt();
        while(choice<1||choice>4)
        {
            System.out.println("Invalid Choice!");
            System.out.print("Re-Enter Choice: ");
            choice=input.nextInt();
            if(choice>=1 && choice<=4)
                break;
        }
        if(choice==1)
        {
            seeCompactCars();
        }
        else if (choice==2)
        {
            seeSUVs();
        }
        else if (choice==3)
        {
            seeLuxuryCars();
        }
        else
        {
            seeCompactCars();
            seeSUVs();
            seeLuxuryCars();
        }


    }
    //to see compactCars only
    public void seeCompactCars()
    {
        System.out.println("Compact Cars");
        System.out.println();
        for(int i=0;i<ListofCompactCars.size();i++)
        {
            System.out.println("ID: "+ListofCompactCars.get(i).getCar_Id());
            System.out.println("Manufacturer: "+ListofCompactCars.get(i).getCar_Manufacturer());
            System.out.println("Name: "+ListofCompactCars.get(i).getCar_Name());
            System.out.println("Model: "+ListofCompactCars.get(i).getCar_Model());
            System.out.println("Rental Price: "+ListofCompactCars.get(i).getRental_Price());
            System.out.println("Status: "+ListofCompactCars.get(i).getRental_Status());
            System.out.println();
        }
    }
    //to see SUVs Only
    public void seeSUVs()
    {
        System.out.println("SUVs");
        System.out.println();
        for(int i=0;i<ListofSUVs.size();i++)
        {
            System.out.println("ID: "+ListofSUVs.get(i).getCar_Id());
            System.out.println("Manufacturer: "+ListofSUVs.get(i).getCar_Manufacturer());
            System.out.println("Name: "+ListofSUVs.get(i).getCar_Name());
            System.out.println("Model: "+ListofSUVs.get(i).getCar_Model());
            System.out.println("Rental Price: "+ListofSUVs.get(i).getRental_Price());
            System.out.println("Status: "+ListofSUVs.get(i).getRental_Status());
            System.out.println();
        }
    }
    //to see luxuryCars only
    public void seeLuxuryCars()
    {
        System.out.println("Luxury Cars");
        System.out.println();
        for(int i=0;i<ListofLuxuryCars.size();i++)
        {
            System.out.println("ID: "+ListofLuxuryCars.get(i).getCar_Id());
            System.out.println("Manufacturer: "+ListofLuxuryCars.get(i).getCar_Manufacturer());
            System.out.println("Name: "+ListofLuxuryCars.get(i).getCar_Name());
            System.out.println("Model: "+ListofLuxuryCars.get(i).getCar_Model());
            System.out.println("Rental Price: "+ListofLuxuryCars.get(i).getRental_Price());
            System.out.println("Status: "+ListofLuxuryCars.get(i).getRental_Status());
            System.out.println();
        }

    }
    public void searchCar()
    {
        int choice;
        String Name;
        int count=0;
        System.out.println("What type of Car are you Looking for?");
        System.out.println();
        System.out.println("[1] Compact Car");
        System.out.println("[2] SUVs");
        System.out.println("[3] Luxury Car");
        System.out.print("Enter Your Choice: ");
        choice=input.nextInt();
        if(choice==1)
        {
            System.out.print("Please Enter the Name: ");
            Name=input.next();
            for(int i=0;i<ListofCompactCars.size();i++)
            {
                if(ListofCompactCars.get(i).getCar_Name().equalsIgnoreCase(Name))
                {
                    System.out.println("ID: "+ListofCompactCars.get(i).getCar_Id());
                    System.out.println("Manufacturer: "+ListofCompactCars.get(i).getCar_Manufacturer());
                    System.out.println("Name: "+ListofCompactCars.get(i).getCar_Name());
                    System.out.println("Model: "+ListofCompactCars.get(i).getCar_Model());
                    System.out.println("Rental Price: "+ListofCompactCars.get(i).getRental_Price());
                    System.out.println("Status: "+ListofCompactCars.get(i).getRental_Status());
                    System.out.println();
                    count++;
                }
            }
            if(count==0)
            {
                System.out.println(Name+ " is Not Available!");
            }
        }
        else if (choice==2)
        {
            System.out.print("Please Enter the Name: ");
            Name=input.next();
            for(int i=0;i<ListofSUVs.size();i++)
            {
                if(ListofSUVs.get(i).getCar_Name().equalsIgnoreCase(Name))
                {
                    System.out.println("ID: "+ListofSUVs.get(i).getCar_Id());
                    System.out.println("Manufacturer: "+ListofSUVs.get(i).getCar_Manufacturer());
                    System.out.println("Name: "+ListofSUVs.get(i).getCar_Name());
                    System.out.println("Model: "+ListofSUVs.get(i).getCar_Model());
                    System.out.println("Rental Price: "+ListofSUVs.get(i).getRental_Price());
                    System.out.println("Status: "+ListofSUVs.get(i).getRental_Status());
                    System.out.println();
                    count++;
                }
            }
            if(count==0)
            {
                System.out.println(Name+ " is Not Available!");
            }
        }
        else
        {
            System.out.print("Please Enter the Name: ");
            Name=input.next();
            for(int i=0;i<ListofLuxuryCars.size();i++)
            {
                if(ListofLuxuryCars.get(i).getCar_Name().equalsIgnoreCase(Name))
                {
                    System.out.println("ID: "+ListofLuxuryCars.get(i).getCar_Id());
                    System.out.println("Manufacturer: "+ListofLuxuryCars.get(i).getCar_Manufacturer());
                    System.out.println("Name: "+ListofLuxuryCars.get(i).getCar_Name());
                    System.out.println("Model: "+ListofLuxuryCars.get(i).getCar_Model());
                    System.out.println("Rental Price: "+ListofLuxuryCars.get(i).getRental_Price());
                    System.out.println("Status: "+ListofLuxuryCars.get(i).getRental_Status());
                    System.out.println();
                    count++;
                }
            }
            if(count==0)
            {
                System.out.println(Name+ " is Not Available!");
            }
        }

    }

    public void Exit()
    {
        //For Compact Car
        BufferedWriter writer1 = null;
        try {
            writer1 = new BufferedWriter(new FileWriter("compactCars.txt"));

            for(int i=0;i<ListofCompactCars.size();i++)
            {
                String line1=ListofCompactCars.get(i).getCar_Id()+"#"+
                        ListofCompactCars.get(i).getCar_Manufacturer()+"#"+
                        ListofCompactCars.get(i).getCar_Name()+"#"+
                        ListofCompactCars.get(i).getCar_Model()+"#"+
                        ListofCompactCars.get(i).getRental_Price()+"#"+
                        ListofCompactCars.get(i).getRental_Status()+
                        System.lineSeparator();
                writer1.write(line1);
            }

            writer1.close();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }


        //For SUV
        BufferedWriter writer2 = null;
        try {
            writer2 = new BufferedWriter(new FileWriter("SUVs.txt"));

            for(int i=0;i<ListofSUVs.size();i++)
            {
                String line2=ListofSUVs.get(i).getCar_Id()+"#"+
                        ListofSUVs.get(i).getCar_Manufacturer()+"#"+
                        ListofSUVs.get(i).getCar_Name()+"#"+
                        ListofSUVs.get(i).getCar_Model()+"#"+
                        ListofSUVs.get(i).getRental_Price()+"#"+
                        ListofSUVs.get(i).getRental_Status()+
                        System.lineSeparator();
                writer2.write(line2);
            }

            writer2.close();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage()); // Printing error message
        }


        //For Luxury
        BufferedWriter writer3 = null;
        try {
            writer3 = new BufferedWriter(new FileWriter("luxuryCars.txt"));

            for(int i=0;i<ListofLuxuryCars.size();i++)
            {
                String line3=ListofLuxuryCars.get(i).getCar_Id()+"#"+
                        ListofLuxuryCars.get(i).getCar_Manufacturer()+"#"+
                        ListofLuxuryCars.get(i).getCar_Name()+"#"+
                        ListofLuxuryCars.get(i).getCar_Model()+"#"+
                        ListofLuxuryCars.get(i).getRental_Price()+"#"+
                        ListofLuxuryCars.get(i).getRental_Status()+
                        System.lineSeparator();
                writer3.write(line3);
            }

            writer3.close();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage()); // Printing error message
        }


        //For Rental Requests
        BufferedWriter writer4 = null;
        try {
            writer4 = new BufferedWriter(new FileWriter("rentalrequests.txt"));

            for(int i=0;i<ListofRentalRequests.size();i++)
            {
                String line1=ListofRentalRequests.get(i).getName()+"#"+
                        ListofRentalRequests.get(i).getCNIC()+"#"+
                        ListofRentalRequests.get(i).getContact_No()+"#"+
                        ListofRentalRequests.get(i).getAddress()+"#"+
                        ListofRentalRequests.get(i).getHours()+"#"+
                        ListofRentalRequests.get(i).getCar_Name()+"#"+
                        ListofRentalRequests.get(i).getPrice()+
                        System.lineSeparator();
                writer4.write(line1);
            }

            writer4.close();
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage()); // Printing error message
        }

        System.out.println("Exiting.......Goodbye!");
        exit(0);
    }

}

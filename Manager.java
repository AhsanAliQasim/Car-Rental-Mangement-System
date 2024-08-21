import java.util.Scanner;

public class Manager extends User
{
    Scanner input=new Scanner(System.in);
    //Main Method of Manager
    public void ManagerMethod()
    {
        Main obj=new Main();
        int choice;
        System.out.println("Main Menu for Manager");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("[1] List of Cars");
        System.out.println("[2] Add a New Car");
        System.out.println("[3] Remove a Car");
        System.out.println("[4] See Rental details");
        System.out.println("[5] Search for a Car");
        System.out.println("[6] Logout");
        System.out.println("[0] Exit");
        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("Enter Your Choice: ");
        choice=input.nextInt();
        while(choice<0||choice>6)
        {
            System.out.println("Invalid Choice!");
            System.out.println("Re-Enter Choice:");
            choice=input.nextInt();
            if(choice>=0&&choice<=6)
                break;
        }
        switch(choice)
        {
            case 1:
            {
                listofcars();
                ManagerMethod();
                break;
            }
            case 2:
            {
                addnewCar();
                ManagerMethod();
                break;
            }
            case 3:
            {
                removeCar();
                ManagerMethod();
                break;
            }
            case 4:
            {
                listofRenters();
                ManagerMethod();
                break;
            }
            case 5:
            {
                searchCar();
                ManagerMethod();
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
    public void addnewCar()
    {
        //id khud calculate krni h, teeno k Arrayylist.size() ko add kr k +1
        int id=(ListofCompactCars.size()+ListofLuxuryCars.size()+ListofSUVs.size())+1;
        String Manufacturer;
        String Name;
        int Model;
        int Rental_Price;
        String Status="Available";

        int choice;
        System.out.println("Select the category of Car you want to Add: ");
        System.out.println("[1] Compact Car");
        System.out.println("[2] SUV");
        System.out.println("[3] Luxury");
        choice=input.nextInt();
        while(choice<1 || choice>3)
        {
            System.out.println("Invalid Choice!");
            System.out.println("Re-Enter Choice:");
            choice=input.nextInt();
            if(choice>=1&&choice<=3)
                break;
        }
        if(choice==1)
        {
            System.out.println("Enter the following details!");
            System.out.print("Manufacturer: ");
            Manufacturer= input.next();
            System.out.print("Name: ");
            Name= input.next();
            System.out.print("Model: ");
            Model=input.nextInt();
            System.out.print("Rental Price: ");
            Rental_Price=input.nextInt();
            CompactCar obj=new CompactCar(id,Manufacturer,Name,Model,Rental_Price,Status);
            //Arraylist ka built-in method hai
            ListofCompactCars.add(obj);
            System.out.println("Car has been Added Successfully!");
        }
        else if (choice==2)
        {
            System.out.println("Enter the following details!");
            System.out.print("Manufacturer: ");
            Manufacturer= input.next();
            System.out.print("Name: ");
            Name= input.next();
            System.out.print("Model: ");
            Model=input.nextInt();
            System.out.print("Rental Price: ");
            Rental_Price=input.nextInt();
            SUV obj=new SUV(id,Manufacturer,Name,Model,Rental_Price,Status);
            ListofSUVs.add(obj);
            System.out.println("Car has been Added Successfully!");
        }
        else
        {
            System.out.println("Enter the following details!");
            System.out.print("Manufacturer: ");
            Manufacturer= input.next();
            System.out.print("Name: ");
            Name= input.next();
            System.out.print("Model: ");
            Model=input.nextInt();
            System.out.print("Rental Price: ");
            Rental_Price=input.nextInt();
            LuxuryCars obj=new LuxuryCars(id,Manufacturer,Name,Model,Rental_Price,Status);
            ListofLuxuryCars.add(obj);
            System.out.println("Car has been Added Successfully!");
        }


    }
    public void removeCar()
    {
        int choice;
        System.out.println("Select the category of Car you want to remove: ");
        System.out.println("[1] Compact Car");
        System.out.println("[2] SUV");
        System.out.println("[3] Luxury");
        choice=input.nextInt();
        while(choice<1 || choice>3)
        {
            System.out.println("Invalid Choice!");
            System.out.println("Re-Enter Choice:");
            choice=input.nextInt();
            if(choice>=1&&choice<=3)
                break;
        }
        if(choice==1)
        {
            int id;
            int count=0;
            seeCompactCars();
            System.out.print("Enter the Car id You want to Remove: ");
            id=input.nextInt();
            for(int i=0;i<ListofCompactCars.size();i++)
            {
                if(id==ListofCompactCars.get(i).getCar_Id())
                {
                    ListofCompactCars.remove(i);
                    System.out.println("Car has been Removed Successfully");
                    count++;
                }
            }
            if(count==0)
            {
                System.out.println("Invalid Id! Car cannot be removed");
            }
        }
        else if (choice==2)
        {
            int id;
            int count=0;
            seeCompactCars();
            System.out.print("Enter the Car id You want to Remove: ");
            id=input.nextInt();
            for(int i=0;i<ListofSUVs.size();i++)
            {
                if(id==ListofSUVs.get(i).getCar_Id())
                {
                    ListofSUVs.remove(i);
                    System.out.println("Car has been Removed Successfully");
                    count++;
                }
            }
            if(count==0)
            {
                System.out.println("Invalid Id! Car cannot be removed");
            }
        }
        else
        {
            int id;
            int count=0;
            seeCompactCars();
            System.out.print("Enter the Car id You want to Remove: ");
            id=input.nextInt();
            for(int i=0;i<ListofSUVs.size();i++)
            {
                if(id==ListofSUVs.get(i).getCar_Id())
                {
                    ListofSUVs.remove(i);
                    System.out.println("Car has been Removed Successfully");
                    count++;
                }
            }
            if(count==0)
            {
                System.out.println("Invalid Id! Car cannot be removed");
            }
        }
    }
    public void listofRenters()
    {
        System.out.println("List of Renters: ");
        System.out.println();
        for(int i=0;i<ListofRentalRequests.size();i++)
        {
            System.out.println("Name: "+ListofRentalRequests.get(i).getName());
            System.out.println("CNIC: "+ListofRentalRequests.get(i).getCNIC());
            System.out.println("Contact No: "+ListofRentalRequests.get(i).getContact_No());
            System.out.println("Address: "+ListofRentalRequests.get(i).getAddress());
            System.out.println("Hours: "+ListofRentalRequests.get(i).getHours());
            System.out.println("Car Rented: "+ListofRentalRequests.get(i).getCar_Name());
            System.out.println("Total Cost: "+ListofRentalRequests.get(i).getPrice());
            System.out.println();
        }
    }


}

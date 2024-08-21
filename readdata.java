import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class readdata
{
    //CompactCar file reading
    public void readcompactcarstoarray(ArrayList listofcompactcars)
    {
        BufferedReader reader = null;

        try {
            FileReader fr = new FileReader("compactCars.txt");
            reader = new BufferedReader(fr);

            String line; // Declaring a variable to store each line

            // Reading each line from the file until the end is reached
            while ((line = reader.readLine()) != null) {
                // Printing each line to the console
                String[] tokens = line.split("#");

                // Parsing and displaying each token
                int ID = Integer.parseInt(tokens[0]);
                String Manufacturer = tokens[1];
                String Name = tokens[2];
                int Model = Integer.parseInt(tokens[3]);
                int Rent= Integer.parseInt(tokens[4]);
                String Status=tokens[5];
                CompactCar c=new CompactCar(ID,Manufacturer,Name,Model,Rent,Status);
                listofcompactcars.add(c);
            }

            reader.close();
            fr.close();
        } catch (IOException e) { // Catching any IOException that might occur
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
    //SUVs file reading
    public void readSUVs(ArrayList listofSUVs)
    {
        BufferedReader reader = null;

        try {
            FileReader fr = new FileReader("SUVs.txt");
            reader = new BufferedReader(fr);

            String line; // Declaring a variable to store each line

            // Reading each line from the file until the end is reached
            while ((line = reader.readLine()) != null) {
                // Printing each line to the console
                String[] tokens = line.split("#");

                // Parsing and displaying each token
                int ID = Integer.parseInt(tokens[0]);
                String Manufacturer = tokens[1];
                String Name = tokens[2];
                int Model = Integer.parseInt(tokens[3]);
                int Rent= Integer.parseInt(tokens[4]);
                String Status=tokens[5];
                SUV c=new SUV(ID,Manufacturer,Name,Model,Rent,Status);
                listofSUVs.add(c);
            }

            reader.close();
            fr.close();
        } catch (IOException e) { // Catching any IOException that might occur
            System.err.println("Error reading the file: " + e.getMessage()); // Printing error message
        }
    }

    //luxuryCars file reading
    public void readluxurycars(ArrayList listofluxurycars)
    {
        BufferedReader reader = null;

        try {
            FileReader fr = new FileReader("luxuryCars.txt");
            reader = new BufferedReader(fr);

            String line; // Declaring a variable to store each line

            // Reading each line from the file until the end is reached
            while ((line = reader.readLine()) != null) {
                // Printing each line to the console
                String[] tokens = line.split("#");

                // Parsing and displaying each token
                int ID = Integer.parseInt(tokens[0]);
                String Manufacturer = tokens[1];
                String Name = tokens[2];
                int Model = Integer.parseInt(tokens[3]);
                int Rent= Integer.parseInt(tokens[4]);
                String Status=tokens[5];
                LuxuryCars c=new LuxuryCars(ID,Manufacturer,Name,Model,Rent,Status);
                listofluxurycars.add(c);
            }

            reader.close();
            fr.close();
        } catch (IOException e) { // Catching any IOException that might occur
            System.err.println("Error reading the file: " + e.getMessage()); // Printing error message
        }
    }

    public void readrentaldetailtoarray(ArrayList listofrentaldetails)
    {
        BufferedReader reader = null;

        try {
            FileReader fr = new FileReader("rentalrequests.txt");
            reader = new BufferedReader(fr);

            String line; // Declaring a variable to store each line

            // Reading each line from the file until the end is reached
            while ((line = reader.readLine()) != null) {
                // Printing each line to the console
                String[] tokens = line.split("#");

                // Parsing and displaying each token
                if(tokens.length>=7) {
                    String Name = tokens[0];
                    String CNIC = tokens[1];
                    String Contact_No = tokens[2];
                    String Address = tokens[3];
                    float hours = Float.parseFloat(tokens[4]);
                    String Car_Name = tokens[5];
                    int Price = Integer.parseInt(tokens[6]);
                    Renter c = new Renter(Name, CNIC, Contact_No, Address, hours, Car_Name, Price);
                    listofrentaldetails.add(c);
                }
                else
                    System.err.println("Invalid data format in line: " + line);
            }

            reader.close();
            fr.close();
        } catch (IOException e) { // Catching any IOException that might occur
            System.err.println("Error reading the file: " + e.getMessage()); // Printing error message
        }
    }
}


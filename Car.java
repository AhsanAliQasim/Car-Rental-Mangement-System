public class Car
{
    private int Car_Id;
    private String Car_Manufacturer;
    private String Car_Name;
    private int Car_Model;
    private int Rental_Price;
    private String Rental_Status;

    public Car(int Car_Id,String Car_Manufacturer,String Car_Name,int Car_Model,int Rental_Price,String Rental_Status)
    {
        this.Car_Id=Car_Id;
        this.Car_Manufacturer=Car_Manufacturer;
        this.Car_Name=Car_Name;
        this.Car_Model=Car_Model;
        this.Rental_Price=Rental_Price;
        this.Rental_Status=Rental_Status;
    }
    public int getCar_Id()
    {
        return Car_Id;
    }
    public String getCar_Manufacturer()
    {
        return Car_Manufacturer;
    }
    public String getCar_Name()
    {
        return Car_Name;
    }

    public int getCar_Model()
    {
        return Car_Model;
    }
    public int getRental_Price()
    {
        return Rental_Price;
    }
    public String getRental_Status()
    {
        return Rental_Status;
    }
    public void setRental_Status(String newstatus)
    {
        this.Rental_Status=newstatus;
    }
    // Set Availability Method Missing


    @Override
    public String toString()
    {
        return "Id: "+Car_Id+" Brand: "+Car_Manufacturer+" Name: "+Car_Name+" Model: "+Car_Model+" Rental Price: "+Rental_Price+" Rental Status: "+Rental_Status;
    }
}

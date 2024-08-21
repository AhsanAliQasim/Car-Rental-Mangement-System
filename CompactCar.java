public class CompactCar extends Car
{


    public CompactCar(int Car_Id, String Car_Brand, String Car_Name, int Car_Model, int Rental_Price, String Rental_Status)
    {
        super(Car_Id, Car_Brand, Car_Name, Car_Model, Rental_Price, Rental_Status);
    }

    public double calculateRentalCost(float hours)
    {
        return hours*getRental_Price();
    }
}

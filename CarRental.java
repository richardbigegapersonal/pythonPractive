import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CarRental {

    //Three linkedlist maintained for the cars
    public static LinkedList<CarRent> availableRent = new LinkedList<CarRent>();
    public static LinkedList<CarRent> rented = new LinkedList<CarRent>();
    public static LinkedList<CarRent> inrepairlist = new LinkedList<CarRent>();

    public static void main(String args[]) throws ParseException {
        Scanner scan;

        System.out.println("Please enter the transaction code as follows");
        System.out.println("1. add a new car to the available-for-rent list");
        System.out.println("2. add a returned car to the available-for-rent list");
        System.out.println("3. add a returned car to the repair list");
        System.out.println(" 4. transfer a car from the repair list to the available-for-rent list");
        System.out.println("5. rent the first available car");
        System.out.println(" 6. print all the lists");
        System.out.println("7. quit");

        scan = new Scanner(System.in);

        // Reading the double values from input file and storing in arraylist of type double
        int transactioncode = -1;
        while (scan.hasNextInt()) {
            transactioncode = scan.nextInt();
        }
        if(transactioncode != -1){
            switch(transactioncode){
                case 1:
                    System.out.println("Please enter the plate number and mileage");
                    String platenumber = scan.nextLine();
                    int mileage = scan.nextInt();
                    int totalcharge = computecharge(mileage);
                    CarRent carrent = new CarRent();
                    carrent.setPlatenumber(platenumber.toCharArray());
                    carrent.setTotalCosttopay(totalcharge);
                    //Adding new car for available to rent list
                    availableRent.add(carrent);
                    break;

                case 2:
                    System.out.println("Please enter the plate number and mileage");
                    String platenumber1 = scan.nextLine();
                    int mileage1 = scan.nextInt();
                    int totalcharge1 = computecharge(mileage1);
                    CarRent carrent1 = new CarRent();
                    carrent1.setPlatenumber(platenumber1.toCharArray());
                    carrent1.setTotalCosttopay(totalcharge1);
                    //Adding new car for available to rent list
                    availableRent.add(carrent1);
                    break;

                case 3:
                    System.out.println("Please enter the plate number and mileage");
                    String platenumber_repair = scan.nextLine();
                    int mileage_repair = scan.nextInt();
                    int totalcharge_repair = computecharge(mileage_repair);
                    CarRent carrent_repair = new CarRent();
                    carrent_repair.setPlatenumber(platenumber_repair.toCharArray());
                    carrent_repair.setTotalCosttopay(totalcharge_repair);
                    //Adding returned car to repair list
                    inrepairlist.add(carrent_repair);
                    break;

                case 4:
                    System.out.println("Please enter the plate number");
                    String platenumber_transfer = scan.nextLine();
                    char[] platetosearch = platenumber_transfer.toCharArray();
                    int index = 0;
                    CarRent car2rent = null;
                    for(CarRent a: inrepairlist){
                        index++;
                        if(platetosearch.equals(a.getPlatenumber())){
                            car2rent = inrepairlist.get(index);
                        }
                    }
                    availableRent.add(car2rent);
                    break;

                case 5:
                    System.out.println("Please enter the expected return date ");
                    String dateFormat = "yymmdd";
                    new CarRent().setReturndate(new SimpleDateFormat(dateFormat).parse(scan.nextLine()));
                    CarRent firstRentalCar = availableRent.getFirst();
                    System.out.println("This is the first rental car available " + firstRentalCar.getCarname());
                    break;
                case 6:
                    printAll();
                    break;
                case 7:
                    //Exit on 7
                    calculatetotalincome();
                    System.exit(0);
            }

        }
    }
public static int computecharge(int mileage){
        //a flat rate of $40.00 for up to 100 km

        if(mileage < 100){
         return 100;
        }else{
            //15 cents per km for the additional (i.e. beyond 100) kilometers.
            return (int) (100 + (0.15)*(mileage - 100));
        }
    }
    public static void printAll(){
        // Printing all the list
        for(CarRent rent : availableRent){
            System.out.println("Cars list which are available for rent " + rent);
        }

        for(CarRent r : rented){
            System.out.println("Cars list which are rented " + r.toString());
        }

        for(CarRent r2 : inrepairlist){
            System.out.println("Cars list which are rented " + r2.toString());
        }
    }

    public static void calculatetotalincome(){
        int totalincome = 0;
        for(CarRent rent : rented){
            totalincome += rent.getTotalCosttopay();
            System.out.println("Total income from all the rented cars is " + totalincome);
        }
    }
}

package CSC3101;

import java.util.ArrayList;
import java.util.Scanner;

//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:4
public class lab4 {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();

        MPV mpv = new MPV(120, "20000", "Blue", 16);
        cars.add(mpv);

        Sedan sedan = new Sedan(100, "25000", "Red", 2019, 2000);
        cars.add(sedan);

        Caravan caravan = new Caravan(80, "30000", "Green", 2700);
        cars.add(caravan);

        for (Car car : cars) {
            if (car instanceof MPV) {
                System.out.println("Car type: MPV\nsale price:" + car.salePrice());
            } else if (car instanceof Sedan) {
                System.out.println("Car type: Sedan\nsale price:" + car.salePrice());
            } else if (car instanceof Caravan) {
                System.out.println("Car type: Caravan\nsale price:" + car.salePrice());
            }
        }

        System.out.println("--------------");
        //q2
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter street address: ");
        String address = scanner.nextLine();

        NewspaperSubscriber sevendays = new SevenDaySubscriber(address);
        NewspaperSubscriber weekday = new WeekDaySubscriber(address);
        NewspaperSubscriber weekend = new WeekendSubscriber(address);

        printDetails(sevendays);
        printDetails(weekday);
        printDetails(weekend);
    }

    public static void printDetails(Object o) {
        if (o instanceof NewspaperSubscriber) {
            System.out.println(o.toString());
        }
    }
}

class Car {
    private int speed;
    private String regularPrice;
    private String color;

    public Car(int speed, String regularPrice, String color) {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double salePrice() {
        return Double.parseDouble(regularPrice);
    }
}

class MPV extends Car {
    private int length;

    public MPV(int speed, String regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public double salePrice() {
        if (length > 15) {
            return (1 - 0.025) * Double.parseDouble(getRegularPrice());
        } else {
            return (1 - 0.05) * Double.parseDouble(getRegularPrice());
        }
    }
}

class Sedan extends Car {
    private int year;
    private int manufacturerDiscount;

    public Sedan(int speed, String regularPrice, String color, int year, int manufacturerDiscount) {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getManufacturerDiscount() {
        return manufacturerDiscount;
    }

    public void setManufacturerDiscount(int manufacturerDiscount) {
        this.manufacturerDiscount = manufacturerDiscount;
    }

    @Override
    public double salePrice() {
        return Double.parseDouble(getRegularPrice()) - manufacturerDiscount;
    }
}

class Caravan extends Car {
    private int weight;

    public Caravan(int speed, String regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public double salePrice() {
        if (weight > 2500) {
            return (1 - 0.075) * Double.parseDouble(getRegularPrice());
        } else {
            return (1 - 0.1) * Double.parseDouble(getRegularPrice());
        }
    }
}


// q2
class NewspaperSubscriber {
    private String streetAddress;
    private double subscriptionRate;

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setSubscriptionRate(double subscriptionRate) {
        this.subscriptionRate = subscriptionRate;
    }

    public double getSubscriptionRate() {
        return subscriptionRate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NewspaperSubscriber that = (NewspaperSubscriber) obj;
        return this.streetAddress.equals(that.streetAddress);
    }

    @Override
    public String toString() {
        return "Service Type: Unknown, Address: " + streetAddress + ", Rate: RM" + subscriptionRate;
    }
}



class SevenDaySubscriber extends NewspaperSubscriber {
    public SevenDaySubscriber(String streetAddress) {
        setStreetAddress(streetAddress);
        setSubscriptionRate(4.50);
    }

    @Override
    public String toString() {
        return "Service Type: Seven Day Subscriber, Address: " + getStreetAddress() + ", Rate: RM" + getSubscriptionRate();
    }
}

class WeekDaySubscriber extends NewspaperSubscriber {
    public WeekDaySubscriber(String streetAddress) {
        setStreetAddress(streetAddress);
        setSubscriptionRate(3.50);
    }

    @Override
    public String toString() {
        return "Service Type: Weekday Subscriber, Address: " + getStreetAddress() + ", Rate: RM" + getSubscriptionRate();
    }
}

class WeekendSubscriber extends NewspaperSubscriber {
    public WeekendSubscriber(String streetAddress) {
        setStreetAddress(streetAddress);
        setSubscriptionRate(2.00);
    }

    @Override
    public String toString() {
        return "Service Type: Weekend Subscriber, Address: " + getStreetAddress() + ", Rate: RM" + getSubscriptionRate();
    }
}

package CSC3101;
//Author's name:ZHANG ZHE
// Matric number:218629
// Lab No:1
public class lab1 {
    public static void main(String[] args) {
        //q1
        Stock stock=new Stock("ORCL","Oracle Corporation");
        stock.setPreviousClosingPrice(34.5);
        stock.setCurrentPrice(34.35);
        //System.out.println("price change percentage is "+stock.getChangePercent());

        //q2
        Fan fan1=new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        Fan fan2=new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(true);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}

//q1
class Stock {
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    public Stock(String symbol,String name){
        this.symbol=symbol;
        this.name=name;
        this.currentPrice=0;// set default value
        this.previousClosingPrice=0;// set default value
    }

    public String getChangePercent(){
        return ((this.currentPrice-this.previousClosingPrice)/this.previousClosingPrice)*100+"%";
    }

    public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
    }

    public Stock() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}


//q2
class Fan {
    public static final int SLOW=1;
    public static final int MEDIUM=2;
    public static final int FAST=3;
    private int speed=SLOW;
    private boolean on=false;
    private double radius=5;
    private String color="blue";

    @Override
    public String toString() {
        String speed;
        switch (this.speed){
            case 1:speed="SLOW";
            break;
            case 2:speed="MEDIUM";
            break;
            case 3:speed="FAST";
            break;
            default:speed=null;
        }
        if(this.on)return "Fan: speed:"+speed+" color:"+this.color+" radius:"+this.radius;
        else return "Fan: color:"+this.color+" radius:"+this.radius+" fan is off";
    }

    public Fan() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

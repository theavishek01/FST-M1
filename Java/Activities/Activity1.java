package Activities;

public class Activity1 {
    public static void main(String[] args) {
        Car Bmw = new Car();
        Bmw.make = 2014;
        Bmw.color = "Black";
        Bmw.transmission = "Manual";

        Bmw.displayCharecteristics();
        Bmw.accelerate();
        Bmw.breaks();
    }
}

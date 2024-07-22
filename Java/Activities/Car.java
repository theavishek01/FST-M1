package Activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    Car(){
        tyres = 4;
        doors = 4;
    }
    void displayCharecteristics(){
        System.out.println("The color of the car is"+" "+color);
        System.out.println("The car transmission type is"+" "+transmission);
        System.out.println("The car make is"+" "+make);
        System.out.println("Number of tyres in the car"+" "+tyres);
        System.out.println("Number of doors in the car is"+" "+doors);
    }
    void accelerate(){
        System.out.println("Car is moving forward");
    }
    void breaks(){
        System.out.println("Car has stopped.");
    }
}

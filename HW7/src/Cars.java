/*
This program takes a car and adds fuel into the its fuel gauge. Then, it will keep accelerating and braking the car in multiple trips until there is no more fuel left in the car. It will
print the speed, total mileage and total amount of fuel left after every trip
*/
public class Cars{
  public static void main(String[] args){
    Car BMW = new Car(2022, "BMW");  //Creating new Car object
    Car.FuelGauge fuelGaugeOfBMW = new Car.FuelGauge(0);  //Creating new FuelGauge object
    Car.Odometer odometerOfBMW = new Car.Odometer(0,fuelGaugeOfBMW);  //Creating new Odometer object
    int gallons=15;  //Amount of gallons to put into car

    for(int i=1; i<=gallons; i++){
      fuelGaugeOfBMW.addFuel();  //Add 15 gallons into car
    }
    System.out.println("The starting amount of fuel that the " + BMW.getMake() + " has is " + fuelGaugeOfBMW.getFuel() + " gallons and the starting mileage is " + odometerOfBMW.getMileage() + " miles\n");  //Starting fuel and mileage
    while(fuelGaugeOfBMW.getFuel()!=0){  //While there is still fuel left in the car
      for(int j=1; j<=5; j++){
        BMW.accelerate();  //Accelerate in multiples of 5
        System.out.println("Accelerating: The speed of " + BMW.getMake() + " is now " + BMW.getSpeed() + " miles per hour");  //Print speed after each acceleration
      }
      for(int k=1; k<=BMW.getSpeed(); k++){  //Update mileage in odometer
        if(odometerOfBMW.getMileage()<gallons*24){  //If total mileage is less than total gallons in the car multipled by a car's fuel economy(24 miles per gallon)
          odometerOfBMW.addMileage();  //Add a mile to total mileage
          odometerOfBMW.decreaseFuel();  //Decrease fuel in the car
        }
        else{
          break;  //Else just break out of loop
        }
      }
      System.out.println("Current fuel in " + BMW.getMake() + ": " + fuelGaugeOfBMW.getFuel() + " gallons");  //Update total fuel
      System.out.println("Current mileage for " + BMW.getMake() + ": " + odometerOfBMW.getMileage() + " miles");  //Update total mileage
      for(int l=1; l<=5; l++){
        BMW.brake();  //Brake in multiples of 5
        System.out.println("Braking: The speed of the " + BMW.getMake() + " is now " + BMW.getSpeed() + " miles per hour");  //Print speed after each brake
      }
      System.out.println();
    }
  }
}

/*
This class represents a typical car you would see in real life with attributes such as year model, make and speed. It also allows for acceleration and braking of the car. The two inner classes
include the fuel gauge and the odometer
*/
class Car{
  private int yearModel;
  private String make;
  private int speed;

  Car(int yearModel, String make){  //Constructor takes an integer and String, in the form of year model and make, and assigns these values to the object's year model and make. It also sets the default speed to 0
    this.yearModel=yearModel;
    this.make=make;
    this.speed=0;
  }

  public int getYearModel(){  //Returns the year model
    return this.yearModel;
  }

  public String getMake(){  //Returns the make
    return this.make;
  }

  public int getSpeed(){  //Returns the speed
    return this.speed;
  }

  public void accelerate(){  //Accelerates the car
    if(this.speed<100){  //If speed is less than maximum speed of 100mph, add 5mph for each acceleration
      this.speed+=5;
    }
  }

  public void brake(){  //Brakes the car
    if(this.speed>=5){  //If speed is more than or equal to 5mph, decrease 5mph for each brake
      this.speed-=5;
    }
  }

  //This class represents a fuel gauge and tracks the amount of fuel in the car, allowing fuel to be added to the car and fuel to be burned from the car
  static class FuelGauge{
    private double fuel;

    public FuelGauge(double fuel){  //Constructor takes in a double, value for fuel, and sets the object's amount of fuel to this value
      if(fuel<=15){  //If parameter's value is less than or equal to 15, set it to that value
        this.fuel=fuel;
      }
      else{  //Else, just set it to the maximum fuel which is 15
        this.fuel=15;
      }
    }

    public double getFuel(){  //Returns amount of fuel
      return this.fuel;
    }

    public void addFuel(){  //Adds fuel
      if(this.fuel<15){  //If total fuel is less than maximum, add 1 gallon
        this.fuel+=1;
      }
      else{
        System.out.println("You cannot add any more fuel!(maximum capacity)");  //Else, tell user that it's already full
      }
    }

    public void burnFuel(){  //Burns fuel
      if(this.fuel>0){  //If fuel is more than 0 gallons, burn fuel at a rate of 1 gallon plus a random fraction
        this.fuel-=1+Math.random();
      }
      else{
        System.out.println("Already out of fuel!");  //Else, tell user it's already empty
      }
    }
  }

  //This class represents a odometer of a car and tracks the total amount of mileage travelled by the car and works with the fuel gauge class to determine how much fuel in comparison to total mileage
  static class Odometer{
    private int mileage;
    FuelGauge fuelGauge;

    public Odometer(int mileage, FuelGauge fuelGauge){  //Constructor takes in an integer and FuelGauge object and assigns these values to mileage and fuel gauge
      this.mileage=mileage;
      this.fuelGauge=fuelGauge;
    }

    public int getMileage(){  //Returns mileage
      return this.mileage;
    }

    public void addMileage(){  //Adds mileage
      if(this.mileage<999999){  //If mileage is less than maximum of 999999, add 1 mile to total
        this.mileage+=1;
      }
      else{
        this.mileage=0;  //Else, just set total mileage to 0
      }
    }

    public void decreaseFuel(){  //Decrease fuel in accordance to mileage
      if(this.mileage%24==0){  //When travelled 24 miles, decrease amount of fuel in car by 1 gallon
        if(fuelGauge.fuel>0){
          fuelGauge.fuel-=1;
        }
      }
    }
  }
}
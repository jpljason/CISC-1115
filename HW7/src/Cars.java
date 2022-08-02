public class Cars{
  public static void main(String[] args){
    Car BMW = new Car(2022, "BMW");
    Car.FuelGauge fuelGaugeOfBMW = new Car.FuelGauge(0);
    Car.Odometer odometerOfBMW = new Car.Odometer(0,fuelGaugeOfBMW);
    int gallons=15;

    for(int i=1; i<=gallons; i++){
      fuelGaugeOfBMW.addFuel();
    }
    System.out.println("The starting amount of fuel that the " + BMW.getMake() + " has is " + fuelGaugeOfBMW.getFuel() + " gallons and the starting mileage is " + odometerOfBMW.getMileage() + " miles\n");
    while(fuelGaugeOfBMW.getFuel()!=0){
      for(int j=1; j<=5; j++){
        BMW.accelerate();
        System.out.println("Accelerating: The speed of " + BMW.getMake() + " is now " + BMW.getSpeed() + " miles per hour");
      }
      for(int k=1; k<=BMW.getSpeed(); k++){
        if(odometerOfBMW.getMileage()<gallons*24){
          odometerOfBMW.addMileage();
          odometerOfBMW.decreaseFuel();
        }
        else{
          break;
        }
      }
      System.out.println("Current fuel in " + BMW.getMake() + ": " + fuelGaugeOfBMW.getFuel() + " gallons");
      System.out.println("Current mileage for " + BMW.getMake() + ": " + odometerOfBMW.getMileage() + " miles");
      for(int l=1; l<=5; l++){
        BMW.brake();
        System.out.println("Braking: The speed of the " + BMW.getMake() + " is now " + BMW.getSpeed() + " miles per hour");
      }
      System.out.println();
    }
  }
}

class Car{
  private int yearModel;
  private String make;
  private int speed;

  Car(int yearModel, String make){
    this.yearModel=yearModel;
    this.make=make;
    this.speed=0;
  }

  public int getYearModel(){
    return this.yearModel;
  }

  public String getMake(){
    return this.make;
  }

  public int getSpeed(){
    return this.speed;
  }

  public void accelerate(){
    if(this.speed<100){
      this.speed+=5;
    }
  }

  public void brake(){
    if(this.speed>=5){
      this.speed-=5;
    }
  }

  static class FuelGauge{
    private double fuel;

    public FuelGauge(double fuel){
      if(fuel<=15){
        this.fuel=fuel;
      }
      else{
        this.fuel=15;
      }
    }

    public double getFuel(){
      return this.fuel;
    }

    public void addFuel(){
      if(this.fuel<15){
        this.fuel+=1;
      }
      else{
        System.out.println("You cannot add any more fuel!(maximum capacity)");
      }
    }

    public void burnFuel(){
      if(this.fuel>0){
        this.fuel-=1+Math.random();
      }
      else{
        System.out.println("Already out of fuel!");
      }
    }
  }

  static class Odometer{
    private int mileage;
    FuelGauge fuelGauge;

    public Odometer(int mileage, FuelGauge fuelGauge){
      this.mileage=mileage;
      this.fuelGauge=fuelGauge;
    }

    public int getMileage(){
      return this.mileage;
    }

    public void addMileage(){
      if(this.mileage<999999){
        this.mileage+=1;
      }
      else{
        this.mileage=0;
      }
    }

    public void decreaseFuel(){
      if(this.mileage%24==0){
        if(fuelGauge.fuel>0){
          fuelGauge.fuel-=1;
        }
      }
    }
  }
}
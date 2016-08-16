package model;

import java.util.ArrayList;

public class Road
{
  private String direction;
  private ArrayList<Vehicle> currentCars;
  private Light assignedLight;

  public Road()
  {
	currentCars = new ArrayList<Vehicle>();
	assignedLight = new Light();
  }

  public String getDirection()
  {
	return direction;
  }
  
  public Light getLight()
  {
	return assignedLight;
  }

  public void addCar(Vehicle vehicle)
  {
	currentCars.add(vehicle);
  }

  public void removeCar()
  {
    currentCars.remove(0);
  }

  public ArrayList<Vehicle> getAllCars()
  {
	return this.currentCars;
  }
}

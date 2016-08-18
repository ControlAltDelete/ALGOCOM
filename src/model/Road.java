package model;

import java.util.ArrayList;

public class Road
{
  private String location;
  private ArrayList<Vehicle> currentCars;
  private Light assignedLight;

  public Road(String location)
  {
	currentCars = new ArrayList<Vehicle>();
	assignedLight = new Light();
	this.location = location;
  }

  public String getLocation()
  {
	return location;
  }
  
  public Light getLight()
  {
	return assignedLight;
  }

  public void addCar(Vehicle vehicle)
  {
	if (currentCars.size() < 10)
	{
	  currentCars.add(vehicle);
	}
  }

  public void removeCar()
  {
    currentCars.remove(0);
  }

  public ArrayList<Vehicle> getAllCars()
  {
	return this.currentCars;
  }
  
  public int getQueueSize()
  {
	return currentCars.size();
  }
}

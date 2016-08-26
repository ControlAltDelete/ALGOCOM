package controller;
import java.util.ArrayList;
import java.util.Random;

import model.Road;
import model.Vehicle;

public class RoadController
{
  private static RoadController instance = null;

  private RoadController()
  {

  }

  public RoadController getRoadController()
  {
	  if (instance == null)
	  {
	    instance = new RoadController();
	  }

	  return instance;
  }

  public void generateRandomCars(Road r, int numCars, int maxX, int maxY)
  {
	  Random rand = new Random();

	  int x = rand.nextInt(maxX);
	  int y = rand.nextInt(maxY);


  }
}

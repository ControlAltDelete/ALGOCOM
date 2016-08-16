package controller;

import java.util.ArrayList;

import model.Intersection;
import model.Road;

public class IntersectionController
{
  private static IntersectionController instance = null;

  private IntersectionController()
  {

  }

  public static IntersectionController getInstance()
  {
    if (instance == null)
    {
      instance = new IntersectionController();
    }

    return instance;
  }

  public void controlTraffic(Intersection n)
  {
    ArrayList<Road> roads = n.getRoads();
    int max = 0;
    int index = 0;
    
    for (int i = 0; i <= roads.size(); i++)
    {
      if (i < roads.size())
      {
    	max = roads.get(i).getAllCars().size();
    	index = i;
      }
      
      if (i < roads.size() - 1)
      {
    	int candidate = roads.get(i + 1).getAllCars().size();
    	
    	if (candidate > max)
    	{
    	  max = candidate;
    	  index = i;
    	}
      }
      
      else
      {
    	int candidate = roads.get(i - 1).getAllCars().size();
    	
    	if (candidate > max)
    	{
    	  max = candidate;
    	  index = i;
    	}
      }
    }
    
    System.out.println("Num of most cars: " + max + " on road number: " + index);
    roads.get(index).getLight().changeLightSignal(true);
  }
}

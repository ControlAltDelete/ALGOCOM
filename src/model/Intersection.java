package model;

import java.util.ArrayList;

public class Intersection
{
  private ArrayList<Road> roadsConnected;

  public Intersection()
  {
    roadsConnected = new ArrayList<Road>();
  }

  public void addRoad(Road r)
  {
	if (roadsConnected.size() < 4)
	{
	  roadsConnected.add(r);  
	}
	
	else
	{
	  System.out.println("Most intersection in the Philippines has only 4 roads.");
	}
    
  }

  public ArrayList<Road> getRoads()
  {
    return roadsConnected;
  }
}

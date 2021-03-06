package controller;

import java.util.ArrayList;

import com.golden.gamedev.object.SpriteGroup;

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
    int maxIndex = 0;
    
//    max = this.getMaxCar(roads, 0, roads.size() - 1);
//    
//    for (int i = 0; i < roads.size(); i++)
//    {
//      if (roads.get(i).getQueueSize() == max)
//      {
//    	maxIndex = i;
//    	i = roads.size();
//      }
//    }
//    
//    System.out.println(this.getMaxCar(roads, 0, roads.size() - 1));
    
    System.out.println("Num of most cars: " + max + " on road number: " + (maxIndex + 1)); // +1 since road number starts at #1 when displaying and #0 at arraylists
    Road roadToGo = roads.get(maxIndex);
    roadToGo.getLight().changeLightSignal(true);
  }
  
  private void transferCars(Road r, Intersection n)
  {
	if (r.getLocation().equals("North"))
	{
	  if (r.getAllCars().get(0).getDirection().equals("Southbound"))
	  {
		n.getRoads().get(1).addCar(r.getAllCars().get(0));
		r.getAllCars().remove(0);
	  }
	}
	
	else if (r.getLocation().equals("South"))
	{
	  if (r.getAllCars().get(0).getDirection().equals("Northbound"))
	  {
		n.getRoads().get(0).addCar(r.getAllCars().get(0));
	  }
	}
  }
  
  public int getMaxCar(ArrayList<SpriteGroup> roads, int start, int end)
  {
	int max = 0;
	
	if (start == end)
	{
	  return roads.get(start).getSize();
	}
	
	else
	{
	  int mid = (int) Math.floor((start + end) / 2);
	  int first = getMaxCar(roads, start, mid);
	  int second = getMaxCar(roads, mid + 1, end);
	  
	  if (first > second)
	  {
		max = first;
	  }
	  
	  else
	  {
		max = second;
	  }
	  
	  return max;
	}
  }
}

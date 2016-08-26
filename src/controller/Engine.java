package controller;

import model.Intersection;
import model.Road;

public class Engine
{
  private Intersection instWest;
  private Intersection instEast;
  private static Engine instance = null;
  
  private Engine()
  {
	this.initializeAssets();
  }
  
  private void initializeAssets()
  {
	instWest = new Intersection("West");
	instEast = new Intersection("East");
	
	Road roadNorth = new Road("North");
	Road roadSouth = new Road("South");
	Road roadWest = new Road("West");
	Road roadEast = new Road("East");
	
	instWest.addRoad(roadNorth);
	instWest.addRoad(roadSouth);
	instWest.addRoad(roadWest);
	instWest.addRoad(roadEast);
	
	instEast.addRoad(roadNorth);
	instEast.addRoad(roadSouth);
	instEast.addRoad(roadWest);
	instEast.addRoad(roadEast);
  }
  
  public static Engine getInstance()
  {
	if (instance == null)
	{
	  instance = new Engine();
	}
	
	return instance;
  }
  
  public Intersection getWestIntersection()
  {
	return instWest;
  }
  
  public Intersection getEastIntersection()
  {
	return instEast;
  }
}

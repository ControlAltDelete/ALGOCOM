package model;

public class Vehicle
{
  private int x;
  private int y;
  private String direction;

  public Vehicle(int x, int y, String direction)
  {
	this.x = x;
	this.y = y;
	this.direction = direction;
  }

  public int getXPos()
  {
	return x;
  }

  public int getYPos()
  {
	return y;
  }
  
  public String getDirection()
  {
	return direction;
  }

  public boolean decideIfTurn()
  {
    return true;
  }
}

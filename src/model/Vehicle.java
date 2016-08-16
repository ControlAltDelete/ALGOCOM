package model;

public class Vehicle
{
  private int x;
  private int y;
  private String direction;

  public Vehicle(int x, int y)
  {
	this.x = x;
	this.y = y;
  }

  public int getXPos()
  {
	return x;
  }

  public int getYPos()
  {
	return y;
  }

  public boolean decideIfTurn()
  {
    return true;
  }
}

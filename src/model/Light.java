package model;

public class Light
{
  private boolean ifGo;
  private boolean willTurn;

  public Light()
  {
    ifGo = false;
    willTurn = false;
  }

  public boolean canGo()
  {
    return ifGo;
  }

  public boolean canTurn()
  {
    return willTurn;
  }

  public void changeLightSignal(boolean lightSignal)
  {
    ifGo = lightSignal;
  }
}

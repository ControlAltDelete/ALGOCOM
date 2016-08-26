package controller;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

public class CollisionController extends BasicCollisionGroup
{

  @Override
  public void collided(Sprite s1, Sprite s22)
  {
	// TODO Auto-generated method stub
	
	System.out.println("collide");
	
  }

}

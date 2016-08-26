package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.background.ImageBackground;

import controller.CollisionController;
import controller.IntersectionController;

public class DynamicLight extends Game
{
  private SpriteGroup NORTH_GROUP;
  private SpriteGroup WEST_GROUP;
  private SpriteGroup EAST_GROUP;
  private SpriteGroup SOUTH_GROUP;
  
  private BufferedImage gameBg;
  private ImageBackground imgBg;
  
  private boolean movementStopper = false;
  private CollisionController collisionDetect;
  
  private ArrayList<SpriteGroup> roads = new ArrayList<SpriteGroup>();

  @Override
  public void initResources()
  {
	// TODO Auto-generated method stub
	SOUTH_GROUP = new SpriteGroup("South");
	NORTH_GROUP = new SpriteGroup("North");
	WEST_GROUP = new SpriteGroup("West");
	EAST_GROUP = new SpriteGroup("East");
	
	SOUTH_GROUP.add(new Sprite(getImage("resources/images/car.png"), 272.5, 354.5));
	SOUTH_GROUP.add(new Sprite(getImage("resources/images/car.png"), 272.5, 419.8));
	SOUTH_GROUP.add(new Sprite(getImage("resources/images/car.png"), 299.4, 354.5));
	SOUTH_GROUP.add(new Sprite(getImage("resources/images/car.png"), 299.2, 418.6));
	
	WEST_GROUP.add(new Sprite(getImage("resources/images/carRight.png"), 113.9, 239));
	WEST_GROUP.add(new Sprite(getImage("resources/images/carRight.png"), 49.2, 240.6));
	WEST_GROUP.add(new Sprite(getImage("resources/images/carRight.png"), 112.5, 278.8));
	
	NORTH_GROUP.add(new Sprite(getImage("resources/images/carDown.png"), 227.7, 91.4));
	NORTH_GROUP.add(new Sprite(getImage("resources/images/carDown.png"), 197.6, 90.3));
	
	roads.add(NORTH_GROUP);
	roads.add(SOUTH_GROUP);
	roads.add(WEST_GROUP);
	roads.add(EAST_GROUP);
	
	
	gameBg = getImage("resources/images/intersection.jpg");
	imgBg = new ImageBackground(gameBg, 640, 480);
	
	collisionDetect = new CollisionController();
  }

  @Override
  public void render(Graphics2D g)
  {
	// TODO Auto-generated method stub
	imgBg.render(g);
	SOUTH_GROUP.render(g);
	NORTH_GROUP.render(g);
	WEST_GROUP.render(g);
	EAST_GROUP.render(g);
  }

  @Override
  public void update(long elapsedTime)
  {
	// TODO Auto-generated method stub
	//this.movePlayer(elapsedTime, SOUTH_GROUP.getActiveSprite(), SOUTH_GROUP);
	this.chooseRoad(elapsedTime);
	this.despawn();
	//this.spawner(SOUTH_GROUP.getActiveSprite(), elapsedTime);

  }
  
  public static void main(String[] args)
  {
	GameLoader game = new GameLoader();
	game.setup(new DynamicLight(), new Dimension(640, 480), false);
	game.start();
  }
  
  private void movePlayer(long elapsedTime, Sprite sprite, SpriteGroup sprites)
  {
	String movement;
	
	if (keyDown(KeyEvent.VK_DOWN) && !movementStopper)
	{
	  movementStopper = true;
	  movement = "down";
	  //BufferedImage image = getImage("sprites/childforward.png");
	  sprite.move(0, 0.1 * elapsedTime);
	  //sprite.setImage(image);
	}
	
	if (keyDown(KeyEvent.VK_LEFT) && !movementStopper)
	{
	  movementStopper = true;
	  movement = "left";
	  //BufferedImage image = getImage("sprites/childleft.png");
	  sprite.move(-0.1 * elapsedTime, 0);
	  //sprite.setImage(image);
	}
	
	if (keyDown(KeyEvent.VK_RIGHT) && !movementStopper)
	{
	  movementStopper = true;
	  movement = "right";
	  //BufferedImage image = getImage("sprites/childright.png");
	  sprite.move(0.1 * elapsedTime, 0);
	  //sprite.setImage(image);
	}
	
	if (keyDown(KeyEvent.VK_UP) && !movementStopper)
	{
	  movementStopper = true;
	  movement = "up";
	  //BufferedImage image = getImage("sprites/childbackward.png");
	  sprite.move(0, -0.1 * elapsedTime);
	  //sprite.setImage(image);
	}
	
	movementStopper = false;
	
	System.out.println(sprite.getX() + " " + sprite.getY());
  }
  
//  private void despawn(ArrayList<SpriteGroup> roads)
//  {
//	for (int i = 0; i  <roads.size())
//  }
  
  private void chooseRoad(long elapsedTime)
  {
	IntersectionController ic = IntersectionController.getInstance();
	int max = ic.getMaxCar(roads, 0, roads.size() - 1);
	int index = 0;
	
	for (int i = 0; i < roads.size(); i++)
	{
	  if (roads.get(i).getSize() == max)
	  {
		index = i;
		i = roads.size();
	  }
	}
	
	SpriteGroup cand = roads.get(index);
	
	for (int i = 0; i < cand.getSize(); i++)
	{
	  Sprite s = cand.getSprites()[i];
	  String direction = cand.getName();
	  
	  if (direction.equals("West"))
	  {
		s.move(0.1 * elapsedTime, 0);
	  }
	  
	  else if (direction.equals("South"))
	  {
		s.move(0, -0.1 * elapsedTime);
	  }
	  
	  else if (direction.equals("North"))
	  {
		s.move(0, 0.1 * elapsedTime);
	  }
	  
	  else if (direction.equals("East"))
	  {
		s.move(-0.1 * elapsedTime, 0);
	  }
	}
  }
  
  private void despawn()
  {
	if (SOUTH_GROUP.getActiveSprite().getY() < 48.00)
	{
	  for (int i = 0; i < SOUTH_GROUP.getSize(); i++)
	  {
		Sprite s = SOUTH_GROUP.getSprites()[i];
		
		SOUTH_GROUP.remove(i);
	  }
	}
  }
  
  private void spawner(Sprite sprite, long elapsedTime)
  {
	if (sprite.getX() == 272.5)
	{
	  if (sprite.getY() < 354.5)
	  {
		SOUTH_GROUP.add(new Sprite(getImage("resources/images/car.png"), 272.5, 419.8));
		sprite.move(0, -0.1 * elapsedTime);
	  }
	}
  }
}

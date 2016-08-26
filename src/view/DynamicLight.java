package view;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.background.ImageBackground;

public class DynamicLight extends Game
{
  private BufferedImage gameBg;
  private ImageBackground imgBg;

  @Override
  public void initResources()
  {
	// TODO Auto-generated method stub
	
  }

  @Override
  public void render(Graphics2D arg0)
  {
	// TODO Auto-generated method stub
	
  }

  @Override
  public void update(long arg0)
  {
	// TODO Auto-generated method stub
	
  }
  
  public static void main(String[] args)
  {
	GameLoader game = new GameLoader();
	game.setup(new DynamicLight(), new Dimension(640, 480), false);
	game.start();
  }

}

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.IntersectionController;
import model.Intersection;
import model.Road;
import model.Vehicle;

public class MainWindow
{

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
	EventQueue.invokeLater(new Runnable()
	{
	  public void run()
	  {
		try
		{
		  MainWindow window = new MainWindow();
		  window.frame.setVisible(true);
		} catch (Exception e)
		{
		  e.printStackTrace();
		}
	  }
	});
  }

  /**
   * Create the application.
   */
  public MainWindow()
  {
	initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize()
  {
	frame = new JFrame();
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Vehicle veh = new Vehicle(1, 10);
	Road road1 = new Road("North");
	road1.addCar(veh);
	road1.addCar(veh);
	road1.addCar(veh);
	road1.addCar(veh);
	
	Road road2 = new Road("South");
	road2.addCar(veh);
	
	Road road3 = new Road("East");
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	road3.addCar(veh);
	
	Road road4 = new Road("West");
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	road4.addCar(veh);
	
	Intersection inter = new Intersection("West");
	
	inter.addRoad(road1);
	inter.addRoad(road2);
	inter.addRoad(road3);
	inter.addRoad(road4);
	inter.addRoad(road4);
	
	IntersectionController iController = IntersectionController.getInstance();
	iController.controlTraffic(inter);
  }

}

package hw3;

import java.util.List;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class SimWindow implements DrawListener{

	// Some static constants that everyone can use
	//   the represent the window size
	public final static int windowWidth = 1050;
	public final static int windowHeight = 700;

	private TerrainMap tm;
	private List<Avatar> animals;
	private Draw duDwin;
	private Avatar human;

	public SimWindow(TerrainMap tm, List<Avatar> animals, Human human) {

		// Setup the DuDraw window
		duDwin = new Draw("COMP2381 Animal Simulation"); // The OO version of DUDraw
		duDwin.setCanvasSize(SimWindow.windowWidth, SimWindow.windowHeight);
		duDwin.enableDoubleBuffering(); // Too slow otherwise -- need to use .show() later

		// Set the scale of the window
		// Right now it is set to match the pixels
		duDwin.setXscale(0, tm.gridWidth);
		duDwin.setYscale(0, tm.gridHeight);
		
		// For accessibility purposes, set the map, animals, and the human
		this.tm = tm;
		this.animals = animals;
		this.human = human;
	}

	public void update() {
		// TODO: Clear the entire window to white and draw the TerrainMap
		duDwin.clear();
		tm.draw(duDwin);
		
		// Go through the list of animals, move and draw each one
		for(Avatar a : animals) {
			a.move();
			a.draw(duDwin);
		}
		
		// Draw the human
		this.human.draw(duDwin);
		
		duDwin.show();  // used in double buffering
	}

	public void runSimulation() {
		// This is the main game loop
		update(); // Initial positing

		while(true) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			update();
		}	
	}

	
	// All of this are methods that need to be here for the implementation
	@Override
	public void keyPressed(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(char arg0) {
		// TODO Auto-generated method stub
		
	}

	// I attempted to use my human move here
	@Override
	public void mouseClicked(double arg0, double arg1) {
		// TODO Auto-generated method stub
		System.out.println(arg0 + ", " + arg1);
		((Human) this.human).humanMove((int)arg0, (int)arg1);
		
	}

	@Override
	public void mouseDragged(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}
	
	// And here
	@Override
	public void mousePressed(double arg0, double arg1) {
		// TODO Auto-generated method stub
		System.out.println(arg0 + ", " + arg1);
		
	}

	@Override
	public void mouseReleased(double arg0, double arg1) {
		// TODO Auto-generated method stub
		
	}
}